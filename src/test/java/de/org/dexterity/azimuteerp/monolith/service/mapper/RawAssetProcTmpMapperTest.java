package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmpAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmpTestSamples.*;

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
