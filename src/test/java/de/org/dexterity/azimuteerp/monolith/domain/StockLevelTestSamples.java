package de.org.dexterity.azimuteerp.monolith.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class StockLevelTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static StockLevel getStockLevelSample1() {
        return new StockLevel().id(1L).ramainingQuantity(1);
    }

    public static StockLevel getStockLevelSample2() {
        return new StockLevel().id(2L).ramainingQuantity(2);
    }

    public static StockLevel getStockLevelRandomSampleGenerator() {
        return new StockLevel().id(longCount.incrementAndGet()).ramainingQuantity(intCount.incrementAndGet());
    }
}
