package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationRoleAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationRoleTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizationRoleMapperTest {

    private OrganizationRoleMapper organizationRoleMapper;

    @BeforeEach
    void setUp() {
        organizationRoleMapper = new OrganizationRoleMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getOrganizationRoleSample1();
        var actual = organizationRoleMapper.toEntity(organizationRoleMapper.toDto(expected));
        assertOrganizationRoleAllPropertiesEquals(expected, actual);
    }
}
