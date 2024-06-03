package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.LocalityAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.LocalityTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalityMapperTest {

    private LocalityMapper localityMapper;

    @BeforeEach
    void setUp() {
        localityMapper = new LocalityMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getLocalitySample1();
        var actual = localityMapper.toEntity(localityMapper.toDto(expected));
        assertLocalityAllPropertiesEquals(expected, actual);
    }
}
