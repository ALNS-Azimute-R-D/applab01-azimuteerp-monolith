package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.AssetTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.AssetTypeTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmpTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class AssetTypeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssetType.class);
        AssetType assetType1 = getAssetTypeSample1();
        AssetType assetType2 = new AssetType();
        assertThat(assetType1).isNotEqualTo(assetType2);

        assetType2.setId(assetType1.getId());
        assertThat(assetType1).isEqualTo(assetType2);

        assetType2 = getAssetTypeSample2();
        assertThat(assetType1).isNotEqualTo(assetType2);
    }

    @Test
    void rawAssetsProcsTmpsTest() {
        AssetType assetType = getAssetTypeRandomSampleGenerator();
        RawAssetProcTmp rawAssetProcTmpBack = getRawAssetProcTmpRandomSampleGenerator();

        assetType.addRawAssetsProcsTmps(rawAssetProcTmpBack);
        assertThat(assetType.getRawAssetsProcsTmps()).containsOnly(rawAssetProcTmpBack);
        assertThat(rawAssetProcTmpBack.getAssetType()).isEqualTo(assetType);

        assetType.removeRawAssetsProcsTmps(rawAssetProcTmpBack);
        assertThat(assetType.getRawAssetsProcsTmps()).doesNotContain(rawAssetProcTmpBack);
        assertThat(rawAssetProcTmpBack.getAssetType()).isNull();

        assetType.rawAssetsProcsTmps(new HashSet<>(Set.of(rawAssetProcTmpBack)));
        assertThat(assetType.getRawAssetsProcsTmps()).containsOnly(rawAssetProcTmpBack);
        assertThat(rawAssetProcTmpBack.getAssetType()).isEqualTo(assetType);

        assetType.setRawAssetsProcsTmps(new HashSet<>());
        assertThat(assetType.getRawAssetsProcsTmps()).doesNotContain(rawAssetProcTmpBack);
        assertThat(rawAssetProcTmpBack.getAssetType()).isNull();
    }

    @Test
    void assetsTest() {
        AssetType assetType = getAssetTypeRandomSampleGenerator();
        Asset assetBack = getAssetRandomSampleGenerator();

        assetType.addAssets(assetBack);
        assertThat(assetType.getAssets()).containsOnly(assetBack);
        assertThat(assetBack.getAssetType()).isEqualTo(assetType);

        assetType.removeAssets(assetBack);
        assertThat(assetType.getAssets()).doesNotContain(assetBack);
        assertThat(assetBack.getAssetType()).isNull();

        assetType.assets(new HashSet<>(Set.of(assetBack)));
        assertThat(assetType.getAssets()).containsOnly(assetBack);
        assertThat(assetBack.getAssetType()).isEqualTo(assetType);

        assetType.setAssets(new HashSet<>());
        assertThat(assetType.getAssets()).doesNotContain(assetBack);
        assertThat(assetBack.getAssetType()).isNull();
    }
}
