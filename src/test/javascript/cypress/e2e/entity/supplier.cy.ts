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

describe('Supplier e2e test', () => {
  const supplierPageUrl = '/supplier';
  const supplierPageUrlPattern = new RegExp('/supplier(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const supplierSample = { acronym: 'yet', companyName: 'what since', streetAddress: 'pish impressionable freely' };

  let supplier;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/suppliers+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/suppliers').as('postEntityRequest');
    cy.intercept('DELETE', '/api/suppliers/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (supplier) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/suppliers/${supplier.id}`,
      }).then(() => {
        supplier = undefined;
      });
    }
  });

  it('Suppliers menu should load Suppliers page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('supplier');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response?.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Supplier').should('exist');
    cy.url().should('match', supplierPageUrlPattern);
  });

  describe('Supplier page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(supplierPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Supplier page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/supplier/new$'));
        cy.getEntityCreateUpdateHeading('Supplier');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', supplierPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/suppliers',
          body: supplierSample,
        }).then(({ body }) => {
          supplier = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/suppliers+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/suppliers?page=0&size=20>; rel="last",<http://localhost/api/suppliers?page=0&size=20>; rel="first"',
              },
              body: [supplier],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(supplierPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Supplier page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('supplier');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', supplierPageUrlPattern);
      });

      it('edit button click should load edit Supplier page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Supplier');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', supplierPageUrlPattern);
      });

      it('edit button click should load edit Supplier page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Supplier');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', supplierPageUrlPattern);
      });

      it('last delete button click should delete instance of Supplier', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('supplier').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', supplierPageUrlPattern);

        supplier = undefined;
      });
    });
  });

  describe('new Supplier page', () => {
    beforeEach(() => {
      cy.visit(`${supplierPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Supplier');
    });

    it('should create an instance of Supplier', () => {
      cy.get(`[data-cy="acronym"]`).type('mid than canal');
      cy.get(`[data-cy="acronym"]`).should('have.value', 'mid than canal');

      cy.get(`[data-cy="companyName"]`).type('blissfully');
      cy.get(`[data-cy="companyName"]`).should('have.value', 'blissfully');

      cy.get(`[data-cy="representativeLastName"]`).type('ugh heart-throb inventory');
      cy.get(`[data-cy="representativeLastName"]`).should('have.value', 'ugh heart-throb inventory');

      cy.get(`[data-cy="representativeFirstName"]`).type('after even anenst');
      cy.get(`[data-cy="representativeFirstName"]`).should('have.value', 'after even anenst');

      cy.get(`[data-cy="jobTitle"]`).type('Legacy Creative Executive');
      cy.get(`[data-cy="jobTitle"]`).should('have.value', 'Legacy Creative Executive');

      cy.get(`[data-cy="streetAddress"]`).type('blurt who boom');
      cy.get(`[data-cy="streetAddress"]`).should('have.value', 'blurt who boom');

      cy.get(`[data-cy="houseNumber"]`).type('toward select public');
      cy.get(`[data-cy="houseNumber"]`).should('have.value', 'toward select public');

      cy.get(`[data-cy="locationName"]`).type('yahoo truthful astrologer');
      cy.get(`[data-cy="locationName"]`).should('have.value', 'yahoo truthful astrologer');

      cy.get(`[data-cy="city"]`).type('East Noemiland');
      cy.get(`[data-cy="city"]`).should('have.value', 'East Noemiland');

      cy.get(`[data-cy="stateProvince"]`).type('hm nutty');
      cy.get(`[data-cy="stateProvince"]`).should('have.value', 'hm nutty');

      cy.get(`[data-cy="zipPostalCode"]`).type('posset whether');
      cy.get(`[data-cy="zipPostalCode"]`).should('have.value', 'posset whether');

      cy.get(`[data-cy="countryRegion"]`).type('athwart mechanically amongst');
      cy.get(`[data-cy="countryRegion"]`).should('have.value', 'athwart mechanically amongst');

      cy.get(`[data-cy="webPage"]`).type('../fake-data/blob/hipster.txt');
      cy.get(`[data-cy="webPage"]`).invoke('val').should('match', new RegExp('../fake-data/blob/hipster.txt'));

      cy.setFieldImageAsBytesOfEntity('pointLocation', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="mainEmail"]`).type('+@A2fE.M');
      cy.get(`[data-cy="mainEmail"]`).should('have.value', '+@A2fE.M');

      cy.get(`[data-cy="landPhoneNumber"]`).type('shyly slither v');
      cy.get(`[data-cy="landPhoneNumber"]`).should('have.value', 'shyly slither v');

      cy.get(`[data-cy="mobilePhoneNumber"]`).type('insubstantial');
      cy.get(`[data-cy="mobilePhoneNumber"]`).should('have.value', 'insubstantial');

      cy.get(`[data-cy="faxNumber"]`).type('gadzooks');
      cy.get(`[data-cy="faxNumber"]`).should('have.value', 'gadzooks');

      cy.get(`[data-cy="extraDetails"]`).type('../fake-data/blob/hipster.txt');
      cy.get(`[data-cy="extraDetails"]`).invoke('val').should('match', new RegExp('../fake-data/blob/hipster.txt'));

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(201);
        supplier = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(200);
      });
      cy.url().should('match', supplierPageUrlPattern);
    });
  });
});
