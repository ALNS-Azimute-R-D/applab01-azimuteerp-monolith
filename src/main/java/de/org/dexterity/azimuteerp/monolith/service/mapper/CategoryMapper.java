package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Category;
import de.org.dexterity.azimuteerp.monolith.service.dto.CategoryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
    @Mapping(target = "categoryParent", source = "categoryParent", qualifiedByName = "categoryAcronym")
    CategoryDTO toDto(Category s);

    @Named("categoryAcronym")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "acronym", source = "acronym")
    CategoryDTO toDtoCategoryAcronym(Category category);
}
