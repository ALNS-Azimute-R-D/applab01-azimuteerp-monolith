package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.AssetMetadataTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.AssetTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AssetMetadataTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssetMetadata.class);
        AssetMetadata assetMetadata1 = getAssetMetadataSample1();
        AssetMetadata assetMetadata2 = new AssetMetadata();
        assertThat(assetMetadata1).isNotEqualTo(assetMetadata2);

        assetMetadata2.setId(assetMetadata1.getId());
        assertThat(assetMetadata1).isEqualTo(assetMetadata2);

        assetMetadata2 = getAssetMetadataSample2();
        assertThat(assetMetadata1).isNotEqualTo(assetMetadata2);
    }

    @Test
    void assetTest() {
        AssetMetadata assetMetadata = getAssetMetadataRandomSampleGenerator();
        Asset assetBack = getAssetRandomSampleGenerator();

        assetMetadata.setAsset(assetBack);
        assertThat(assetMetadata.getAsset()).isEqualTo(assetBack);

        assetMetadata.asset(null);
        assertThat(assetMetadata.getAsset()).isNull();
    }
}
