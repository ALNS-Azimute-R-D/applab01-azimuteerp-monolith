package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.TypeOfOrganization;
import de.org.dexterity.azimuteerp.monolith.service.dto.TypeOfOrganizationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TypeOfOrganization} and its DTO {@link TypeOfOrganizationDTO}.
 */
@Mapper(componentModel = "spring")
public interface TypeOfOrganizationMapper extends EntityMapper<TypeOfOrganizationDTO, TypeOfOrganization> {}
