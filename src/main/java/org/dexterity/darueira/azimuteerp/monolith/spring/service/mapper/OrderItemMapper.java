package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Article;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Order;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.OrderItem;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.ArticleDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.OrderDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.OrderItemDTO;
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
