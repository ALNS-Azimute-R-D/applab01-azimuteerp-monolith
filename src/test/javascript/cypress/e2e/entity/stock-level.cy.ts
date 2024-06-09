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

describe('StockLevel e2e test', () => {
  const stockLevelPageUrl = '/stock-level';
  const stockLevelPageUrlPattern = new RegExp('/stock-level(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  // const stockLevelSample = {"lastModifiedDate":"2024-06-07T12:36:54.711Z","remainingQuantity":16643};

  let stockLevel;
  // let warehouse;
  // let product;

  beforeEach(() => {
    cy.login(username, password);
  });

  /* Disabled due to incompatibility
  beforeEach(() => {
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/warehouses',
      body: {"acronym":"vernacular since toward","name":"willfully rib beneath","description":"beyond","streetAddress":"wherever","houseNumber":"hence","locationName":"box consequently","postalCode":"as except","pointLocation":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=","pointLocationContentType":"unknown","mainEmail":"Xa@sW*Q2.htu+","landPhoneNumber":"fooey hence hye","mobilePhoneNumber":"legacy promptly","faxNumber":"extinction bene","customAttributesDetailsJSON":"supposing","activationStatus":"BLOCKED"},
    }).then(({ body }) => {
      warehouse = body;
    });
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/products',
      body: {"productSKU":"promote gah silly","productName":"fatally","description":"creamy","standardCost":19489.53,"listPrice":15705.54,"reorderLevel":14444,"targetLevel":29243,"quantityPerUnit":"yuck truly","discontinued":false,"minimumReorderQuantity":1180,"suggestedCategory":"until direction","attachments":"Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=","attachmentsContentType":"unknown","activationStatus":"ACTIVE"},
    }).then(({ body }) => {
      product = body;
    });
  });
   */

  beforeEach(() => {
    cy.intercept('GET', '/api/stock-levels+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/stock-levels').as('postEntityRequest');
    cy.intercept('DELETE', '/api/stock-levels/*').as('deleteEntityRequest');
  });

  /* Disabled due to incompatibility
  beforeEach(() => {
    // Simulate relationships api for better performance and reproducibility.
    cy.intercept('GET', '/api/warehouses', {
      statusCode: 200,
      body: [warehouse],
    });

    cy.intercept('GET', '/api/products', {
      statusCode: 200,
      body: [product],
    });

  });
   */

  afterEach(() => {
    if (stockLevel) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/stock-levels/${stockLevel.id}`,
      }).then(() => {
        stockLevel = undefined;
      });
    }
  });

  /* Disabled due to incompatibility
  afterEach(() => {
    if (warehouse) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/warehouses/${warehouse.id}`,
      }).then(() => {
        warehouse = undefined;
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
  });
   */

  it('StockLevels menu should load StockLevels page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('stock-level');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response?.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('StockLevel').should('exist');
    cy.url().should('match', stockLevelPageUrlPattern);
  });

  describe('StockLevel page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(stockLevelPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create StockLevel page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/stock-level/new$'));
        cy.getEntityCreateUpdateHeading('StockLevel');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', stockLevelPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      /* Disabled due to incompatibility
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/stock-levels',
          body: {
            ...stockLevelSample,
            warehouse: warehouse,
            product: product,
          },
        }).then(({ body }) => {
          stockLevel = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/stock-levels+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/stock-levels?page=0&size=20>; rel="last",<http://localhost/api/stock-levels?page=0&size=20>; rel="first"',
              },
              body: [stockLevel],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(stockLevelPageUrl);

        cy.wait('@entitiesRequestInternal');
      });
       */

      beforeEach(function () {
        cy.visit(stockLevelPageUrl);

        cy.wait('@entitiesRequest').then(({ response }) => {
          if (response?.body.length === 0) {
            this.skip();
          }
        });
      });

      it('detail button click should load details StockLevel page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('stockLevel');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', stockLevelPageUrlPattern);
      });

      it('edit button click should load edit StockLevel page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('StockLevel');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', stockLevelPageUrlPattern);
      });

      it('edit button click should load edit StockLevel page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('StockLevel');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', stockLevelPageUrlPattern);
      });

      it.skip('last delete button click should delete instance of StockLevel', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('stockLevel').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', stockLevelPageUrlPattern);

        stockLevel = undefined;
      });
    });
  });

  describe('new StockLevel page', () => {
    beforeEach(() => {
      cy.visit(`${stockLevelPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('StockLevel');
    });

    it.skip('should create an instance of StockLevel', () => {
      cy.get(`[data-cy="lastModifiedDate"]`).type('2024-06-07T01:58');
      cy.get(`[data-cy="lastModifiedDate"]`).blur();
      cy.get(`[data-cy="lastModifiedDate"]`).should('have.value', '2024-06-07T01:58');

      cy.get(`[data-cy="remainingQuantity"]`).type('10053');
      cy.get(`[data-cy="remainingQuantity"]`).should('have.value', '10053');

      cy.get(`[data-cy="commonAttributesDetailsJSON"]`).type('windy soon');
      cy.get(`[data-cy="commonAttributesDetailsJSON"]`).should('have.value', 'windy soon');

      cy.get(`[data-cy="warehouse"]`).select(1);
      cy.get(`[data-cy="product"]`).select(1);

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(201);
        stockLevel = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(200);
      });
      cy.url().should('match', stockLevelPageUrlPattern);
    });
  });
});
