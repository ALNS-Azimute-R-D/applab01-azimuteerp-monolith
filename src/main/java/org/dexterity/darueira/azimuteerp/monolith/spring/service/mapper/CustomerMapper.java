package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Customer;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.CustomerType;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.District;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Person;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.CustomerDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.CustomerTypeDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.DistrictDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.PersonDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Customer} and its DTO {@link CustomerDTO}.
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
    @Mapping(target = "buyerPerson", source = "buyerPerson", qualifiedByName = "personLastname")
    @Mapping(target = "customerType", source = "customerType", qualifiedByName = "customerTypeName")
    @Mapping(target = "district", source = "district", qualifiedByName = "districtName")
    CustomerDTO toDto(Customer s);

    @Named("personLastname")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "lastname", source = "lastname")
    PersonDTO toDtoPersonLastname(Person person);

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
