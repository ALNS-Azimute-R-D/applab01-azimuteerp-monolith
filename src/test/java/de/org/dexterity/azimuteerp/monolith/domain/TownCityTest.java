package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.DistrictTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.ProvinceTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.TownCityTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TownCityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TownCity.class);
        TownCity townCity1 = getTownCitySample1();
        TownCity townCity2 = new TownCity();
        assertThat(townCity1).isNotEqualTo(townCity2);

        townCity2.setId(townCity1.getId());
        assertThat(townCity1).isEqualTo(townCity2);

        townCity2 = getTownCitySample2();
        assertThat(townCity1).isNotEqualTo(townCity2);
    }

    @Test
    void provinceTest() {
        TownCity townCity = getTownCityRandomSampleGenerator();
        Province provinceBack = getProvinceRandomSampleGenerator();

        townCity.setProvince(provinceBack);
        assertThat(townCity.getProvince()).isEqualTo(provinceBack);

        townCity.province(null);
        assertThat(townCity.getProvince()).isNull();
    }

    @Test
    void districtsListTest() {
        TownCity townCity = getTownCityRandomSampleGenerator();
        District districtBack = getDistrictRandomSampleGenerator();

        townCity.addDistrictsList(districtBack);
        assertThat(townCity.getDistrictsLists()).containsOnly(districtBack);
        assertThat(districtBack.getTownCity()).isEqualTo(townCity);

        townCity.removeDistrictsList(districtBack);
        assertThat(townCity.getDistrictsLists()).doesNotContain(districtBack);
        assertThat(districtBack.getTownCity()).isNull();

        townCity.districtsLists(new HashSet<>(Set.of(districtBack)));
        assertThat(townCity.getDistrictsLists()).containsOnly(districtBack);
        assertThat(districtBack.getTownCity()).isEqualTo(townCity);

        townCity.setDistrictsLists(new HashSet<>());
        assertThat(townCity.getDistrictsLists()).doesNotContain(districtBack);
        assertThat(districtBack.getTownCity()).isNull();
    }
}
