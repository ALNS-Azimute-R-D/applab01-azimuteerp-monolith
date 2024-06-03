package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Province;
import de.org.dexterity.azimuteerp.monolith.domain.TownCity;
import de.org.dexterity.azimuteerp.monolith.service.dto.ProvinceDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.TownCityDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TownCity} and its DTO {@link TownCityDTO}.
 */
@Mapper(componentModel = "spring")
public interface TownCityMapper extends EntityMapper<TownCityDTO, TownCity> {
    @Mapping(target = "province", source = "province", qualifiedByName = "provinceName")
    TownCityDTO toDto(TownCity s);

    @Named("provinceName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProvinceDTO toDtoProvinceName(Province province);
}
