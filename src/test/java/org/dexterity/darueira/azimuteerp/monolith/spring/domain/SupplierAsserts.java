package org.dexterity.darueira.azimuteerp.monolith.spring.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSupplierAllPropertiesEquals(Supplier expected, Supplier actual) {
        assertSupplierAutoGeneratedPropertiesEquals(expected, actual);
        assertSupplierAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSupplierAllUpdatablePropertiesEquals(Supplier expected, Supplier actual) {
        assertSupplierUpdatableFieldsEquals(expected, actual);
        assertSupplierUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSupplierAutoGeneratedPropertiesEquals(Supplier expected, Supplier actual) {
        assertThat(expected)
            .as("Verify Supplier auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSupplierUpdatableFieldsEquals(Supplier expected, Supplier actual) {
        assertThat(expected)
            .as("Verify Supplier relevant properties")
            .satisfies(e -> assertThat(e.getAcronym()).as("check acronym").isEqualTo(actual.getAcronym()))
            .satisfies(e -> assertThat(e.getCompanyName()).as("check companyName").isEqualTo(actual.getCompanyName()))
            .satisfies(e -> assertThat(e.getStreetAddress()).as("check streetAddress").isEqualTo(actual.getStreetAddress()))
            .satisfies(e -> assertThat(e.getHouseNumber()).as("check houseNumber").isEqualTo(actual.getHouseNumber()))
            .satisfies(e -> assertThat(e.getLocationName()).as("check locationName").isEqualTo(actual.getLocationName()))
            .satisfies(e -> assertThat(e.getCity()).as("check city").isEqualTo(actual.getCity()))
            .satisfies(e -> assertThat(e.getStateProvince()).as("check stateProvince").isEqualTo(actual.getStateProvince()))
            .satisfies(e -> assertThat(e.getZipPostalCode()).as("check zipPostalCode").isEqualTo(actual.getZipPostalCode()))
            .satisfies(e -> assertThat(e.getCountryRegion()).as("check countryRegion").isEqualTo(actual.getCountryRegion()))
            .satisfies(e -> assertThat(e.getPointLocation()).as("check pointLocation").isEqualTo(actual.getPointLocation()))
            .satisfies(
                e ->
                    assertThat(e.getPointLocationContentType())
                        .as("check pointLocation contenty type")
                        .isEqualTo(actual.getPointLocationContentType())
            )
            .satisfies(e -> assertThat(e.getMainEmail()).as("check mainEmail").isEqualTo(actual.getMainEmail()))
            .satisfies(e -> assertThat(e.getPhoneNumber1()).as("check phoneNumber1").isEqualTo(actual.getPhoneNumber1()))
            .satisfies(e -> assertThat(e.getPhoneNumber2()).as("check phoneNumber2").isEqualTo(actual.getPhoneNumber2()))
            .satisfies(
                e ->
                    assertThat(e.getCustomAttributesDetailsJSON())
                        .as("check customAttributesDetailsJSON")
                        .isEqualTo(actual.getCustomAttributesDetailsJSON())
            )
            .satisfies(e -> assertThat(e.getActivationStatus()).as("check activationStatus").isEqualTo(actual.getActivationStatus()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertSupplierUpdatableRelationshipsEquals(Supplier expected, Supplier actual) {
        assertThat(expected)
            .as("Verify Supplier relationships")
            .satisfies(
                e -> assertThat(e.getRepresentativePerson()).as("check representativePerson").isEqualTo(actual.getRepresentativePerson())
            )
            .satisfies(e -> assertThat(e.getToProducts()).as("check toProducts").isEqualTo(actual.getToProducts()));
    }
}
