package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.PaymentMethodAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.PaymentMethodTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentMethodMapperTest {

    private PaymentMethodMapper paymentMethodMapper;

    @BeforeEach
    void setUp() {
        paymentMethodMapper = new PaymentMethodMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentMethodSample1();
        var actual = paymentMethodMapper.toEntity(paymentMethodMapper.toDto(expected));
        assertPaymentMethodAllPropertiesEquals(expected, actual);
    }
}
