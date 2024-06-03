package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.PaymentAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.PaymentTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentMapperTest {

    private PaymentMapper paymentMapper;

    @BeforeEach
    void setUp() {
        paymentMapper = new PaymentMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentSample1();
        var actual = paymentMapper.toEntity(paymentMapper.toDto(expected));
        assertPaymentAllPropertiesEquals(expected, actual);
    }
}
