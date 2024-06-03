package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.AssetTypeAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.AssetTypeTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssetTypeMapperTest {

    private AssetTypeMapper assetTypeMapper;

    @BeforeEach
    void setUp() {
        assetTypeMapper = new AssetTypeMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getAssetTypeSample1();
        var actual = assetTypeMapper.toEntity(assetTypeMapper.toDto(expected));
        assertAssetTypeAllPropertiesEquals(expected, actual);
    }
}
