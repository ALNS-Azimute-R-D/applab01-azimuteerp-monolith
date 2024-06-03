package de.org.dexterity.azimuteerp.monolith.service.dto;

import de.org.dexterity.azimuteerp.monolith.domain.enumeration.StatusRawProcessingEnum;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmp} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RawAssetProcTmpDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    private StatusRawProcessingEnum statusRawProcessing;

    @Size(max = 512)
    private String fullFilenamePath;

    @Lob
    private byte[] assetRawContentAsBlob;

    private String assetRawContentAsBlobContentType;

    @Lob
    private String extraDetails;

    @NotNull
    private AssetTypeDTO assetType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusRawProcessingEnum getStatusRawProcessing() {
        return statusRawProcessing;
    }

    public void setStatusRawProcessing(StatusRawProcessingEnum statusRawProcessing) {
        this.statusRawProcessing = statusRawProcessing;
    }

    public String getFullFilenamePath() {
        return fullFilenamePath;
    }

    public void setFullFilenamePath(String fullFilenamePath) {
        this.fullFilenamePath = fullFilenamePath;
    }

    public byte[] getAssetRawContentAsBlob() {
        return assetRawContentAsBlob;
    }

    public void setAssetRawContentAsBlob(byte[] assetRawContentAsBlob) {
        this.assetRawContentAsBlob = assetRawContentAsBlob;
    }

    public String getAssetRawContentAsBlobContentType() {
        return assetRawContentAsBlobContentType;
    }

    public void setAssetRawContentAsBlobContentType(String assetRawContentAsBlobContentType) {
        this.assetRawContentAsBlobContentType = assetRawContentAsBlobContentType;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public AssetTypeDTO getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetTypeDTO assetType) {
        this.assetType = assetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RawAssetProcTmpDTO)) {
            return false;
        }

        RawAssetProcTmpDTO rawAssetProcTmpDTO = (RawAssetProcTmpDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, rawAssetProcTmpDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RawAssetProcTmpDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", statusRawProcessing='" + getStatusRawProcessing() + "'" +
            ", fullFilenamePath='" + getFullFilenamePath() + "'" +
            ", assetRawContentAsBlob='" + getAssetRawContentAsBlob() + "'" +
            ", extraDetails='" + getExtraDetails() + "'" +
            ", assetType=" + getAssetType() +
            "}";
    }
}
