package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.ProductTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.StockLevelTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.WarehouseTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class StockLevelTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(StockLevel.class);
        StockLevel stockLevel1 = getStockLevelSample1();
        StockLevel stockLevel2 = new StockLevel();
        assertThat(stockLevel1).isNotEqualTo(stockLevel2);

        stockLevel2.setId(stockLevel1.getId());
        assertThat(stockLevel1).isEqualTo(stockLevel2);

        stockLevel2 = getStockLevelSample2();
        assertThat(stockLevel1).isNotEqualTo(stockLevel2);
    }

    @Test
    void warehouseTest() {
        StockLevel stockLevel = getStockLevelRandomSampleGenerator();
        Warehouse warehouseBack = getWarehouseRandomSampleGenerator();

        stockLevel.setWarehouse(warehouseBack);
        assertThat(stockLevel.getWarehouse()).isEqualTo(warehouseBack);

        stockLevel.warehouse(null);
        assertThat(stockLevel.getWarehouse()).isNull();
    }

    @Test
    void productTest() {
        StockLevel stockLevel = getStockLevelRandomSampleGenerator();
        Product productBack = getProductRandomSampleGenerator();

        stockLevel.setProduct(productBack);
        assertThat(stockLevel.getProduct()).isEqualTo(productBack);

        stockLevel.product(null);
        assertThat(stockLevel.getProduct()).isNull();
    }
}
