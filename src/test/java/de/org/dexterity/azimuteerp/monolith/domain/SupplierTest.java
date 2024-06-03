package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.InventoryTransactionTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.ProductTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.SupplierTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SupplierTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Supplier.class);
        Supplier supplier1 = getSupplierSample1();
        Supplier supplier2 = new Supplier();
        assertThat(supplier1).isNotEqualTo(supplier2);

        supplier2.setId(supplier1.getId());
        assertThat(supplier1).isEqualTo(supplier2);

        supplier2 = getSupplierSample2();
        assertThat(supplier1).isNotEqualTo(supplier2);
    }

    @Test
    void productsListTest() {
        Supplier supplier = getSupplierRandomSampleGenerator();
        Product productBack = getProductRandomSampleGenerator();

        supplier.addProductsList(productBack);
        assertThat(supplier.getProductsLists()).containsOnly(productBack);

        supplier.removeProductsList(productBack);
        assertThat(supplier.getProductsLists()).doesNotContain(productBack);

        supplier.productsLists(new HashSet<>(Set.of(productBack)));
        assertThat(supplier.getProductsLists()).containsOnly(productBack);

        supplier.setProductsLists(new HashSet<>());
        assertThat(supplier.getProductsLists()).doesNotContain(productBack);
    }

    @Test
    void inventoryTransactionsListTest() {
        Supplier supplier = getSupplierRandomSampleGenerator();
        InventoryTransaction inventoryTransactionBack = getInventoryTransactionRandomSampleGenerator();

        supplier.addInventoryTransactionsList(inventoryTransactionBack);
        assertThat(supplier.getInventoryTransactionsLists()).containsOnly(inventoryTransactionBack);
        assertThat(inventoryTransactionBack.getSupplier()).isEqualTo(supplier);

        supplier.removeInventoryTransactionsList(inventoryTransactionBack);
        assertThat(supplier.getInventoryTransactionsLists()).doesNotContain(inventoryTransactionBack);
        assertThat(inventoryTransactionBack.getSupplier()).isNull();

        supplier.inventoryTransactionsLists(new HashSet<>(Set.of(inventoryTransactionBack)));
        assertThat(supplier.getInventoryTransactionsLists()).containsOnly(inventoryTransactionBack);
        assertThat(inventoryTransactionBack.getSupplier()).isEqualTo(supplier);

        supplier.setInventoryTransactionsLists(new HashSet<>());
        assertThat(supplier.getInventoryTransactionsLists()).doesNotContain(inventoryTransactionBack);
        assertThat(inventoryTransactionBack.getSupplier()).isNull();
    }
}
