package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.DistrictTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrganizationMembershipTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.PersonTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.PersonTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.TypeOfPersonTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Person.class);
        Person person1 = getPersonSample1();
        Person person2 = new Person();
        assertThat(person1).isNotEqualTo(person2);

        person2.setId(person1.getId());
        assertThat(person1).isEqualTo(person2);

        person2 = getPersonSample2();
        assertThat(person1).isNotEqualTo(person2);
    }

    @Test
    void typeOfPersonTest() {
        Person person = getPersonRandomSampleGenerator();
        TypeOfPerson typeOfPersonBack = getTypeOfPersonRandomSampleGenerator();

        person.setTypeOfPerson(typeOfPersonBack);
        assertThat(person.getTypeOfPerson()).isEqualTo(typeOfPersonBack);

        person.typeOfPerson(null);
        assertThat(person.getTypeOfPerson()).isNull();
    }

    @Test
    void districtTest() {
        Person person = getPersonRandomSampleGenerator();
        District districtBack = getDistrictRandomSampleGenerator();

        person.setDistrict(districtBack);
        assertThat(person.getDistrict()).isEqualTo(districtBack);

        person.district(null);
        assertThat(person.getDistrict()).isNull();
    }

    @Test
    void managerPersonTest() {
        Person person = getPersonRandomSampleGenerator();
        Person personBack = getPersonRandomSampleGenerator();

        person.setManagerPerson(personBack);
        assertThat(person.getManagerPerson()).isEqualTo(personBack);

        person.managerPerson(null);
        assertThat(person.getManagerPerson()).isNull();
    }

    @Test
    void managedPersonsListTest() {
        Person person = getPersonRandomSampleGenerator();
        Person personBack = getPersonRandomSampleGenerator();

        person.addManagedPersonsList(personBack);
        assertThat(person.getManagedPersonsLists()).containsOnly(personBack);
        assertThat(personBack.getManagerPerson()).isEqualTo(person);

        person.removeManagedPersonsList(personBack);
        assertThat(person.getManagedPersonsLists()).doesNotContain(personBack);
        assertThat(personBack.getManagerPerson()).isNull();

        person.managedPersonsLists(new HashSet<>(Set.of(personBack)));
        assertThat(person.getManagedPersonsLists()).containsOnly(personBack);
        assertThat(personBack.getManagerPerson()).isEqualTo(person);

        person.setManagedPersonsLists(new HashSet<>());
        assertThat(person.getManagedPersonsLists()).doesNotContain(personBack);
        assertThat(personBack.getManagerPerson()).isNull();
    }

    @Test
    void organizationMembershipsListTest() {
        Person person = getPersonRandomSampleGenerator();
        OrganizationMembership organizationMembershipBack = getOrganizationMembershipRandomSampleGenerator();

        person.addOrganizationMembershipsList(organizationMembershipBack);
        assertThat(person.getOrganizationMembershipsLists()).containsOnly(organizationMembershipBack);
        assertThat(organizationMembershipBack.getPerson()).isEqualTo(person);

        person.removeOrganizationMembershipsList(organizationMembershipBack);
        assertThat(person.getOrganizationMembershipsLists()).doesNotContain(organizationMembershipBack);
        assertThat(organizationMembershipBack.getPerson()).isNull();

        person.organizationMembershipsLists(new HashSet<>(Set.of(organizationMembershipBack)));
        assertThat(person.getOrganizationMembershipsLists()).containsOnly(organizationMembershipBack);
        assertThat(organizationMembershipBack.getPerson()).isEqualTo(person);

        person.setOrganizationMembershipsLists(new HashSet<>());
        assertThat(person.getOrganizationMembershipsLists()).doesNotContain(organizationMembershipBack);
        assertThat(organizationMembershipBack.getPerson()).isNull();
    }
}
