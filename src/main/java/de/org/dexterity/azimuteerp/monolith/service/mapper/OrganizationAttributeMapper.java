package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Organization;
import de.org.dexterity.azimuteerp.monolith.domain.OrganizationAttribute;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationAttributeDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrganizationAttribute} and its DTO {@link OrganizationAttributeDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrganizationAttributeMapper extends EntityMapper<OrganizationAttributeDTO, OrganizationAttribute> {
    @Mapping(target = "organization", source = "organization", qualifiedByName = "organizationName")
    OrganizationAttributeDTO toDto(OrganizationAttribute s);

    @Named("organizationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    OrganizationDTO toDtoOrganizationName(Organization organization);
}
