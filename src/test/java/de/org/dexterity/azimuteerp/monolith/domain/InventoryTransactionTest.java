package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.InventoryTransactionTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.ProductTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.SupplierTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.WarehouseTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class InventoryTransactionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(InventoryTransaction.class);
        InventoryTransaction inventoryTransaction1 = getInventoryTransactionSample1();
        InventoryTransaction inventoryTransaction2 = new InventoryTransaction();
        assertThat(inventoryTransaction1).isNotEqualTo(inventoryTransaction2);

        inventoryTransaction2.setId(inventoryTransaction1.getId());
        assertThat(inventoryTransaction1).isEqualTo(inventoryTransaction2);

        inventoryTransaction2 = getInventoryTransactionSample2();
        assertThat(inventoryTransaction1).isNotEqualTo(inventoryTransaction2);
    }

    @Test
    void supplierTest() {
        InventoryTransaction inventoryTransaction = getInventoryTransactionRandomSampleGenerator();
        Supplier supplierBack = getSupplierRandomSampleGenerator();

        inventoryTransaction.setSupplier(supplierBack);
        assertThat(inventoryTransaction.getSupplier()).isEqualTo(supplierBack);

        inventoryTransaction.supplier(null);
        assertThat(inventoryTransaction.getSupplier()).isNull();
    }

    @Test
    void productTest() {
        InventoryTransaction inventoryTransaction = getInventoryTransactionRandomSampleGenerator();
        Product productBack = getProductRandomSampleGenerator();

        inventoryTransaction.setProduct(productBack);
        assertThat(inventoryTransaction.getProduct()).isEqualTo(productBack);

        inventoryTransaction.product(null);
        assertThat(inventoryTransaction.getProduct()).isNull();
    }

    @Test
    void warehouseTest() {
        InventoryTransaction inventoryTransaction = getInventoryTransactionRandomSampleGenerator();
        Warehouse warehouseBack = getWarehouseRandomSampleGenerator();

        inventoryTransaction.setWarehouse(warehouseBack);
        assertThat(inventoryTransaction.getWarehouse()).isEqualTo(warehouseBack);

        inventoryTransaction.warehouse(null);
        assertThat(inventoryTransaction.getWarehouse()).isNull();
    }
}
