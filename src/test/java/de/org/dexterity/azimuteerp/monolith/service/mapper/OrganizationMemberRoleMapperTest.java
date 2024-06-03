package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationMemberRoleAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationMemberRoleTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizationMemberRoleMapperTest {

    private OrganizationMemberRoleMapper organizationMemberRoleMapper;

    @BeforeEach
    void setUp() {
        organizationMemberRoleMapper = new OrganizationMemberRoleMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getOrganizationMemberRoleSample1();
        var actual = organizationMemberRoleMapper.toEntity(organizationMemberRoleMapper.toDto(expected));
        assertOrganizationMemberRoleAllPropertiesEquals(expected, actual);
    }
}
