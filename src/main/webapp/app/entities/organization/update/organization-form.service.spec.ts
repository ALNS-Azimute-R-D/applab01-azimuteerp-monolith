import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../organization.test-samples';

import { OrganizationFormService } from './organization-form.service';

describe('Organization Form Service', () => {
  let service: OrganizationFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganizationFormService);
  });

  describe('Service methods', () => {
    describe('createOrganizationFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createOrganizationFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            acronym: expect.any(Object),
            businessCode: expect.any(Object),
            hierarchicalLevel: expect.any(Object),
            name: expect.any(Object),
            description: expect.any(Object),
            businessHandlerClazz: expect.any(Object),
            mainContactPersonDetailsJSON: expect.any(Object),
            technicalEnvironmentsDetailsJSON: expect.any(Object),
            customAttributesDetailsJSON: expect.any(Object),
            organizationStatus: expect.any(Object),
            activationStatus: expect.any(Object),
            logoImg: expect.any(Object),
            tenant: expect.any(Object),
            typeOfOrganization: expect.any(Object),
            organizationParent: expect.any(Object),
          }),
        );
      });

      it('passing IOrganization should create a new form with FormGroup', () => {
        const formGroup = service.createOrganizationFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            acronym: expect.any(Object),
            businessCode: expect.any(Object),
            hierarchicalLevel: expect.any(Object),
            name: expect.any(Object),
            description: expect.any(Object),
            businessHandlerClazz: expect.any(Object),
            mainContactPersonDetailsJSON: expect.any(Object),
            technicalEnvironmentsDetailsJSON: expect.any(Object),
            customAttributesDetailsJSON: expect.any(Object),
            organizationStatus: expect.any(Object),
            activationStatus: expect.any(Object),
            logoImg: expect.any(Object),
            tenant: expect.any(Object),
            typeOfOrganization: expect.any(Object),
            organizationParent: expect.any(Object),
          }),
        );
      });
    });

    describe('getOrganization', () => {
      it('should return NewOrganization for default Organization initial value', () => {
        const formGroup = service.createOrganizationFormGroup(sampleWithNewData);

        const organization = service.getOrganization(formGroup) as any;

        expect(organization).toMatchObject(sampleWithNewData);
      });

      it('should return NewOrganization for empty Organization initial value', () => {
        const formGroup = service.createOrganizationFormGroup();

        const organization = service.getOrganization(formGroup) as any;

        expect(organization).toMatchObject({});
      });

      it('should return IOrganization', () => {
        const formGroup = service.createOrganizationFormGroup(sampleWithRequiredData);

        const organization = service.getOrganization(formGroup) as any;

        expect(organization).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing IOrganization should not enable id FormControl', () => {
        const formGroup = service.createOrganizationFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewOrganization should disable id FormControl', () => {
        const formGroup = service.createOrganizationFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});
