package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A StockLevel.
 */
@Entity
@Table(name = "tb_stock_level")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StockLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "last_modified_date", nullable = false)
    private Instant lastModifiedDate;

    @NotNull
    @Column(name = "ramaining_quantity", nullable = false)
    private Integer ramainingQuantity;

    @Lob
    @Column(name = "extra_details")
    private String extraDetails;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "inventoryTransactionsLists", "stockLevelsLists" }, allowSetters = true)
    private Warehouse warehouse;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "brand", "productsLists", "stockLevelsLists", "suppliersLists" }, allowSetters = true)
    private Product product;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public StockLevel id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public StockLevel lastModifiedDate(Instant lastModifiedDate) {
        this.setLastModifiedDate(lastModifiedDate);
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getRamainingQuantity() {
        return this.ramainingQuantity;
    }

    public StockLevel ramainingQuantity(Integer ramainingQuantity) {
        this.setRamainingQuantity(ramainingQuantity);
        return this;
    }

    public void setRamainingQuantity(Integer ramainingQuantity) {
        this.ramainingQuantity = ramainingQuantity;
    }

    public String getExtraDetails() {
        return this.extraDetails;
    }

    public StockLevel extraDetails(String extraDetails) {
        this.setExtraDetails(extraDetails);
        return this;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public StockLevel warehouse(Warehouse warehouse) {
        this.setWarehouse(warehouse);
        return this;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public StockLevel product(Product product) {
        this.setProduct(product);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StockLevel)) {
            return false;
        }
        return getId() != null && getId().equals(((StockLevel) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StockLevel{" +
            "id=" + getId() +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            ", ramainingQuantity=" + getRamainingQuantity() +
            ", extraDetails='" + getExtraDetails() + "'" +
            "}";
    }
}
