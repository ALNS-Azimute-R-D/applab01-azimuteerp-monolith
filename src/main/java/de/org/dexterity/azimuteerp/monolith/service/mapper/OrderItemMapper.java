package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Article;
import de.org.dexterity.azimuteerp.monolith.domain.Order;
import de.org.dexterity.azimuteerp.monolith.domain.OrderItem;
import de.org.dexterity.azimuteerp.monolith.service.dto.ArticleDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrderDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.OrderItemDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrderItem} and its DTO {@link OrderItemDTO}.
 */
@Mapper(componentModel = "spring")
public interface OrderItemMapper extends EntityMapper<OrderItemDTO, OrderItem> {
    @Mapping(target = "article", source = "article", qualifiedByName = "articleCustomName")
    @Mapping(target = "order", source = "order", qualifiedByName = "orderBusinessCode")
    OrderItemDTO toDto(OrderItem s);

    @Named("articleCustomName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customName", source = "customName")
    ArticleDTO toDtoArticleCustomName(Article article);

    @Named("orderBusinessCode")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "businessCode", source = "businessCode")
    OrderDTO toDtoOrderBusinessCode(Order order);
}
