package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.BrandAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.BrandTestSamples.*;

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
