package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.AssetType;
import de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmp;
import de.org.dexterity.azimuteerp.monolith.service.dto.AssetTypeDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.RawAssetProcTmpDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link RawAssetProcTmp} and its DTO {@link RawAssetProcTmpDTO}.
 */
@Mapper(componentModel = "spring")
public interface RawAssetProcTmpMapper extends EntityMapper<RawAssetProcTmpDTO, RawAssetProcTmp> {
    @Mapping(target = "assetType", source = "assetType", qualifiedByName = "assetTypeName")
    RawAssetProcTmpDTO toDto(RawAssetProcTmp s);

    @Named("assetTypeName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    AssetTypeDTO toDtoAssetTypeName(AssetType assetType);
}
