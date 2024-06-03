package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.TownCityAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.TownCityTestSamples.*;

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
