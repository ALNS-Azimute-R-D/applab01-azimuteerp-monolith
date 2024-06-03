package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationMemberRoleTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationMembershipTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationRoleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class OrganizationMemberRoleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OrganizationMemberRole.class);
        OrganizationMemberRole organizationMemberRole1 = getOrganizationMemberRoleSample1();
        OrganizationMemberRole organizationMemberRole2 = new OrganizationMemberRole();
        assertThat(organizationMemberRole1).isNotEqualTo(organizationMemberRole2);

        organizationMemberRole2.setId(organizationMemberRole1.getId());
        assertThat(organizationMemberRole1).isEqualTo(organizationMemberRole2);

        organizationMemberRole2 = getOrganizationMemberRoleSample2();
        assertThat(organizationMemberRole1).isNotEqualTo(organizationMemberRole2);
    }

    @Test
    void organizationMembershipTest() {
        OrganizationMemberRole organizationMemberRole = getOrganizationMemberRoleRandomSampleGenerator();
        OrganizationMembership organizationMembershipBack = getOrganizationMembershipRandomSampleGenerator();

        organizationMemberRole.setOrganizationMembership(organizationMembershipBack);
        assertThat(organizationMemberRole.getOrganizationMembership()).isEqualTo(organizationMembershipBack);

        organizationMemberRole.organizationMembership(null);
        assertThat(organizationMemberRole.getOrganizationMembership()).isNull();
    }

    @Test
    void organizationRoleTest() {
        OrganizationMemberRole organizationMemberRole = getOrganizationMemberRoleRandomSampleGenerator();
        OrganizationRole organizationRoleBack = getOrganizationRoleRandomSampleGenerator();

        organizationMemberRole.setOrganizationRole(organizationRoleBack);
        assertThat(organizationMemberRole.getOrganizationRole()).isEqualTo(organizationRoleBack);

        organizationMemberRole.organizationRole(null);
        assertThat(organizationMemberRole.getOrganizationRole()).isNull();
    }
}
