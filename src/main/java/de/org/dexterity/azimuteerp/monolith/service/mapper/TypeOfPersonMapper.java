package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.TypeOfPerson;
import de.org.dexterity.azimuteerp.monolith.service.dto.TypeOfPersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TypeOfPerson} and its DTO {@link TypeOfPersonDTO}.
 */
@Mapper(componentModel = "spring")
public interface TypeOfPersonMapper extends EntityMapper<TypeOfPersonDTO, TypeOfPerson> {}
