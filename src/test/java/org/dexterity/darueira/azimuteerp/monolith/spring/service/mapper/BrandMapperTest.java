package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.BrandAsserts.*;
import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.BrandTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BrandMapperTest {

    private BrandMapper brandMapper;

    @BeforeEach
    void setUp() {
        brandMapper = new BrandMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getBrandSample1();
        var actual = brandMapper.toEntity(brandMapper.toDto(expected));
        assertBrandAllPropertiesEquals(expected, actual);
    }
}
