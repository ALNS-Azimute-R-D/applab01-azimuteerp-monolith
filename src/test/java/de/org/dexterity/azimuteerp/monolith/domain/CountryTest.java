package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.CountryTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.LocalityTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.ProvinceTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CountryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Country.class);
        Country country1 = getCountrySample1();
        Country country2 = new Country();
        assertThat(country1).isNotEqualTo(country2);

        country2.setId(country1.getId());
        assertThat(country1).isEqualTo(country2);

        country2 = getCountrySample2();
        assertThat(country1).isNotEqualTo(country2);
    }

    @Test
    void provincesListTest() {
        Country country = getCountryRandomSampleGenerator();
        Province provinceBack = getProvinceRandomSampleGenerator();

        country.addProvincesList(provinceBack);
        assertThat(country.getProvincesLists()).containsOnly(provinceBack);
        assertThat(provinceBack.getCountry()).isEqualTo(country);

        country.removeProvincesList(provinceBack);
        assertThat(country.getProvincesLists()).doesNotContain(provinceBack);
        assertThat(provinceBack.getCountry()).isNull();

        country.provincesLists(new HashSet<>(Set.of(provinceBack)));
        assertThat(country.getProvincesLists()).containsOnly(provinceBack);
        assertThat(provinceBack.getCountry()).isEqualTo(country);

        country.setProvincesLists(new HashSet<>());
        assertThat(country.getProvincesLists()).doesNotContain(provinceBack);
        assertThat(provinceBack.getCountry()).isNull();
    }

    @Test
    void localitiesListTest() {
        Country country = getCountryRandomSampleGenerator();
        Locality localityBack = getLocalityRandomSampleGenerator();

        country.addLocalitiesList(localityBack);
        assertThat(country.getLocalitiesLists()).containsOnly(localityBack);
        assertThat(localityBack.getCountry()).isEqualTo(country);

        country.removeLocalitiesList(localityBack);
        assertThat(country.getLocalitiesLists()).doesNotContain(localityBack);
        assertThat(localityBack.getCountry()).isNull();

        country.localitiesLists(new HashSet<>(Set.of(localityBack)));
        assertThat(country.getLocalitiesLists()).containsOnly(localityBack);
        assertThat(localityBack.getCountry()).isEqualTo(country);

        country.setLocalitiesLists(new HashSet<>());
        assertThat(country.getLocalitiesLists()).doesNotContain(localityBack);
        assertThat(localityBack.getCountry()).isNull();
    }
}
