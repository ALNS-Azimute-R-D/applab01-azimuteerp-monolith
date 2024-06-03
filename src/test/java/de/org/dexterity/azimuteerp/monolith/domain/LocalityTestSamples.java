package de.org.dexterity.azimuteerp.monolith.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class LocalityTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Locality getLocalitySample1() {
        return new Locality().id(1L).acronym("acronym1").name("name1");
    }

    public static Locality getLocalitySample2() {
        return new Locality().id(2L).acronym("acronym2").name("name2");
    }

    public static Locality getLocalityRandomSampleGenerator() {
        return new Locality().id(longCount.incrementAndGet()).acronym(UUID.randomUUID().toString()).name(UUID.randomUUID().toString());
    }
}
