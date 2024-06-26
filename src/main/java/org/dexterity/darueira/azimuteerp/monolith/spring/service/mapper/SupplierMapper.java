package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import java.util.Set;
import java.util.stream.Collectors;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Person;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Product;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Supplier;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.PersonDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.ProductDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.SupplierDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Supplier} and its DTO {@link SupplierDTO}.
 */
@Mapper(componentModel = "spring")
public interface SupplierMapper extends EntityMapper<SupplierDTO, Supplier> {
    @Mapping(target = "representativePerson", source = "representativePerson", qualifiedByName = "personLastname")
    @Mapping(target = "toProducts", source = "toProducts", qualifiedByName = "productIdSet")
    SupplierDTO toDto(Supplier s);

    @Mapping(target = "toProducts", ignore = true)
    @Mapping(target = "removeToProduct", ignore = true)
    Supplier toEntity(SupplierDTO supplierDTO);

    @Named("personLastname")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "lastname", source = "lastname")
    PersonDTO toDtoPersonLastname(Person person);

    @Named("productId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProductDTO toDtoProductId(Product product);

    @Named("productIdSet")
    default Set<ProductDTO> toDtoProductIdSet(Set<Product> product) {
        return product.stream().map(this::toDtoProductId).collect(Collectors.toSet());
    }
}
