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

describe('Person e2e test', () => {
  const personPageUrl = '/person';
  const personPageUrlPattern = new RegExp('/person(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'user';
  const password = Cypress.env('E2E_PASSWORD') ?? 'user';
  const personSample = {
    firstname: 'blindly till',
    lastname: 'for which',
    birthDate: '2024-06-06',
    gender: 'OTHER',
    streetAddress: 'cavernous',
    postalCode: 'except en',
    mainEmail: '(7@d5itg.Do+',
    activationStatus: 'INACTIVE',
  };

  let person;
  let typeOfPerson;

  beforeEach(() => {
    cy.login(username, password);
  });

  beforeEach(() => {
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/type-of-people',
      body: { code: 'selfi', description: 'since brr provided' },
    }).then(({ body }) => {
      typeOfPerson = body;
    });
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/people+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/people').as('postEntityRequest');
    cy.intercept('DELETE', '/api/people/*').as('deleteEntityRequest');
  });

  beforeEach(() => {
    // Simulate relationships api for better performance and reproducibility.
    cy.intercept('GET', '/api/type-of-people', {
      statusCode: 200,
      body: [typeOfPerson],
    });

    cy.intercept('GET', '/api/districts', {
      statusCode: 200,
      body: [],
    });

    cy.intercept('GET', '/api/people', {
      statusCode: 200,
      body: [],
    });

    cy.intercept('GET', '/api/organization-memberships', {
      statusCode: 200,
      body: [],
    });

    cy.intercept('GET', '/api/suppliers', {
      statusCode: 200,
      body: [],
    });

    cy.intercept('GET', '/api/customers', {
      statusCode: 200,
      body: [],
    });
  });

  afterEach(() => {
    if (person) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/people/${person.id}`,
      }).then(() => {
        person = undefined;
      });
    }
  });

  afterEach(() => {
    if (typeOfPerson) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/type-of-people/${typeOfPerson.id}`,
      }).then(() => {
        typeOfPerson = undefined;
      });
    }
  });

  it('People menu should load People page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('person');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response?.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Person').should('exist');
    cy.url().should('match', personPageUrlPattern);
  });

  describe('Person page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(personPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create Person page', () => {
        cy.get(entityCreateButtonSelector).click();
        cy.url().should('match', new RegExp('/person/new$'));
        cy.getEntityCreateUpdateHeading('Person');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', personPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/people',
          body: {
            ...personSample,
            typeOfPerson: typeOfPerson,
          },
        }).then(({ body }) => {
          person = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/people+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/people?page=0&size=20>; rel="last",<http://localhost/api/people?page=0&size=20>; rel="first"',
              },
              body: [person],
            },
          ).as('entitiesRequestInternal');
        });

        cy.visit(personPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details Person page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('person');
        cy.get(entityDetailsBackButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', personPageUrlPattern);
      });

      it('edit button click should load edit Person page and go back', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Person');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', personPageUrlPattern);
      });

      it('edit button click should load edit Person page and save', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('Person');
        cy.get(entityCreateSaveButtonSelector).click();
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', personPageUrlPattern);
      });

      it('last delete button click should delete instance of Person', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('person').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click();
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response?.statusCode).to.equal(200);
        });
        cy.url().should('match', personPageUrlPattern);

        person = undefined;
      });
    });
  });

  describe('new Person page', () => {
    beforeEach(() => {
      cy.visit(`${personPageUrl}`);
      cy.get(entityCreateButtonSelector).click();
      cy.getEntityCreateUpdateHeading('Person');
    });

    it('should create an instance of Person', () => {
      cy.get(`[data-cy="firstname"]`).type('clever brief');
      cy.get(`[data-cy="firstname"]`).should('have.value', 'clever brief');

      cy.get(`[data-cy="lastname"]`).type('vivacious prejudge');
      cy.get(`[data-cy="lastname"]`).should('have.value', 'vivacious prejudge');

      cy.get(`[data-cy="fullname"]`).type('slot ah');
      cy.get(`[data-cy="fullname"]`).should('have.value', 'slot ah');

      cy.get(`[data-cy="birthDate"]`).type('2024-06-07');
      cy.get(`[data-cy="birthDate"]`).blur();
      cy.get(`[data-cy="birthDate"]`).should('have.value', '2024-06-07');

      cy.get(`[data-cy="gender"]`).select('OTHER');

      cy.get(`[data-cy="codeBI"]`).type('drink ack likely');
      cy.get(`[data-cy="codeBI"]`).should('have.value', 'drink ack likely');

      cy.get(`[data-cy="codeNIF"]`).type('but');
      cy.get(`[data-cy="codeNIF"]`).should('have.value', 'but');

      cy.get(`[data-cy="streetAddress"]`).type('aboard furthermore');
      cy.get(`[data-cy="streetAddress"]`).should('have.value', 'aboard furthermore');

      cy.get(`[data-cy="houseNumber"]`).type('pledge shut phew');
      cy.get(`[data-cy="houseNumber"]`).should('have.value', 'pledge shut phew');

      cy.get(`[data-cy="locationName"]`).type('evaporate');
      cy.get(`[data-cy="locationName"]`).should('have.value', 'evaporate');

      cy.get(`[data-cy="postalCode"]`).type('alongside');
      cy.get(`[data-cy="postalCode"]`).should('have.value', 'alongside');

      cy.get(`[data-cy="mainEmail"]`).type('$u(}@2G!~#.!!PR');
      cy.get(`[data-cy="mainEmail"]`).should('have.value', '$u(}@2G!~#.!!PR');

      cy.get(`[data-cy="landPhoneNumber"]`).type('meanwhile blah');
      cy.get(`[data-cy="landPhoneNumber"]`).should('have.value', 'meanwhile blah');

      cy.get(`[data-cy="mobilePhoneNumber"]`).type('um huzzah busil');
      cy.get(`[data-cy="mobilePhoneNumber"]`).should('have.value', 'um huzzah busil');

      cy.get(`[data-cy="occupation"]`).type('ew ingratiate');
      cy.get(`[data-cy="occupation"]`).should('have.value', 'ew ingratiate');

      cy.get(`[data-cy="preferredLanguage"]`).type('vanda');
      cy.get(`[data-cy="preferredLanguage"]`).should('have.value', 'vanda');

      cy.get(`[data-cy="usernameInOAuth2"]`).type('unlike');
      cy.get(`[data-cy="usernameInOAuth2"]`).should('have.value', 'unlike');

      cy.get(`[data-cy="userIdInOAuth2"]`).type('clobber immediately heart-throb');
      cy.get(`[data-cy="userIdInOAuth2"]`).should('have.value', 'clobber immediately heart-throb');

      cy.get(`[data-cy="customAttributesDetailsJSON"]`).type('mitre');
      cy.get(`[data-cy="customAttributesDetailsJSON"]`).should('have.value', 'mitre');

      cy.get(`[data-cy="activationStatus"]`).select('INVALID');

      cy.setFieldImageAsBytesOfEntity('avatarImg', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="typeOfPerson"]`).select(1);

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(201);
        person = response.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response?.statusCode).to.equal(200);
      });
      cy.url().should('match', personPageUrlPattern);
    });
  });
});
