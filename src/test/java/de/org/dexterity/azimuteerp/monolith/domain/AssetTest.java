package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.AssetMetadataTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.AssetTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.AssetTypeTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmpTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AssetTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Asset.class);
        Asset asset1 = getAssetSample1();
        Asset asset2 = new Asset();
        assertThat(asset1).isNotEqualTo(asset2);

        asset2.setId(asset1.getId());
        assertThat(asset1).isEqualTo(asset2);

        asset2 = getAssetSample2();
        assertThat(asset1).isNotEqualTo(asset2);
    }

    @Test
    void assetTypeTest() {
        Asset asset = getAssetRandomSampleGenerator();
        AssetType assetTypeBack = getAssetTypeRandomSampleGenerator();

        asset.setAssetType(assetTypeBack);
        assertThat(asset.getAssetType()).isEqualTo(assetTypeBack);

        asset.assetType(null);
        assertThat(asset.getAssetType()).isNull();
    }

    @Test
    void rawAssetProcTmpTest() {
        Asset asset = getAssetRandomSampleGenerator();
        RawAssetProcTmp rawAssetProcTmpBack = getRawAssetProcTmpRandomSampleGenerator();

        asset.setRawAssetProcTmp(rawAssetProcTmpBack);
        assertThat(asset.getRawAssetProcTmp()).isEqualTo(rawAssetProcTmpBack);

        asset.rawAssetProcTmp(null);
        assertThat(asset.getRawAssetProcTmp()).isNull();
    }

    @Test
    void assetMetadataTest() {
        Asset asset = getAssetRandomSampleGenerator();
        AssetMetadata assetMetadataBack = getAssetMetadataRandomSampleGenerator();

        asset.setAssetMetadata(assetMetadataBack);
        assertThat(asset.getAssetMetadata()).isEqualTo(assetMetadataBack);
        assertThat(assetMetadataBack.getAsset()).isEqualTo(asset);

        asset.assetMetadata(null);
        assertThat(asset.getAssetMetadata()).isNull();
        assertThat(assetMetadataBack.getAsset()).isNull();
    }
}
