package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.AssertUtils.bigDecimalCompareTo;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPaymentAllPropertiesEquals(Payment expected, Payment actual) {
        assertPaymentAutoGeneratedPropertiesEquals(expected, actual);
        assertPaymentAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPaymentAllUpdatablePropertiesEquals(Payment expected, Payment actual) {
        assertPaymentUpdatableFieldsEquals(expected, actual);
        assertPaymentUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPaymentAutoGeneratedPropertiesEquals(Payment expected, Payment actual) {
        assertThat(expected)
            .as("Verify Payment auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPaymentUpdatableFieldsEquals(Payment expected, Payment actual) {
        assertThat(expected)
            .as("Verify Payment relevant properties")
            .satisfies(e -> assertThat(e.getInstallmentNumber()).as("check installmentNumber").isEqualTo(actual.getInstallmentNumber()))
            .satisfies(e -> assertThat(e.getPaymentDueDate()).as("check paymentDueDate").isEqualTo(actual.getPaymentDueDate()))
            .satisfies(e -> assertThat(e.getPaymentPaidDate()).as("check paymentPaidDate").isEqualTo(actual.getPaymentPaidDate()))
            .satisfies(
                e ->
                    assertThat(e.getPaymentAmount())
                        .as("check paymentAmount")
                        .usingComparator(bigDecimalCompareTo)
                        .isEqualTo(actual.getPaymentAmount())
            )
            .satisfies(e -> assertThat(e.getTypeOfPayment()).as("check typeOfPayment").isEqualTo(actual.getTypeOfPayment()))
            .satisfies(e -> assertThat(e.getStatus()).as("check status").isEqualTo(actual.getStatus()))
            .satisfies(e -> assertThat(e.getExtraDetails()).as("check extraDetails").isEqualTo(actual.getExtraDetails()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertPaymentUpdatableRelationshipsEquals(Payment expected, Payment actual) {
        assertThat(expected)
            .as("Verify Payment relationships")
            .satisfies(e -> assertThat(e.getPaymentMethod()).as("check paymentMethod").isEqualTo(actual.getPaymentMethod()));
    }
}