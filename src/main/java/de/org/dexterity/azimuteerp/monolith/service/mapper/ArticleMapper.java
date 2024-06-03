package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Article;
import de.org.dexterity.azimuteerp.monolith.domain.Category;
import de.org.dexterity.azimuteerp.monolith.service.dto.ArticleDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.CategoryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Article} and its DTO {@link ArticleDTO}.
 */
@Mapper(componentModel = "spring")
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {
    @Mapping(target = "mainCategory", source = "mainCategory", qualifiedByName = "categoryAcronym")
    ArticleDTO toDto(Article s);

    @Named("categoryAcronym")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "acronym", source = "acronym")
    CategoryDTO toDtoCategoryAcronym(Category category);
}
