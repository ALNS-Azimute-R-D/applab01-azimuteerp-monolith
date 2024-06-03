package de.org.dexterity.azimuteerp.monolith.service.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.StockLevel} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StockLevelDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant lastModifiedDate;

    @NotNull
    private Integer ramainingQuantity;

    @Lob
    private String extraDetails;

    @NotNull
    private WarehouseDTO warehouse;

    @NotNull
    private ProductDTO product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getRamainingQuantity() {
        return ramainingQuantity;
    }

    public void setRamainingQuantity(Integer ramainingQuantity) {
        this.ramainingQuantity = ramainingQuantity;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public WarehouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StockLevelDTO)) {
            return false;
        }

        StockLevelDTO stockLevelDTO = (StockLevelDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, stockLevelDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StockLevelDTO{" +
            "id=" + getId() +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            ", ramainingQuantity=" + getRamainingQuantity() +
            ", extraDetails='" + getExtraDetails() + "'" +
            ", warehouse=" + getWarehouse() +
            ", product=" + getProduct() +
            "}";
    }
}
