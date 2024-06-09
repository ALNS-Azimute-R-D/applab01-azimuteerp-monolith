package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import org.dexterity.darueira.azimuteerp.monolith.spring.domain.TypeOfPerson;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.TypeOfPersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TypeOfPerson} and its DTO {@link TypeOfPersonDTO}.
 */
@Mapper(componentModel = "spring")
public interface TypeOfPersonMapper extends EntityMapper<TypeOfPersonDTO, TypeOfPerson> {}
