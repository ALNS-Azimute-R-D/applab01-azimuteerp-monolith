package de.org.dexterity.azimuteerp.monolith.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ArticleTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Article getArticleSample1() {
        return new Article().id(1L).inventoryProductId(1L).customName("customName1").assetsCollectionUUID("assetsCollectionUUID1");
    }

    public static Article getArticleSample2() {
        return new Article().id(2L).inventoryProductId(2L).customName("customName2").assetsCollectionUUID("assetsCollectionUUID2");
    }

    public static Article getArticleRandomSampleGenerator() {
        return new Article()
            .id(longCount.incrementAndGet())
            .inventoryProductId(longCount.incrementAndGet())
            .customName(UUID.randomUUID().toString())
            .assetsCollectionUUID(UUID.randomUUID().toString());
    }
}
