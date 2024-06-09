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

describe('Product e2e test', () => {
  const productPageUrl = '/product';
  const productPageUrlPattern = new RegExp('/product(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const productSample = { listPrice: 25886.01, discontinued: false, activationStatus: 'INACTIVE' };

  let product;
  let brand;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/brands',
      body: {
        acronym: 'gosh zowie nice',
        name: 'unnaturally',
        description: 'unto',
        logoBrand: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
        logoBrandContentType: 'unknown',
      },
    }).then(({ body }) => {
      brand = body;
    });
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/products+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/products').as('postEntityRequest');
    cy.intercept('DELETE', '/api/products/*').as('deleteEntityRequest');
  });

  beforeEach(() => {
    // Simulate relationships api for better performance and reproducibility.
    cy.intercept('GET', '/api/brands', {
      statusCode: 200,
      body: [brand],
    });

    cy.intercept('GET', '/api/suppliers', {
      statusCode: 200,
      body: [],
    });

    cy.intercept('GET', '/api/inventory-transactions', {
      statusCode: 200,
      body: [],
    });

    cy.intercept('GET', '/api/stock-levels', {
      statusCode: 200,
      body: [],
    });
  });

  afterEach(() => {
    if (product) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/products/${product.id}`,
      }).then(() => {
        product = undefined;
      });
    }
  });

  afterEach(() => {
    if (brand) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/brands/${brand.id}`,
      }).then(() => {
        brand = undefined;
      });
    }
  });

  it('Products menu should load Products page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('product');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response?.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Product').should('exist');
    cy.url().should('match', productPageUrlPattern);
  });

  describe('Product page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(productPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Product page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/product/new$'));
        cy.getEntityCreateUpdateHeading('Product');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', productPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/products',
          body: {
            ...productSample,
            brand: brand,
          },
        }).then(({ body }) => {
          product = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/products+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/products?page=0&size=20>; rel="last",<http://localhost/api/products?page=0&size=20>; rel="first"',
              },
              body: [product],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(productPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Product page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('product');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', productPageUrlPattern);
      });

      it('edit button click should load edit Product page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Product');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', productPageUrlPattern);
      });

      it('edit button click should load edit Product page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Product');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', productPageUrlPattern);
      });

      it('last delete button click should delete instance of Product', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('product').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', productPageUrlPattern);

        product = undefined;
      });
    });
  });

  describe('new Product page', () => {
    beforeEach(() => {
      cy.visit(`${productPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Product');
    });

    it('should create an instance of Product', () => {
      cy.get(`[data-cy="productSKU"]`).type('gee and');
      cy.get(`[data-cy="productSKU"]`).should('have.value', 'gee and');

      cy.get(`[data-cy="productName"]`).type('whether gee');
      cy.get(`[data-cy="productName"]`).should('have.value', 'whether gee');

      cy.get(`[data-cy="description"]`).type('vacantly');
      cy.get(`[data-cy="description"]`).should('have.value', 'vacantly');

      cy.get(`[data-cy="standardCost"]`).type('23479.42');
      cy.get(`[data-cy="standardCost"]`).should('have.value', '23479.42');

      cy.get(`[data-cy="listPrice"]`).type('26608.02');
      cy.get(`[data-cy="listPrice"]`).should('have.value', '26608.02');

      cy.get(`[data-cy="reorderLevel"]`).type('4312');
      cy.get(`[data-cy="reorderLevel"]`).should('have.value', '4312');

      cy.get(`[data-cy="targetLevel"]`).type('28444');
      cy.get(`[data-cy="targetLevel"]`).should('have.value', '28444');

      cy.get(`[data-cy="quantityPerUnit"]`).type('after grunt mortally');
      cy.get(`[data-cy="quantityPerUnit"]`).should('have.value', 'after grunt mortally');

      cy.get(`[data-cy="discontinued"]`).should('not.be.checked');
      cy.get(`[data-cy="discontinued"]`).click();
      cy.get(`[data-cy="discontinued"]`).should('be.checked');

      cy.get(`[data-cy="minimumReorderQuantity"]`).type('3713');
      cy.get(`[data-cy="minimumReorderQuantity"]`).should('have.value', '3713');

      cy.get(`[data-cy="suggestedCategory"]`).type('than');
      cy.get(`[data-cy="suggestedCategory"]`).should('have.value', 'than');

      cy.setFieldImageAsBytesOfEntity('attachments', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="activationStatus"]`).select('BLOCKED');

      cy.get(`[data-cy="brand"]`).select(1);

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(201);
        product = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(200);
      });
      cy.url().should('match', productPageUrlPattern);
    });
  });
});
