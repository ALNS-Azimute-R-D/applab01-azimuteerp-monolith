package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import java.util.Set;
import java.util.stream.Collectors;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Article;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.AssetCollection;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Category;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.ArticleDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.AssetCollectionDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.CategoryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Article} and its DTO {@link ArticleDTO}.
 */
@Mapper(componentModel = "spring")
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {
    @Mapping(target = "assetCollections", source = "assetCollections", qualifiedByName = "assetCollectionIdSet")
    @Mapping(target = "mainCategory", source = "mainCategory", qualifiedByName = "categoryAcronym")
    ArticleDTO toDto(Article s);

    @Mapping(target = "removeAssetCollection", ignore = true)
    Article toEntity(ArticleDTO articleDTO);

    @Named("assetCollectionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AssetCollectionDTO toDtoAssetCollectionId(AssetCollection assetCollection);

    @Named("assetCollectionIdSet")
    default Set<AssetCollectionDTO> toDtoAssetCollectionIdSet(Set<AssetCollection> assetCollection) {
        return assetCollection.stream().map(this::toDtoAssetCollectionId).collect(Collectors.toSet());
    }

    @Named("categoryAcronym")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "acronym", source = "acronym")
    CategoryDTO toDtoCategoryAcronym(Category category);
}
