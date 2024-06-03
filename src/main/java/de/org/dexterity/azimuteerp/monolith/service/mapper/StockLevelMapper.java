package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Product;
import de.org.dexterity.azimuteerp.monolith.domain.StockLevel;
import de.org.dexterity.azimuteerp.monolith.domain.Warehouse;
import de.org.dexterity.azimuteerp.monolith.service.dto.ProductDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.StockLevelDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.WarehouseDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link StockLevel} and its DTO {@link StockLevelDTO}.
 */
@Mapper(componentModel = "spring")
public interface StockLevelMapper extends EntityMapper<StockLevelDTO, StockLevel> {
    @Mapping(target = "warehouse", source = "warehouse", qualifiedByName = "warehouseAcronym")
    @Mapping(target = "product", source = "product", qualifiedByName = "productProductName")
    StockLevelDTO toDto(StockLevel s);

    @Named("warehouseAcronym")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "acronym", source = "acronym")
    WarehouseDTO toDtoWarehouseAcronym(Warehouse warehouse);

    @Named("productProductName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "productName", source = "productName")
    ProductDTO toDtoProductProductName(Product product);
}
