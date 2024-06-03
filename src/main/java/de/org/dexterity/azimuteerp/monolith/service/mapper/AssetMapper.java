package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Asset;
import de.org.dexterity.azimuteerp.monolith.domain.AssetType;
import de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmp;
import de.org.dexterity.azimuteerp.monolith.service.dto.AssetDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.AssetTypeDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.RawAssetProcTmpDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Asset} and its DTO {@link AssetDTO}.
 */
@Mapper(componentModel = "spring")
public interface AssetMapper extends EntityMapper<AssetDTO, Asset> {
    @Mapping(target = "assetType", source = "assetType", qualifiedByName = "assetTypeName")
    @Mapping(target = "rawAssetProcTmp", source = "rawAssetProcTmp", qualifiedByName = "rawAssetProcTmpName")
    AssetDTO toDto(Asset s);

    @Named("assetTypeName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    AssetTypeDTO toDtoAssetTypeName(AssetType assetType);

    @Named("rawAssetProcTmpName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    RawAssetProcTmpDTO toDtoRawAssetProcTmpName(RawAssetProcTmp rawAssetProcTmp);
}
