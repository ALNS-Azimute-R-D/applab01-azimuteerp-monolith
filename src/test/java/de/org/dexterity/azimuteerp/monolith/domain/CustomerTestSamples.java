package de.org.dexterity.azimuteerp.monolith.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Customer getCustomerSample1() {
        return new Customer()
            .id(1L)
            .customerBusinessCode("customerBusinessCode1")
            .name("name1")
            .email("email1")
            .addressDetails("addressDetails1")
            .zipCode("zipCode1")
            .keycloakGroupDetails("keycloakGroupDetails1");
    }

    public static Customer getCustomerSample2() {
        return new Customer()
            .id(2L)
            .customerBusinessCode("customerBusinessCode2")
            .name("name2")
            .email("email2")
            .addressDetails("addressDetails2")
            .zipCode("zipCode2")
            .keycloakGroupDetails("keycloakGroupDetails2");
    }

    public static Customer getCustomerRandomSampleGenerator() {
        return new Customer()
            .id(longCount.incrementAndGet())
            .customerBusinessCode(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .email(UUID.randomUUID().toString())
            .addressDetails(UUID.randomUUID().toString())
            .zipCode(UUID.randomUUID().toString())
            .keycloakGroupDetails(UUID.randomUUID().toString());
    }
}
