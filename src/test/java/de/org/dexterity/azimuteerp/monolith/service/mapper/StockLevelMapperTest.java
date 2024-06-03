package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.StockLevelAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.StockLevelTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockLevelMapperTest {

    private StockLevelMapper stockLevelMapper;

    @BeforeEach
    void setUp() {
        stockLevelMapper = new StockLevelMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getStockLevelSample1();
        var actual = stockLevelMapper.toEntity(stockLevelMapper.toDto(expected));
        assertStockLevelAllPropertiesEquals(expected, actual);
    }
}
