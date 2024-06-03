package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Customer;
import de.org.dexterity.azimuteerp.monolith.domain.CustomerType;
import de.org.dexterity.azimuteerp.monolith.domain.District;
import de.org.dexterity.azimuteerp.monolith.service.dto.CustomerDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.CustomerTypeDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.DistrictDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Customer} and its DTO {@link CustomerDTO}.
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
    @Mapping(target = "customerType", source = "customerType", qualifiedByName = "customerTypeName")
    @Mapping(target = "district", source = "district", qualifiedByName = "districtName")
    CustomerDTO toDto(Customer s);

    @Named("customerTypeName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CustomerTypeDTO toDtoCustomerTypeName(CustomerType customerType);

    @Named("districtName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    DistrictDTO toDtoDistrictName(District district);
}
