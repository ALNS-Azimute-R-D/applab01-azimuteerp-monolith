package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.CustomerTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.CustomerTypeTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.DistrictTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Customer.class);
        Customer customer1 = getCustomerSample1();
        Customer customer2 = new Customer();
        assertThat(customer1).isNotEqualTo(customer2);

        customer2.setId(customer1.getId());
        assertThat(customer1).isEqualTo(customer2);

        customer2 = getCustomerSample2();
        assertThat(customer1).isNotEqualTo(customer2);
    }

    @Test
    void customerTypeTest() {
        Customer customer = getCustomerRandomSampleGenerator();
        CustomerType customerTypeBack = getCustomerTypeRandomSampleGenerator();

        customer.setCustomerType(customerTypeBack);
        assertThat(customer.getCustomerType()).isEqualTo(customerTypeBack);

        customer.customerType(null);
        assertThat(customer.getCustomerType()).isNull();
    }

    @Test
    void districtTest() {
        Customer customer = getCustomerRandomSampleGenerator();
        District districtBack = getDistrictRandomSampleGenerator();

        customer.setDistrict(districtBack);
        assertThat(customer.getDistrict()).isEqualTo(districtBack);

        customer.district(null);
        assertThat(customer.getDistrict()).isNull();
    }
}
