package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.InventoryTransaction;
import de.org.dexterity.azimuteerp.monolith.domain.Product;
import de.org.dexterity.azimuteerp.monolith.domain.Supplier;
import de.org.dexterity.azimuteerp.monolith.domain.Warehouse;
import de.org.dexterity.azimuteerp.monolith.service.dto.InventoryTransactionDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.ProductDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.SupplierDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.WarehouseDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link InventoryTransaction} and its DTO {@link InventoryTransactionDTO}.
 */
@Mapper(componentModel = "spring")
public interface InventoryTransactionMapper extends EntityMapper<InventoryTransactionDTO, InventoryTransaction> {
    @Mapping(target = "supplier", source = "supplier", qualifiedByName = "supplierAcronym")
    @Mapping(target = "product", source = "product", qualifiedByName = "productProductName")
    @Mapping(target = "warehouse", source = "warehouse", qualifiedByName = "warehouseAcronym")
    InventoryTransactionDTO toDto(InventoryTransaction s);

    @Named("supplierAcronym")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "acronym", source = "acronym")
    SupplierDTO toDtoSupplierAcronym(Supplier supplier);

    @Named("productProductName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "productName", source = "productName")
    ProductDTO toDtoProductProductName(Product product);

    @Named("warehouseAcronym")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "acronym", source = "acronym")
    WarehouseDTO toDtoWarehouseAcronym(Warehouse warehouse);
}
