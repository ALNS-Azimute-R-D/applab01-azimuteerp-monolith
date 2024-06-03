package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A AssetMetadata.
 */
@Entity
@Table(name = "tb_asset_metadata")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AssetMetadata implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "metadata_details")
    private String metadataDetails;

    @JsonIgnoreProperties(value = { "assetType", "rawAssetProcTmp", "assetMetadata" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private Asset asset;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public AssetMetadata id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetadataDetails() {
        return this.metadataDetails;
    }

    public AssetMetadata metadataDetails(String metadataDetails) {
        this.setMetadataDetails(metadataDetails);
        return this;
    }

    public void setMetadataDetails(String metadataDetails) {
        this.metadataDetails = metadataDetails;
    }

    public Asset getAsset() {
        return this.asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public AssetMetadata asset(Asset asset) {
        this.setAsset(asset);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AssetMetadata)) {
            return false;
        }
        return getId() != null && getId().equals(((AssetMetadata) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AssetMetadata{" +
            "id=" + getId() +
            ", metadataDetails='" + getMetadataDetails() + "'" +
            "}";
    }
}
