package de.org.dexterity.azimuteerp.monolith.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TenantTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Tenant getTenantSample1() {
        return new Tenant()
            .id(1L)
            .acronym("acronym1")
            .name("name1")
            .description("description1")
            .customerBusinessCode("customerBusinessCode1")
            .businessHandlerClazz("businessHandlerClazz1");
    }

    public static Tenant getTenantSample2() {
        return new Tenant()
            .id(2L)
            .acronym("acronym2")
            .name("name2")
            .description("description2")
            .customerBusinessCode("customerBusinessCode2")
            .businessHandlerClazz("businessHandlerClazz2");
    }

    public static Tenant getTenantRandomSampleGenerator() {
        return new Tenant()
            .id(longCount.incrementAndGet())
            .acronym(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .customerBusinessCode(UUID.randomUUID().toString())
            .businessHandlerClazz(UUID.randomUUID().toString());
    }
}
