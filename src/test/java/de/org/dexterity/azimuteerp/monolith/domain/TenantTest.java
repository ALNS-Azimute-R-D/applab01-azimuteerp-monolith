package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.TenantTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TenantTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Tenant.class);
        Tenant tenant1 = getTenantSample1();
        Tenant tenant2 = new Tenant();
        assertThat(tenant1).isNotEqualTo(tenant2);

        tenant2.setId(tenant1.getId());
        assertThat(tenant1).isEqualTo(tenant2);

        tenant2 = getTenantSample2();
        assertThat(tenant1).isNotEqualTo(tenant2);
    }

    @Test
    void organizationsListTest() {
        Tenant tenant = getTenantRandomSampleGenerator();
        Organization organizationBack = getOrganizationRandomSampleGenerator();

        tenant.addOrganizationsList(organizationBack);
        assertThat(tenant.getOrganizationsLists()).containsOnly(organizationBack);
        assertThat(organizationBack.getTenant()).isEqualTo(tenant);

        tenant.removeOrganizationsList(organizationBack);
        assertThat(tenant.getOrganizationsLists()).doesNotContain(organizationBack);
        assertThat(organizationBack.getTenant()).isNull();

        tenant.organizationsLists(new HashSet<>(Set.of(organizationBack)));
        assertThat(tenant.getOrganizationsLists()).containsOnly(organizationBack);
        assertThat(organizationBack.getTenant()).isEqualTo(tenant);

        tenant.setOrganizationsLists(new HashSet<>());
        assertThat(tenant.getOrganizationsLists()).doesNotContain(organizationBack);
        assertThat(organizationBack.getTenant()).isNull();
    }
}
