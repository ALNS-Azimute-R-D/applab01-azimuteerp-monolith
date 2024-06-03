package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.InvoiceTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.PaymentMethodTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class InvoiceTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Invoice.class);
        Invoice invoice1 = getInvoiceSample1();
        Invoice invoice2 = new Invoice();
        assertThat(invoice1).isNotEqualTo(invoice2);

        invoice2.setId(invoice1.getId());
        assertThat(invoice1).isEqualTo(invoice2);

        invoice2 = getInvoiceSample2();
        assertThat(invoice1).isNotEqualTo(invoice2);
    }

    @Test
    void preferrablePaymentMethodTest() {
        Invoice invoice = getInvoiceRandomSampleGenerator();
        PaymentMethod paymentMethodBack = getPaymentMethodRandomSampleGenerator();

        invoice.setPreferrablePaymentMethod(paymentMethodBack);
        assertThat(invoice.getPreferrablePaymentMethod()).isEqualTo(paymentMethodBack);

        invoice.preferrablePaymentMethod(null);
        assertThat(invoice.getPreferrablePaymentMethod()).isNull();
    }
}
