package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.CustomerTypeAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.CustomerTypeTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTypeMapperTest {

    private CustomerTypeMapper customerTypeMapper;

    @BeforeEach
    void setUp() {
        customerTypeMapper = new CustomerTypeMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getCustomerTypeSample1();
        var actual = customerTypeMapper.toEntity(customerTypeMapper.toDto(expected));
        assertCustomerTypeAllPropertiesEquals(expected, actual);
    }
}
