package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.TypeOfOrganizationAsserts.*;
import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.TypeOfOrganizationTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeOfOrganizationMapperTest {

    private TypeOfOrganizationMapper typeOfOrganizationMapper;

    @BeforeEach
    void setUp() {
        typeOfOrganizationMapper = new TypeOfOrganizationMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTypeOfOrganizationSample1();
        var actual = typeOfOrganizationMapper.toEntity(typeOfOrganizationMapper.toDto(expected));
        assertTypeOfOrganizationAllPropertiesEquals(expected, actual);
    }
}
