package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.CustomerTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.CustomerTypeTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CustomerTypeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CustomerType.class);
        CustomerType customerType1 = getCustomerTypeSample1();
        CustomerType customerType2 = new CustomerType();
        assertThat(customerType1).isNotEqualTo(customerType2);

        customerType2.setId(customerType1.getId());
        assertThat(customerType1).isEqualTo(customerType2);

        customerType2 = getCustomerTypeSample2();
        assertThat(customerType1).isNotEqualTo(customerType2);
    }

    @Test
    void customersListTest() {
        CustomerType customerType = getCustomerTypeRandomSampleGenerator();
        Customer customerBack = getCustomerRandomSampleGenerator();

        customerType.addCustomersList(customerBack);
        assertThat(customerType.getCustomersLists()).containsOnly(customerBack);
        assertThat(customerBack.getCustomerType()).isEqualTo(customerType);

        customerType.removeCustomersList(customerBack);
        assertThat(customerType.getCustomersLists()).doesNotContain(customerBack);
        assertThat(customerBack.getCustomerType()).isNull();

        customerType.customersLists(new HashSet<>(Set.of(customerBack)));
        assertThat(customerType.getCustomersLists()).containsOnly(customerBack);
        assertThat(customerBack.getCustomerType()).isEqualTo(customerType);

        customerType.setCustomersLists(new HashSet<>());
        assertThat(customerType.getCustomersLists()).doesNotContain(customerBack);
        assertThat(customerBack.getCustomerType()).isNull();
    }
}
