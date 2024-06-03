package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.TypeOfOrganizationTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TypeOfOrganizationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TypeOfOrganization.class);
        TypeOfOrganization typeOfOrganization1 = getTypeOfOrganizationSample1();
        TypeOfOrganization typeOfOrganization2 = new TypeOfOrganization();
        assertThat(typeOfOrganization1).isNotEqualTo(typeOfOrganization2);

        typeOfOrganization2.setId(typeOfOrganization1.getId());
        assertThat(typeOfOrganization1).isEqualTo(typeOfOrganization2);

        typeOfOrganization2 = getTypeOfOrganizationSample2();
        assertThat(typeOfOrganization1).isNotEqualTo(typeOfOrganization2);
    }

    @Test
    void organizationsListTest() {
        TypeOfOrganization typeOfOrganization = getTypeOfOrganizationRandomSampleGenerator();
        Organization organizationBack = getOrganizationRandomSampleGenerator();

        typeOfOrganization.addOrganizationsList(organizationBack);
        assertThat(typeOfOrganization.getOrganizationsLists()).containsOnly(organizationBack);
        assertThat(organizationBack.getTypeOfOrganization()).isEqualTo(typeOfOrganization);

        typeOfOrganization.removeOrganizationsList(organizationBack);
        assertThat(typeOfOrganization.getOrganizationsLists()).doesNotContain(organizationBack);
        assertThat(organizationBack.getTypeOfOrganization()).isNull();

        typeOfOrganization.organizationsLists(new HashSet<>(Set.of(organizationBack)));
        assertThat(typeOfOrganization.getOrganizationsLists()).containsOnly(organizationBack);
        assertThat(organizationBack.getTypeOfOrganization()).isEqualTo(typeOfOrganization);

        typeOfOrganization.setOrganizationsLists(new HashSet<>());
        assertThat(typeOfOrganization.getOrganizationsLists()).doesNotContain(organizationBack);
        assertThat(organizationBack.getTypeOfOrganization()).isNull();
    }
}
