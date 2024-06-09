package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.RawAssetProcTmpAsserts.*;
import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.RawAssetProcTmpTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RawAssetProcTmpMapperTest {

    private RawAssetProcTmpMapper rawAssetProcTmpMapper;

    @BeforeEach
    void setUp() {
        rawAssetProcTmpMapper = new RawAssetProcTmpMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getRawAssetProcTmpSample1();
        var actual = rawAssetProcTmpMapper.toEntity(rawAssetProcTmpMapper.toDto(expected));
        assertRawAssetProcTmpAllPropertiesEquals(expected, actual);
    }
}
