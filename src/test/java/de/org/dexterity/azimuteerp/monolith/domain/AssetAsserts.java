package de.org.dexterity.azimuteerp.monolith.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class AssetAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAssetAllPropertiesEquals(Asset expected, Asset actual) {
        assertAssetAutoGeneratedPropertiesEquals(expected, actual);
        assertAssetAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAssetAllUpdatablePropertiesEquals(Asset expected, Asset actual) {
        assertAssetUpdatableFieldsEquals(expected, actual);
        assertAssetUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAssetAutoGeneratedPropertiesEquals(Asset expected, Asset actual) {
        assertThat(expected)
            .as("Verify Asset auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAssetUpdatableFieldsEquals(Asset expected, Asset actual) {
        assertThat(expected)
            .as("Verify Asset relevant properties")
            .satisfies(e -> assertThat(e.getUid()).as("check uid").isEqualTo(actual.getUid()))
            .satisfies(e -> assertThat(e.getName()).as("check name").isEqualTo(actual.getName()))
            .satisfies(e -> assertThat(e.getStorageTypeUsed()).as("check storageTypeUsed").isEqualTo(actual.getStorageTypeUsed()))
            .satisfies(e -> assertThat(e.getFullFilenamePath()).as("check fullFilenamePath").isEqualTo(actual.getFullFilenamePath()))
            .satisfies(e -> assertThat(e.getStatus()).as("check status").isEqualTo(actual.getStatus()))
            .satisfies(e -> assertThat(e.getPreferredPurpose()).as("check preferredPurpose").isEqualTo(actual.getPreferredPurpose()))
            .satisfies(e -> assertThat(e.getAssetContentAsBlob()).as("check assetContentAsBlob").isEqualTo(actual.getAssetContentAsBlob()))
            .satisfies(
                e ->
                    assertThat(e.getAssetContentAsBlobContentType())
                        .as("check assetContentAsBlob contenty type")
                        .isEqualTo(actual.getAssetContentAsBlobContentType())
            );
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertAssetUpdatableRelationshipsEquals(Asset expected, Asset actual) {
        assertThat(expected)
            .as("Verify Asset relationships")
            .satisfies(e -> assertThat(e.getAssetType()).as("check assetType").isEqualTo(actual.getAssetType()))
            .satisfies(e -> assertThat(e.getRawAssetProcTmp()).as("check rawAssetProcTmp").isEqualTo(actual.getRawAssetProcTmp()));
    }
}
