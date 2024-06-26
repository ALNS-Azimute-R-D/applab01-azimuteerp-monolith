package org.dexterity.darueira.azimuteerp.monolith.spring.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTypeAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCustomerTypeAllPropertiesEquals(CustomerType expected, CustomerType actual) {
        assertCustomerTypeAutoGeneratedPropertiesEquals(expected, actual);
        assertCustomerTypeAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCustomerTypeAllUpdatablePropertiesEquals(CustomerType expected, CustomerType actual) {
        assertCustomerTypeUpdatableFieldsEquals(expected, actual);
        assertCustomerTypeUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCustomerTypeAutoGeneratedPropertiesEquals(CustomerType expected, CustomerType actual) {
        assertThat(expected)
            .as("Verify CustomerType auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCustomerTypeUpdatableFieldsEquals(CustomerType expected, CustomerType actual) {
        assertThat(expected)
            .as("Verify CustomerType relevant properties")
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getDescription()).as("check description").isEqualTo(actual.getDescription()))
            .satisfies(
                e -> assertThat(e.getBusinessHandlerClazz()).as("check businessHandlerClazz").isEqualTo(actual.getBusinessHandlerClazz())
            );
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCustomerTypeUpdatableRelationshipsEquals(CustomerType expected, CustomerType actual) {}
}
