package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.CustomerType;
import de.org.dexterity.azimuteerp.monolith.service.dto.CustomerTypeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CustomerType} and its DTO {@link CustomerTypeDTO}.
 */
@Mapper(componentModel = "spring")
public interface CustomerTypeMapper extends EntityMapper<CustomerTypeDTO, CustomerType> {}
