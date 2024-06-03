package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.OrderAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrderTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderMapperTest {

    private OrderMapper orderMapper;

    @BeforeEach
    void setUp() {
        orderMapper = new OrderMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getOrderSample1();
        var actual = orderMapper.toEntity(orderMapper.toDto(expected));
        assertOrderAllPropertiesEquals(expected, actual);
    }
}
