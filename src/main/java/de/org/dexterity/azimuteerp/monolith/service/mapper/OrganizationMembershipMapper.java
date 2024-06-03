package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Organization;
import de.org.dexterity.azimuteerp.monolith.domain.OrganizationMembership;
import de.org.dexterity.azimuteerp.monolith.domain.Person;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationMembershipDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.PersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrganizationMembership} and its DTO {@link OrganizationMembershipDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrganizationMembershipMapper extends EntityMapper<OrganizationMembershipDTO, OrganizationMembership> {
    @Mapping(target = "organization", source = "organization", qualifiedByName = "organizationName")
    @Mapping(target = "person", source = "person", qualifiedByName = "personLastName")
    OrganizationMembershipDTO toDto(OrganizationMembership s);

    @Named("organizationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    OrganizationDTO toDtoOrganizationName(Organization organization);

    @Named("personLastName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "lastName", source = "lastName")
    PersonDTO toDtoPersonLastName(Person person);
}
