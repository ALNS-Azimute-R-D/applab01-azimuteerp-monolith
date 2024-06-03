package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.BusinessUnitAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.BusinessUnitTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusinessUnitMapperTest {

    private BusinessUnitMapper businessUnitMapper;

    @BeforeEach
    void setUp() {
        businessUnitMapper = new BusinessUnitMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getBusinessUnitSample1();
        var actual = businessUnitMapper.toEntity(businessUnitMapper.toDto(expected));
        assertBusinessUnitAllPropertiesEquals(expected, actual);
    }
}
