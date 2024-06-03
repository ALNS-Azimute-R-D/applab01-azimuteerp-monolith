package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Country;
import de.org.dexterity.azimuteerp.monolith.domain.Province;
import de.org.dexterity.azimuteerp.monolith.service.dto.CountryDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.ProvinceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Province} and its DTO {@link ProvinceDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProvinceMapper extends EntityMapper<ProvinceDTO, Province> {
    @Mapping(target = "country", source = "country", qualifiedByName = "countryName")
    ProvinceDTO toDto(Province s);

    @Named("countryName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CountryDTO toDtoCountryName(Country country);
}
