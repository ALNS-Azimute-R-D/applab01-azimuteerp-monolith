package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Organization;
import de.org.dexterity.azimuteerp.monolith.domain.Tenant;
import de.org.dexterity.azimuteerp.monolith.domain.TypeOfOrganization;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.TenantDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.TypeOfOrganizationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Organization} and its DTO {@link OrganizationDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends EntityMapper<OrganizationDTO, Organization> {
    @Mapping(target = "tenant", source = "tenant", qualifiedByName = "tenantName")
    @Mapping(target = "typeOfOrganization", source = "typeOfOrganization", qualifiedByName = "typeOfOrganizationName")
    @Mapping(target = "organizationParent", source = "organizationParent", qualifiedByName = "organizationName")
    OrganizationDTO toDto(Organization s);

    @Named("tenantName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    TenantDTO toDtoTenantName(Tenant tenant);

    @Named("typeOfOrganizationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    TypeOfOrganizationDTO toDtoTypeOfOrganizationName(TypeOfOrganization typeOfOrganization);

    @Named("organizationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    OrganizationDTO toDtoOrganizationName(Organization organization);
}
