package de.org.dexterity.azimuteerp.monolith.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class SupplierTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Supplier getSupplierSample1() {
        return new Supplier()
            .id(1L)
            .acronym("acronym1")
            .companyName("companyName1")
            .representativeLastName("representativeLastName1")
            .representativeFirstName("representativeFirstName1")
            .jobTitle("jobTitle1")
            .streetAddress("streetAddress1")
            .houseNumber("houseNumber1")
            .locationName("locationName1")
            .city("city1")
            .stateProvince("stateProvince1")
            .zipPostalCode("zipPostalCode1")
            .countryRegion("countryRegion1")
            .mainEmail("mainEmail1")
            .landPhoneNumber("landPhoneNumber1")
            .mobilePhoneNumber("mobilePhoneNumber1")
            .faxNumber("faxNumber1");
    }

    public static Supplier getSupplierSample2() {
        return new Supplier()
            .id(2L)
            .acronym("acronym2")
            .companyName("companyName2")
            .representativeLastName("representativeLastName2")
            .representativeFirstName("representativeFirstName2")
            .jobTitle("jobTitle2")
            .streetAddress("streetAddress2")
            .houseNumber("houseNumber2")
            .locationName("locationName2")
            .city("city2")
            .stateProvince("stateProvince2")
            .zipPostalCode("zipPostalCode2")
            .countryRegion("countryRegion2")
            .mainEmail("mainEmail2")
            .landPhoneNumber("landPhoneNumber2")
            .mobilePhoneNumber("mobilePhoneNumber2")
            .faxNumber("faxNumber2");
    }

    public static Supplier getSupplierRandomSampleGenerator() {
        return new Supplier()
            .id(longCount.incrementAndGet())
            .acronym(UUID.randomUUID().toString())
            .companyName(UUID.randomUUID().toString())
            .representativeLastName(UUID.randomUUID().toString())
            .representativeFirstName(UUID.randomUUID().toString())
            .jobTitle(UUID.randomUUID().toString())
            .streetAddress(UUID.randomUUID().toString())
            .houseNumber(UUID.randomUUID().toString())
            .locationName(UUID.randomUUID().toString())
            .city(UUID.randomUUID().toString())
            .stateProvince(UUID.randomUUID().toString())
            .zipPostalCode(UUID.randomUUID().toString())
            .countryRegion(UUID.randomUUID().toString())
            .mainEmail(UUID.randomUUID().toString())
            .landPhoneNumber(UUID.randomUUID().toString())
            .mobilePhoneNumber(UUID.randomUUID().toString())
            .faxNumber(UUID.randomUUID().toString());
    }
}
