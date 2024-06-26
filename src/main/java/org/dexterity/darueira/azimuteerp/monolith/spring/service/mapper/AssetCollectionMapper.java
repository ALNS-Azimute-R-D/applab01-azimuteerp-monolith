package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Article;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Asset;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.AssetCollection;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.ArticleDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.AssetCollectionDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.AssetDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link AssetCollection} and its DTO {@link AssetCollectionDTO}.
 */
@Mapper(componentModel = "spring")
public interface AssetCollectionMapper extends EntityMapper<AssetCollectionDTO, AssetCollection> {
    @Mapping(target = "assets", source = "assets", qualifiedByName = "assetIdSet")
    @Mapping(target = "articles", source = "articles", qualifiedByName = "articleIdSet")
    AssetCollectionDTO toDto(AssetCollection s);

    @Mapping(target = "removeAsset", ignore = true)
    @Mapping(target = "articles", ignore = true)
    @Mapping(target = "removeArticle", ignore = true)
    AssetCollection toEntity(AssetCollectionDTO assetCollectionDTO);

    @Named("assetId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AssetDTO toDtoAssetId(Asset asset);

    @Named("assetIdSet")
    default Set<AssetDTO> toDtoAssetIdSet(Set<Asset> asset) {
        return asset.stream().map(this::toDtoAssetId).collect(Collectors.toSet());
    }

    @Named("articleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ArticleDTO toDtoArticleId(Article article);

    @Named("articleIdSet")
    default Set<ArticleDTO> toDtoArticleIdSet(Set<Article> article) {
        return article.stream().map(this::toDtoArticleId).collect(Collectors.toSet());
    }

    default String map(UUID value) {
        return Objects.toString(value, null);
    }
}
