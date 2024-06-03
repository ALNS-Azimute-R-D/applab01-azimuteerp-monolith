package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.InvoiceTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.PaymentMethodTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.PaymentTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PaymentMethodTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentMethod.class);
        PaymentMethod paymentMethod1 = getPaymentMethodSample1();
        PaymentMethod paymentMethod2 = new PaymentMethod();
        assertThat(paymentMethod1).isNotEqualTo(paymentMethod2);

        paymentMethod2.setId(paymentMethod1.getId());
        assertThat(paymentMethod1).isEqualTo(paymentMethod2);

        paymentMethod2 = getPaymentMethodSample2();
        assertThat(paymentMethod1).isNotEqualTo(paymentMethod2);
    }

    @Test
    void invoicesAsPreferrableListTest() {
        PaymentMethod paymentMethod = getPaymentMethodRandomSampleGenerator();
        Invoice invoiceBack = getInvoiceRandomSampleGenerator();

        paymentMethod.addInvoicesAsPreferrableList(invoiceBack);
        assertThat(paymentMethod.getInvoicesAsPreferrableLists()).containsOnly(invoiceBack);
        assertThat(invoiceBack.getPreferrablePaymentMethod()).isEqualTo(paymentMethod);

        paymentMethod.removeInvoicesAsPreferrableList(invoiceBack);
        assertThat(paymentMethod.getInvoicesAsPreferrableLists()).doesNotContain(invoiceBack);
        assertThat(invoiceBack.getPreferrablePaymentMethod()).isNull();

        paymentMethod.invoicesAsPreferrableLists(new HashSet<>(Set.of(invoiceBack)));
        assertThat(paymentMethod.getInvoicesAsPreferrableLists()).containsOnly(invoiceBack);
        assertThat(invoiceBack.getPreferrablePaymentMethod()).isEqualTo(paymentMethod);

        paymentMethod.setInvoicesAsPreferrableLists(new HashSet<>());
        assertThat(paymentMethod.getInvoicesAsPreferrableLists()).doesNotContain(invoiceBack);
        assertThat(invoiceBack.getPreferrablePaymentMethod()).isNull();
    }

    @Test
    void paymentsListTest() {
        PaymentMethod paymentMethod = getPaymentMethodRandomSampleGenerator();
        Payment paymentBack = getPaymentRandomSampleGenerator();

        paymentMethod.addPaymentsList(paymentBack);
        assertThat(paymentMethod.getPaymentsLists()).containsOnly(paymentBack);
        assertThat(paymentBack.getPaymentMethod()).isEqualTo(paymentMethod);

        paymentMethod.removePaymentsList(paymentBack);
        assertThat(paymentMethod.getPaymentsLists()).doesNotContain(paymentBack);
        assertThat(paymentBack.getPaymentMethod()).isNull();

        paymentMethod.paymentsLists(new HashSet<>(Set.of(paymentBack)));
        assertThat(paymentMethod.getPaymentsLists()).containsOnly(paymentBack);
        assertThat(paymentBack.getPaymentMethod()).isEqualTo(paymentMethod);

        paymentMethod.setPaymentsLists(new HashSet<>());
        assertThat(paymentMethod.getPaymentsLists()).doesNotContain(paymentBack);
        assertThat(paymentBack.getPaymentMethod()).isNull();
    }
}
