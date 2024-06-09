package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Asset;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.AssetMetadata;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.AssetDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.AssetMetadataDTO;
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
