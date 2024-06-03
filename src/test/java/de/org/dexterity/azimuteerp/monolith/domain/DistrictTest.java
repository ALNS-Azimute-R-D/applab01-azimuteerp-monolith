package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.CustomerTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.DistrictTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.PersonTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.TownCityTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DistrictTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(District.class);
        District district1 = getDistrictSample1();
        District district2 = new District();
        assertThat(district1).isNotEqualTo(district2);

        district2.setId(district1.getId());
        assertThat(district1).isEqualTo(district2);

        district2 = getDistrictSample2();
        assertThat(district1).isNotEqualTo(district2);
    }

    @Test
    void townCityTest() {
        District district = getDistrictRandomSampleGenerator();
        TownCity townCityBack = getTownCityRandomSampleGenerator();

        district.setTownCity(townCityBack);
        assertThat(district.getTownCity()).isEqualTo(townCityBack);

        district.townCity(null);
        assertThat(district.getTownCity()).isNull();
    }

    @Test
    void personsListTest() {
        District district = getDistrictRandomSampleGenerator();
        Person personBack = getPersonRandomSampleGenerator();

        district.addPersonsList(personBack);
        assertThat(district.getPersonsLists()).containsOnly(personBack);
        assertThat(personBack.getDistrict()).isEqualTo(district);

        district.removePersonsList(personBack);
        assertThat(district.getPersonsLists()).doesNotContain(personBack);
        assertThat(personBack.getDistrict()).isNull();

        district.personsLists(new HashSet<>(Set.of(personBack)));
        assertThat(district.getPersonsLists()).containsOnly(personBack);
        assertThat(personBack.getDistrict()).isEqualTo(district);

        district.setPersonsLists(new HashSet<>());
        assertThat(district.getPersonsLists()).doesNotContain(personBack);
        assertThat(personBack.getDistrict()).isNull();
    }

    @Test
    void customersListTest() {
        District district = getDistrictRandomSampleGenerator();
        Customer customerBack = getCustomerRandomSampleGenerator();

        district.addCustomersList(customerBack);
        assertThat(district.getCustomersLists()).containsOnly(customerBack);
        assertThat(customerBack.getDistrict()).isEqualTo(district);

        district.removeCustomersList(customerBack);
        assertThat(district.getCustomersLists()).doesNotContain(customerBack);
        assertThat(customerBack.getDistrict()).isNull();

        district.customersLists(new HashSet<>(Set.of(customerBack)));
        assertThat(district.getCustomersLists()).containsOnly(customerBack);
        assertThat(customerBack.getDistrict()).isEqualTo(district);

        district.setCustomersLists(new HashSet<>());
        assertThat(district.getCustomersLists()).doesNotContain(customerBack);
        assertThat(customerBack.getDistrict()).isNull();
    }
}
