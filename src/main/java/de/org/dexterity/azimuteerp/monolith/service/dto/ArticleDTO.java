package de.org.dexterity.azimuteerp.monolith.service.dto;

import de.org.dexterity.azimuteerp.monolith.domain.enumeration.SizeOptionEnum;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.Article} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ArticleDTO implements Serializable {

    private Long id;

    @NotNull
    private Long inventoryProductId;

    @Size(max = 150)
    private String customName;

    @Lob
    private String customDescription;

    private BigDecimal priceValue;

    @NotNull
    private SizeOptionEnum itemSize;

    @Size(max = 255)
    private String assetsCollectionUUID;

    private Boolean isEnabled;

    private CategoryDTO mainCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInventoryProductId() {
        return inventoryProductId;
    }

    public void setInventoryProductId(Long inventoryProductId) {
        this.inventoryProductId = inventoryProductId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCustomDescription() {
        return customDescription;
    }

    public void setCustomDescription(String customDescription) {
        this.customDescription = customDescription;
    }

    public BigDecimal getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }

    public SizeOptionEnum getItemSize() {
        return itemSize;
    }

    public void setItemSize(SizeOptionEnum itemSize) {
        this.itemSize = itemSize;
    }

    public String getAssetsCollectionUUID() {
        return assetsCollectionUUID;
    }

    public void setAssetsCollectionUUID(String assetsCollectionUUID) {
        this.assetsCollectionUUID = assetsCollectionUUID;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public CategoryDTO getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(CategoryDTO mainCategory) {
        this.mainCategory = mainCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ArticleDTO)) {
            return false;
        }

        ArticleDTO articleDTO = (ArticleDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, articleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ArticleDTO{" +
            "id=" + getId() +
            ", inventoryProductId=" + getInventoryProductId() +
            ", customName='" + getCustomName() + "'" +
            ", customDescription='" + getCustomDescription() + "'" +
            ", priceValue=" + getPriceValue() +
            ", itemSize='" + getItemSize() + "'" +
            ", assetsCollectionUUID='" + getAssetsCollectionUUID() + "'" +
            ", isEnabled='" + getIsEnabled() + "'" +
            ", mainCategory=" + getMainCategory() +
            "}";
    }
}
