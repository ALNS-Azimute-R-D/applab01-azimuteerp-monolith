package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.TownCityAsserts.*;
import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.TownCityTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownCityMapperTest {

    private TownCityMapper townCityMapper;

    @BeforeEach
    void setUp() {
        townCityMapper = new TownCityMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTownCitySample1();
        var actual = townCityMapper.toEntity(townCityMapper.toDto(expected));
        assertTownCityAllPropertiesEquals(expected, actual);
    }
}
