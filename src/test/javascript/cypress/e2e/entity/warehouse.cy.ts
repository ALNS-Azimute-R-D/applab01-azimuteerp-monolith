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

describe('Warehouse e2e test', () => {
  const warehousePageUrl = '/warehouse';
  const warehousePageUrlPattern = new RegExp('/warehouse(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const warehouseSample = {
    acronym: 'given',
    name: 'ouch',
    streetAddress: 'vaguely unless prey',
    postalCode: 'bug meanw',
    activationStatus: 'INACTIVE',
  };

  let warehouse;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/warehouses+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/warehouses').as('postEntityRequest');
    cy.intercept('DELETE', '/api/warehouses/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (warehouse) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/warehouses/${warehouse.id}`,
      }).then(() => {
        warehouse = undefined;
      });
    }
  });

  it('Warehouses menu should load Warehouses page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('warehouse');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response?.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Warehouse').should('exist');
    cy.url().should('match', warehousePageUrlPattern);
  });

  describe('Warehouse page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(warehousePageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Warehouse page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/warehouse/new$'));
        cy.getEntityCreateUpdateHeading('Warehouse');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', warehousePageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/warehouses',
          body: warehouseSample,
        }).then(({ body }) => {
          warehouse = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/warehouses+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/warehouses?page=0&size=20>; rel="last",<http://localhost/api/warehouses?page=0&size=20>; rel="first"',
              },
              body: [warehouse],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(warehousePageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Warehouse page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('warehouse');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', warehousePageUrlPattern);
      });

      it('edit button click should load edit Warehouse page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Warehouse');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', warehousePageUrlPattern);
      });

      it('edit button click should load edit Warehouse page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Warehouse');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', warehousePageUrlPattern);
      });

      it('last delete button click should delete instance of Warehouse', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('warehouse').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', warehousePageUrlPattern);

        warehouse = undefined;
      });
    });
  });

  describe('new Warehouse page', () => {
    beforeEach(() => {
      cy.visit(`${warehousePageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Warehouse');
    });

    it('should create an instance of Warehouse', () => {
      cy.get(`[data-cy="acronym"]`).type('from intend blah');
      cy.get(`[data-cy="acronym"]`).should('have.value', 'from intend blah');

      cy.get(`[data-cy="name"]`).type('yum instead original');
      cy.get(`[data-cy="name"]`).should('have.value', 'yum instead original');

      cy.get(`[data-cy="description"]`).type('diamond revolving meaty');
      cy.get(`[data-cy="description"]`).should('have.value', 'diamond revolving meaty');

      cy.get(`[data-cy="streetAddress"]`).type('pew pfft');
      cy.get(`[data-cy="streetAddress"]`).should('have.value', 'pew pfft');

      cy.get(`[data-cy="houseNumber"]`).type('why daily optimistic');
      cy.get(`[data-cy="houseNumber"]`).should('have.value', 'why daily optimistic');

      cy.get(`[data-cy="locationName"]`).type('when even');
      cy.get(`[data-cy="locationName"]`).should('have.value', 'when even');

      cy.get(`[data-cy="postalCode"]`).type('pantyhose');
      cy.get(`[data-cy="postalCode"]`).should('have.value', 'pantyhose');

      cy.setFieldImageAsBytesOfEntity('pointLocation', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="mainEmail"]`).type('x3H8Jp@hL5?q.k977Nk');
      cy.get(`[data-cy="mainEmail"]`).should('have.value', 'x3H8Jp@hL5?q.k977Nk');

      cy.get(`[data-cy="landPhoneNumber"]`).type('gadzooks');
      cy.get(`[data-cy="landPhoneNumber"]`).should('have.value', 'gadzooks');

      cy.get(`[data-cy="mobilePhoneNumber"]`).type('appreciate mmm');
      cy.get(`[data-cy="mobilePhoneNumber"]`).should('have.value', 'appreciate mmm');

      cy.get(`[data-cy="faxNumber"]`).type('bitterly astrid');
      cy.get(`[data-cy="faxNumber"]`).should('have.value', 'bitterly astrid');

      cy.get(`[data-cy="customAttributesDetailsJSON"]`).type('round aw now');
      cy.get(`[data-cy="customAttributesDetailsJSON"]`).should('have.value', 'round aw now');

      cy.get(`[data-cy="activationStatus"]`).select('ACTIVE');

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(201);
        warehouse = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(200);
      });
      cy.url().should('match', warehousePageUrlPattern);
    });
  });
});
