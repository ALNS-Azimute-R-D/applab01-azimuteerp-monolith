package org.dexterity.darueira.azimuteerp.monolith.spring.domain;

import java.util.UUID;

public class AssetTestSamples {

    public static Asset getAssetSample1() {
        return new Asset().id(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa")).name("name1").fullFilenamePath("fullFilenamePath1");
    }

    public static Asset getAssetSample2() {
        return new Asset().id(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367")).name("name2").fullFilenamePath("fullFilenamePath2");
    }

    public static Asset getAssetRandomSampleGenerator() {
        return new Asset().id(UUID.randomUUID()).name(UUID.randomUUID().toString()).fullFilenamePath(UUID.randomUUID().toString());
    }
}
