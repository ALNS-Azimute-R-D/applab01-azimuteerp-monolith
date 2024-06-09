package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.WarehouseAsserts.*;
import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.WarehouseTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseMapperTest {

    private WarehouseMapper warehouseMapper;

    @BeforeEach
    void setUp() {
        warehouseMapper = new WarehouseMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getWarehouseSample1();
        var actual = warehouseMapper.toEntity(warehouseMapper.toDto(expected));
        assertWarehouseAllPropertiesEquals(expected, actual);
    }
}
