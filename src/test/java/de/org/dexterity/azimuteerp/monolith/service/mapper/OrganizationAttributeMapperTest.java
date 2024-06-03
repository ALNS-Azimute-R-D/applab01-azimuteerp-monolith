package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationAttributeAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationAttributeTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizationAttributeMapperTest {

    private OrganizationAttributeMapper organizationAttributeMapper;

    @BeforeEach
    void setUp() {
        organizationAttributeMapper = new OrganizationAttributeMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getOrganizationAttributeSample1();
        var actual = organizationAttributeMapper.toEntity(organizationAttributeMapper.toDto(expected));
        assertOrganizationAttributeAllPropertiesEquals(expected, actual);
    }
}
