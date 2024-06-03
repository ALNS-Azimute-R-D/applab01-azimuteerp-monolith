package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.SupplierAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.SupplierTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupplierMapperTest {

    private SupplierMapper supplierMapper;

    @BeforeEach
    void setUp() {
        supplierMapper = new SupplierMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSupplierSample1();
        var actual = supplierMapper.toEntity(supplierMapper.toDto(expected));
        assertSupplierAllPropertiesEquals(expected, actual);
    }
}
