package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import org.dexterity.darueira.azimuteerp.monolith.spring.domain.CustomerType;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.CustomerTypeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CustomerType} and its DTO {@link CustomerTypeDTO}.
 */
@Mapper(componentModel = "spring")
public interface CustomerTypeMapper extends EntityMapper<CustomerTypeDTO, CustomerType> {}
