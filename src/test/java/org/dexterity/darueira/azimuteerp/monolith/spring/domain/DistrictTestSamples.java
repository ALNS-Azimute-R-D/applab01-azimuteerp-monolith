package org.dexterity.darueira.azimuteerp.monolith.spring.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class DistrictTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static District getDistrictSample1() {
        return new District().id(1L).acronym("acronym1").name("name1");
    }

    public static District getDistrictSample2() {
        return new District().id(2L).acronym("acronym2").name("name2");
    }

    public static District getDistrictRandomSampleGenerator() {
        return new District().id(longCount.incrementAndGet()).acronym(UUID.randomUUID().toString()).name(UUID.randomUUID().toString());
    }
}
