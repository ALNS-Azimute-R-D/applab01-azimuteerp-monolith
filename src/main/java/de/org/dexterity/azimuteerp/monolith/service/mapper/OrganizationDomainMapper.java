package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Organization;
import de.org.dexterity.azimuteerp.monolith.domain.OrganizationDomain;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationDomainDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrganizationDomain} and its DTO {@link OrganizationDomainDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrganizationDomainMapper extends EntityMapper<OrganizationDomainDTO, OrganizationDomain> {
    @Mapping(target = "organization", source = "organization", qualifiedByName = "organizationName")
    OrganizationDomainDTO toDto(OrganizationDomain s);

    @Named("organizationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    OrganizationDTO toDtoOrganizationName(Organization organization);
}
