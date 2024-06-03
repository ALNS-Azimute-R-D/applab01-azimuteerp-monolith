package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.BrandTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.InventoryTransactionTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.ProductTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.StockLevelTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.SupplierTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Product.class);
        Product product1 = getProductSample1();
        Product product2 = new Product();
        assertThat(product1).isNotEqualTo(product2);

        product2.setId(product1.getId());
        assertThat(product1).isEqualTo(product2);

        product2 = getProductSample2();
        assertThat(product1).isNotEqualTo(product2);
    }

    @Test
    void brandTest() {
        Product product = getProductRandomSampleGenerator();
        Brand brandBack = getBrandRandomSampleGenerator();

        product.setBrand(brandBack);
        assertThat(product.getBrand()).isEqualTo(brandBack);

        product.brand(null);
        assertThat(product.getBrand()).isNull();
    }

    @Test
    void productsListTest() {
        Product product = getProductRandomSampleGenerator();
        InventoryTransaction inventoryTransactionBack = getInventoryTransactionRandomSampleGenerator();

        product.addProductsList(inventoryTransactionBack);
        assertThat(product.getProductsLists()).containsOnly(inventoryTransactionBack);
        assertThat(inventoryTransactionBack.getProduct()).isEqualTo(product);

        product.removeProductsList(inventoryTransactionBack);
        assertThat(product.getProductsLists()).doesNotContain(inventoryTransactionBack);
        assertThat(inventoryTransactionBack.getProduct()).isNull();

        product.productsLists(new HashSet<>(Set.of(inventoryTransactionBack)));
        assertThat(product.getProductsLists()).containsOnly(inventoryTransactionBack);
        assertThat(inventoryTransactionBack.getProduct()).isEqualTo(product);

        product.setProductsLists(new HashSet<>());
        assertThat(product.getProductsLists()).doesNotContain(inventoryTransactionBack);
        assertThat(inventoryTransactionBack.getProduct()).isNull();
    }

    @Test
    void stockLevelsListTest() {
        Product product = getProductRandomSampleGenerator();
        StockLevel stockLevelBack = getStockLevelRandomSampleGenerator();

        product.addStockLevelsList(stockLevelBack);
        assertThat(product.getStockLevelsLists()).containsOnly(stockLevelBack);
        assertThat(stockLevelBack.getProduct()).isEqualTo(product);

        product.removeStockLevelsList(stockLevelBack);
        assertThat(product.getStockLevelsLists()).doesNotContain(stockLevelBack);
        assertThat(stockLevelBack.getProduct()).isNull();

        product.stockLevelsLists(new HashSet<>(Set.of(stockLevelBack)));
        assertThat(product.getStockLevelsLists()).containsOnly(stockLevelBack);
        assertThat(stockLevelBack.getProduct()).isEqualTo(product);

        product.setStockLevelsLists(new HashSet<>());
        assertThat(product.getStockLevelsLists()).doesNotContain(stockLevelBack);
        assertThat(stockLevelBack.getProduct()).isNull();
    }

    @Test
    void suppliersListTest() {
        Product product = getProductRandomSampleGenerator();
        Supplier supplierBack = getSupplierRandomSampleGenerator();

        product.addSuppliersList(supplierBack);
        assertThat(product.getSuppliersLists()).containsOnly(supplierBack);
        assertThat(supplierBack.getProductsLists()).containsOnly(product);

        product.removeSuppliersList(supplierBack);
        assertThat(product.getSuppliersLists()).doesNotContain(supplierBack);
        assertThat(supplierBack.getProductsLists()).doesNotContain(product);

        product.suppliersLists(new HashSet<>(Set.of(supplierBack)));
        assertThat(product.getSuppliersLists()).containsOnly(supplierBack);
        assertThat(supplierBack.getProductsLists()).containsOnly(product);

        product.setSuppliersLists(new HashSet<>());
        assertThat(product.getSuppliersLists()).doesNotContain(supplierBack);
        assertThat(supplierBack.getProductsLists()).doesNotContain(product);
    }
}
