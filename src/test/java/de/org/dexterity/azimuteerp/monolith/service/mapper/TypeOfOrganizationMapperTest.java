package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.TypeOfOrganizationAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.TypeOfOrganizationTestSamples.*;

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
