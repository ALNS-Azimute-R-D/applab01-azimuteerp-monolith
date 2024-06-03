package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationMembershipAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationMembershipTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizationMembershipMapperTest {

    private OrganizationMembershipMapper organizationMembershipMapper;

    @BeforeEach
    void setUp() {
        organizationMembershipMapper = new OrganizationMembershipMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getOrganizationMembershipSample1();
        var actual = organizationMembershipMapper.toEntity(organizationMembershipMapper.toDto(expected));
        assertOrganizationMembershipAllPropertiesEquals(expected, actual);
    }
}
