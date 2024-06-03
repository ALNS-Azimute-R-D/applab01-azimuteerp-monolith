package de.org.dexterity.azimuteerp.monolith.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class AssetTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Asset getAssetSample1() {
        return new Asset()
            .id(1L)
            .uid(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .name("name1")
            .fullFilenamePath("fullFilenamePath1");
    }

    public static Asset getAssetSample2() {
        return new Asset()
            .id(2L)
            .uid(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .name("name2")
            .fullFilenamePath("fullFilenamePath2");
    }

    public static Asset getAssetRandomSampleGenerator() {
        return new Asset()
            .id(longCount.incrementAndGet())
            .uid(UUID.randomUUID())
            .name(UUID.randomUUID().toString())
            .fullFilenamePath(UUID.randomUUID().toString());
    }
}
