package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.District;
import de.org.dexterity.azimuteerp.monolith.domain.Person;
import de.org.dexterity.azimuteerp.monolith.domain.TypeOfPerson;
import de.org.dexterity.azimuteerp.monolith.service.dto.DistrictDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.PersonDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.TypeOfPersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Person} and its DTO {@link PersonDTO}.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {
    @Mapping(target = "typeOfPerson", source = "typeOfPerson", qualifiedByName = "typeOfPersonCode")
    @Mapping(target = "district", source = "district", qualifiedByName = "districtName")
    @Mapping(target = "managerPerson", source = "managerPerson", qualifiedByName = "personLastName")
    PersonDTO toDto(Person s);

    @Named("typeOfPersonCode")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "code", source = "code")
    TypeOfPersonDTO toDtoTypeOfPersonCode(TypeOfPerson typeOfPerson);

    @Named("districtName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    DistrictDTO toDtoDistrictName(District district);

    @Named("personLastName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "lastName", source = "lastName")
    PersonDTO toDtoPersonLastName(Person person);
}
