package de.org.dexterity.azimuteerp.monolith.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class InvoiceTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Invoice getInvoiceSample1() {
        return new Invoice()
            .id(1L)
            .businessCode("businessCode1")
            .originalOrderId(1L)
            .description("description1")
            .numberOfInstallmentsOriginal(1)
            .numberOfInstallmentsPaid(1);
    }

    public static Invoice getInvoiceSample2() {
        return new Invoice()
            .id(2L)
            .businessCode("businessCode2")
            .originalOrderId(2L)
            .description("description2")
            .numberOfInstallmentsOriginal(2)
            .numberOfInstallmentsPaid(2);
    }

    public static Invoice getInvoiceRandomSampleGenerator() {
        return new Invoice()
            .id(longCount.incrementAndGet())
            .businessCode(UUID.randomUUID().toString())
            .originalOrderId(longCount.incrementAndGet())
            .description(UUID.randomUUID().toString())
            .numberOfInstallmentsOriginal(intCount.incrementAndGet())
            .numberOfInstallmentsPaid(intCount.incrementAndGet());
    }
}
