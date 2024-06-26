package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.BusinessUnitAsserts.*;
import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.BusinessUnitTestSamples.*;

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
