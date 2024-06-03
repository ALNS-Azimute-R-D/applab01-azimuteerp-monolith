package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Organization;
import de.org.dexterity.azimuteerp.monolith.domain.OrganizationRole;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationRoleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrganizationRole} and its DTO {@link OrganizationRoleDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrganizationRoleMapper extends EntityMapper<OrganizationRoleDTO, OrganizationRole> {
    @Mapping(target = "organization", source = "organization", qualifiedByName = "organizationName")
    OrganizationRoleDTO toDto(OrganizationRole s);

    @Named("organizationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    OrganizationDTO toDtoOrganizationName(Organization organization);
}
