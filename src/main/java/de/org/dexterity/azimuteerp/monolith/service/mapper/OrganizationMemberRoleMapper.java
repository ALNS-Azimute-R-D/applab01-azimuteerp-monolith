package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.OrganizationMemberRole;
import de.org.dexterity.azimuteerp.monolith.domain.OrganizationMembership;
import de.org.dexterity.azimuteerp.monolith.domain.OrganizationRole;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationMemberRoleDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationMembershipDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationRoleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrganizationMemberRole} and its DTO {@link OrganizationMemberRoleDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrganizationMemberRoleMapper extends EntityMapper<OrganizationMemberRoleDTO, OrganizationMemberRole> {
    @Mapping(target = "organizationMembership", source = "organizationMembership", qualifiedByName = "organizationMembershipId")
    @Mapping(target = "organizationRole", source = "organizationRole", qualifiedByName = "organizationRoleId")
    OrganizationMemberRoleDTO toDto(OrganizationMemberRole s);

    @Named("organizationMembershipId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OrganizationMembershipDTO toDtoOrganizationMembershipId(OrganizationMembership organizationMembership);

    @Named("organizationRoleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OrganizationRoleDTO toDtoOrganizationRoleId(OrganizationRole organizationRole);
}
