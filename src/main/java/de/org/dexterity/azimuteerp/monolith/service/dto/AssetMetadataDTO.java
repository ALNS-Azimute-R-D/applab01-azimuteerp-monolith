package de.org.dexterity.azimuteerp.monolith.service.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.AssetMetadata} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AssetMetadataDTO implements Serializable {

    private Long id;

    @Lob
    private String metadataDetails;

    @NotNull
    private AssetDTO asset;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetadataDetails() {
        return metadataDetails;
    }

    public void setMetadataDetails(String metadataDetails) {
        this.metadataDetails = metadataDetails;
    }

    public AssetDTO getAsset() {
        return asset;
    }

    public void setAsset(AssetDTO asset) {
        this.asset = asset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AssetMetadataDTO)) {
            return false;
        }

        AssetMetadataDTO assetMetadataDTO = (AssetMetadataDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, assetMetadataDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AssetMetadataDTO{" +
            "id=" + getId() +
            ", metadataDetails='" + getMetadataDetails() + "'" +
            ", asset=" + getAsset() +
            "}";
    }
}
