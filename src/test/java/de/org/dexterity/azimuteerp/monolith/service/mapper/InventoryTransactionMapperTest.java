package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.InventoryTransactionAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.InventoryTransactionTestSamples.*;

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
