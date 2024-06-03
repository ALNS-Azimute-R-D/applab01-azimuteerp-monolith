package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Product;
import de.org.dexterity.azimuteerp.monolith.domain.Supplier;
import de.org.dexterity.azimuteerp.monolith.service.dto.ProductDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.SupplierDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Supplier} and its DTO {@link SupplierDTO}.
 */
@Mapper(componentModel = "spring")
public interface SupplierMapper extends EntityMapper<SupplierDTO, Supplier> {
    @Mapping(target = "productsLists", source = "productsLists", qualifiedByName = "productIdSet")
    SupplierDTO toDto(Supplier s);

    @Mapping(target = "removeProductsList", ignore = true)
    Supplier toEntity(SupplierDTO supplierDTO);

    @Named("productId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductDTO toDtoProductId(Product product);

    @Named("productIdSet")
    default Set<ProductDTO> toDtoProductIdSet(Set<Product> product) {
        return product.stream().map(this::toDtoProductId).collect(Collectors.toSet());
    }
}
