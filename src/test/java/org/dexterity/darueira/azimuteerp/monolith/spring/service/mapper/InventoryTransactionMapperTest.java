package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.InventoryTransactionAsserts.*;
import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.InventoryTransactionTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTransactionMapperTest {

    private InventoryTransactionMapper inventoryTransactionMapper;

    @BeforeEach
    void setUp() {
        inventoryTransactionMapper = new InventoryTransactionMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getInventoryTransactionSample1();
        var actual = inventoryTransactionMapper.toEntity(inventoryTransactionMapper.toDto(expected));
        assertInventoryTransactionAllPropertiesEquals(expected, actual);
    }
}
