package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Country;
import de.org.dexterity.azimuteerp.monolith.domain.Locality;
import de.org.dexterity.azimuteerp.monolith.service.dto.CountryDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.LocalityDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Locality} and its DTO {@link LocalityDTO}.
 */
@Mapper(componentModel = "spring")
public interface LocalityMapper extends EntityMapper<LocalityDTO, Locality> {
    @Mapping(target = "country", source = "country", qualifiedByName = "countryName")
    LocalityDTO toDto(Locality s);

    @Named("countryName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CountryDTO toDtoCountryName(Country country);
}
