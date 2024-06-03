package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Asset;
import de.org.dexterity.azimuteerp.monolith.domain.AssetMetadata;
import de.org.dexterity.azimuteerp.monolith.service.dto.AssetDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.AssetMetadataDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link AssetMetadata} and its DTO {@link AssetMetadataDTO}.
 */
@Mapper(componentModel = "spring")
public interface AssetMetadataMapper extends EntityMapper<AssetMetadataDTO, AssetMetadata> {
    @Mapping(target = "asset", source = "asset", qualifiedByName = "assetName")
    AssetMetadataDTO toDto(AssetMetadata s);

    @Named("assetName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    AssetDTO toDtoAssetName(Asset asset);
}
