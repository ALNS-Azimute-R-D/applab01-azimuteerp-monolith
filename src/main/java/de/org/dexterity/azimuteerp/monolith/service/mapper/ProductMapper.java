package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Brand;
import de.org.dexterity.azimuteerp.monolith.domain.Product;
import de.org.dexterity.azimuteerp.monolith.domain.Supplier;
import de.org.dexterity.azimuteerp.monolith.service.dto.BrandDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.ProductDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.SupplierDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
    @Mapping(target = "brand", source = "brand", qualifiedByName = "brandAcronym")
    @Mapping(target = "suppliersLists", source = "suppliersLists", qualifiedByName = "supplierIdSet")
    ProductDTO toDto(Product s);

    @Mapping(target = "suppliersLists", ignore = true)
    @Mapping(target = "removeSuppliersList", ignore = true)
    Product toEntity(ProductDTO productDTO);

    @Named("brandAcronym")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "acronym", source = "acronym")
    BrandDTO toDtoBrandAcronym(Brand brand);

    @Named("supplierId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SupplierDTO toDtoSupplierId(Supplier supplier);

    @Named("supplierIdSet")
    default Set<SupplierDTO> toDtoSupplierIdSet(Set<Supplier> supplier) {
        return supplier.stream().map(this::toDtoSupplierId).collect(Collectors.toSet());
    }
}
