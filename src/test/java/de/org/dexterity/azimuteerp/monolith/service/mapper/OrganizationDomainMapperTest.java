package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationDomainAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationDomainTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizationDomainMapperTest {

    private OrganizationDomainMapper organizationDomainMapper;

    @BeforeEach
    void setUp() {
        organizationDomainMapper = new OrganizationDomainMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getOrganizationDomainSample1();
        var actual = organizationDomainMapper.toEntity(organizationDomainMapper.toDto(expected));
        assertOrganizationDomainAllPropertiesEquals(expected, actual);
    }
}
