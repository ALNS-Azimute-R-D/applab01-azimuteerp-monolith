package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.BusinessUnit;
import de.org.dexterity.azimuteerp.monolith.domain.Organization;
import de.org.dexterity.azimuteerp.monolith.service.dto.BusinessUnitDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrganizationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link BusinessUnit} and its DTO {@link BusinessUnitDTO}.
 */
@Mapper(componentModel = "spring")
public interface BusinessUnitMapper extends EntityMapper<BusinessUnitDTO, BusinessUnit> {
    @Mapping(target = "organization", source = "organization", qualifiedByName = "organizationName")
    @Mapping(target = "businessUnitParent", source = "businessUnitParent", qualifiedByName = "businessUnitName")
    BusinessUnitDTO toDto(BusinessUnit s);

    @Named("organizationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    OrganizationDTO toDtoOrganizationName(Organization organization);

    @Named("businessUnitName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    BusinessUnitDTO toDtoBusinessUnitName(BusinessUnit businessUnit);
}
