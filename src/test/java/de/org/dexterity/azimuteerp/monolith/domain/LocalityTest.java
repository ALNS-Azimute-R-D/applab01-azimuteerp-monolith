package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.CountryTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.LocalityTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class LocalityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Locality.class);
        Locality locality1 = getLocalitySample1();
        Locality locality2 = new Locality();
        assertThat(locality1).isNotEqualTo(locality2);

        locality2.setId(locality1.getId());
        assertThat(locality1).isEqualTo(locality2);

        locality2 = getLocalitySample2();
        assertThat(locality1).isNotEqualTo(locality2);
    }

    @Test
    void countryTest() {
        Locality locality = getLocalityRandomSampleGenerator();
        Country countryBack = getCountryRandomSampleGenerator();

        locality.setCountry(countryBack);
        assertThat(locality.getCountry()).isEqualTo(countryBack);

        locality.country(null);
        assertThat(locality.getCountry()).isNull();
    }
}
