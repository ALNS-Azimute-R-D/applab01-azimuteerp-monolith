import {
  entityTableSelector,
  entityDetailsButtonSelector,
  entityDetailsBackButtonSelector,
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityCreateCancelButtonSelector,
  entityEditButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('InventoryTransaction e2e test', () => {
  const inventoryTransactionPageUrl = '/inventory-transaction';
  const inventoryTransactionPageUrlPattern = new RegExp('/inventory-transaction(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  // const inventoryTransactionSample = {"invoiceId":24683,"quantity":22484};

  let inventoryTransaction;
  // let supplier;
  // let product;
  // let warehouse;

  beforeEach(() => {
    cy.login(username, password);
  });

  /* Disabled due to incompatibility
  beforeEach(() => {
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/suppliers',
      body: {"acronym":"till good-natured consequently","companyName":"ha","representativeLastName":"until pace lasting","representativeFirstName":"self-assured","jobTitle":"Regional Web Associate","streetAddress":"deceivingly exposure water","houseNumber":"after","locationName":"mouse","city":"Marjolainestad","stateProvince":"rail","zipPostalCode":"prepone on","countryRegion":"deluge career","webPage":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=","pointLocation":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=","pointLocationContentType":"unknown","mainEmail":"8u@:AI.EsO2}","landPhoneNumber":"minor","mobilePhoneNumber":"since quizzical","faxNumber":"yahoo ick","extraDetails":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ="},
    }).then(({ body }) => {
      supplier = body;
    });
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/products',
      body: {"productSKU":"dehydrate whose","productName":"socialise","description":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=","standardCost":26727.59,"listPrice":24941.06,"reorderLevel":7855,"targetLevel":13292,"quantityPerUnit":"cordon after worst","discontinued":true,"minimumReorderQuantity":24204,"suggestedCategory":"given","attachments":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=","attachmentsContentType":"unknown","supplierIds":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ="},
    }).then(({ body }) => {
      product = body;
    });
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/warehouses',
      body: {"acronym":"strictly","name":"er gargantuan","description":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=","streetAddress":"redistrict authorized","houseNumber":"picket","locationName":"and into","postalCode":"sedately ","pointLocation":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=","pointLocationContentType":"unknown","mainEmail":"R%8U@irm%S#.Gm3g","landPhoneNumber":"ugh among","mobilePhoneNumber":"indeed however","faxNumber":"allegation","extraDetails":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ="},
    }).then(({ body }) => {
      warehouse = body;
    });
  });
   */

  beforeEach(() => {
    cy.intercept('GET', '/api/inventory-transactions+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/inventory-transactions').as('postEntityRequest');
    cy.intercept('DELETE', '/api/inventory-transactions/*').as('deleteEntityRequest');
  });

  /* Disabled due to incompatibility
  beforeEach(() => {
    // Simulate relationships api for better performance and reproducibility.
    cy.intercept('GET', '/api/suppliers', {
      statusCode: 200,
      body: [supplier],
    });

    cy.intercept('GET', '/api/products', {
      statusCode: 200,
      body: [product],
    });

    cy.intercept('GET', '/api/warehouses', {
      statusCode: 200,
      body: [warehouse],
    });

  });
   */

  afterEach(() => {
    if (inventoryTransaction) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/inventory-transactions/${inventoryTransaction.id}`,
      }).then(() => {
        inventoryTransaction = undefined;
      });
    }
  });

  /* Disabled due to incompatibility
  afterEach(() => {
    if (supplier) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/suppliers/${supplier.id}`,
      }).then(() => {
        supplier = undefined;
      });
    }
    if (product) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/products/${product.id}`,
      }).then(() => {
        product = undefined;
      });
    }
    if (warehouse) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/warehouses/${warehouse.id}`,
      }).then(() => {
        warehouse = undefined;
      });
    }
  });
   */

  it('InventoryTransactions menu should load InventoryTransactions page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('inventory-transaction');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response?.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('InventoryTransaction').should('exist');
    cy.url().should('match', inventoryTransactionPageUrlPattern);
  });

  describe('InventoryTransaction page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(inventoryTransactionPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create InventoryTransaction page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/inventory-transaction/new$'));
        cy.getEntityCreateUpdateHeading('InventoryTransaction');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', inventoryTransactionPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      /* Disabled due to incompatibility
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/inventory-transactions',
          body: {
            ...inventoryTransactionSample,
            supplier: supplier,
            product: product,
            warehouse: warehouse,
          },
        }).then(({ body }) => {
          inventoryTransaction = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/inventory-transactions+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/inventory-transactions?page=0&size=20>; rel="last",<http://localhost/api/inventory-transactions?page=0&size=20>; rel="first"',
              },
              body: [inventoryTransaction],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(inventoryTransactionPageUrl);

        cy.wait('@entitiesRequestInternal');
      });
       */

      beforeEach(function () {
        cy.visit(inventoryTransactionPageUrl);

        cy.wait('@entitiesRequest').then(({ response }) => {
          if (response?.body.length === 0) {
            this.skip();
          }
        });
      });

      it('detail button click should load details InventoryTransaction page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('inventoryTransaction');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', inventoryTransactionPageUrlPattern);
      });

      it('edit button click should load edit InventoryTransaction page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('InventoryTransaction');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', inventoryTransactionPageUrlPattern);
      });

      it('edit button click should load edit InventoryTransaction page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('InventoryTransaction');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', inventoryTransactionPageUrlPattern);
      });

      it.skip('last delete button click should delete instance of InventoryTransaction', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('inventoryTransaction').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', inventoryTransactionPageUrlPattern);

        inventoryTransaction = undefined;
      });
    });
  });

  describe('new InventoryTransaction page', () => {
    beforeEach(() => {
      cy.visit(`${inventoryTransactionPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('InventoryTransaction');
    });

    it.skip('should create an instance of InventoryTransaction', () => {
      cy.get(`[data-cy="invoiceId"]`).type('30652');
      cy.get(`[data-cy="invoiceId"]`).should('have.value', '30652');

      cy.get(`[data-cy="transactionCreatedDate"]`).type('2024-06-03T19:36');
      cy.get(`[data-cy="transactionCreatedDate"]`).blur();
      cy.get(`[data-cy="transactionCreatedDate"]`).should('have.value', '2024-06-03T19:36');

      cy.get(`[data-cy="transactionModifiedDate"]`).type('2024-06-03T08:01');
      cy.get(`[data-cy="transactionModifiedDate"]`).blur();
      cy.get(`[data-cy="transactionModifiedDate"]`).should('have.value', '2024-06-03T08:01');

      cy.get(`[data-cy="quantity"]`).type('3903');
      cy.get(`[data-cy="quantity"]`).should('have.value', '3903');

      cy.get(`[data-cy="comments"]`).type('nestmate controller likely');
      cy.get(`[data-cy="comments"]`).should('have.value', 'nestmate controller likely');

      cy.get(`[data-cy="supplier"]`).select(1);
      cy.get(`[data-cy="product"]`).select(1);
      cy.get(`[data-cy="warehouse"]`).select(1);

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(201);
        inventoryTransaction = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(200);
      });
      cy.url().should('match', inventoryTransactionPageUrlPattern);
    });
  });
});
