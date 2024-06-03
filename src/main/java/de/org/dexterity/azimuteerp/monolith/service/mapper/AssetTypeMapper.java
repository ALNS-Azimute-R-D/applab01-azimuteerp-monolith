package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.AssetType;
import de.org.dexterity.azimuteerp.monolith.service.dto.AssetTypeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link AssetType} and its DTO {@link AssetTypeDTO}.
 */
@Mapper(componentModel = "spring")
public interface AssetTypeMapper extends EntityMapper<AssetTypeDTO, AssetType> {}
