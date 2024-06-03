package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A InventoryTransaction.
 */
@Entity
@Table(name = "tb_inventory_transaction")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InventoryTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "invoice_id", nullable = false)
    private Long invoiceId;

    @Column(name = "transaction_created_date")
    private Instant transactionCreatedDate;

    @Column(name = "transaction_modified_date")
    private Instant transactionModifiedDate;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Size(max = 255)
    @Column(name = "comments", length = 255)
    private String comments;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "productsLists", "inventoryTransactionsLists" }, allowSetters = true)
    private Supplier supplier;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "brand", "productsLists", "stockLevelsLists", "suppliersLists" }, allowSetters = true)
    private Product product;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "inventoryTransactionsLists", "stockLevelsLists" }, allowSetters = true)
    private Warehouse warehouse;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public InventoryTransaction id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoiceId() {
        return this.invoiceId;
    }

    public InventoryTransaction invoiceId(Long invoiceId) {
        this.setInvoiceId(invoiceId);
        return this;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Instant getTransactionCreatedDate() {
        return this.transactionCreatedDate;
    }

    public InventoryTransaction transactionCreatedDate(Instant transactionCreatedDate) {
        this.setTransactionCreatedDate(transactionCreatedDate);
        return this;
    }

    public void setTransactionCreatedDate(Instant transactionCreatedDate) {
        this.transactionCreatedDate = transactionCreatedDate;
    }

    public Instant getTransactionModifiedDate() {
        return this.transactionModifiedDate;
    }

    public InventoryTransaction transactionModifiedDate(Instant transactionModifiedDate) {
        this.setTransactionModifiedDate(transactionModifiedDate);
        return this;
    }

    public void setTransactionModifiedDate(Instant transactionModifiedDate) {
        this.transactionModifiedDate = transactionModifiedDate;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public InventoryTransaction quantity(Integer quantity) {
        this.setQuantity(quantity);
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return this.comments;
    }

    public InventoryTransaction comments(String comments) {
        this.setComments(comments);
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public InventoryTransaction supplier(Supplier supplier) {
        this.setSupplier(supplier);
        return this;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public InventoryTransaction product(Product product) {
        this.setProduct(product);
        return this;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public InventoryTransaction warehouse(Warehouse warehouse) {
        this.setWarehouse(warehouse);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InventoryTransaction)) {
            return false;
        }
        return getId() != null && getId().equals(((InventoryTransaction) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InventoryTransaction{" +
            "id=" + getId() +
            ", invoiceId=" + getInvoiceId() +
            ", transactionCreatedDate='" + getTransactionCreatedDate() + "'" +
            ", transactionModifiedDate='" + getTransactionModifiedDate() + "'" +
            ", quantity=" + getQuantity() +
            ", comments='" + getComments() + "'" +
            "}";
    }
}