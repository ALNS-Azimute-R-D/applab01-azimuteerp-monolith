package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.District;
import de.org.dexterity.azimuteerp.monolith.domain.TownCity;
import de.org.dexterity.azimuteerp.monolith.service.dto.DistrictDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.TownCityDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link District} and its DTO {@link DistrictDTO}.
 */
@Mapper(componentModel = "spring")
public interface DistrictMapper extends EntityMapper<DistrictDTO, District> {
    @Mapping(target = "townCity", source = "townCity", qualifiedByName = "townCityName")
    DistrictDTO toDto(District s);

    @Named("townCityName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    TownCityDTO toDtoTownCityName(TownCity townCity);
}
