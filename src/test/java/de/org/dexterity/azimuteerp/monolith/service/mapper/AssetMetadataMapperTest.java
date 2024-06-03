package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.AssetMetadataAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.AssetMetadataTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssetMetadataMapperTest {

    private AssetMetadataMapper assetMetadataMapper;

    @BeforeEach
    void setUp() {
        assetMetadataMapper = new AssetMetadataMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getAssetMetadataSample1();
        var actual = assetMetadataMapper.toEntity(assetMetadataMapper.toDto(expected));
        assertAssetMetadataAllPropertiesEquals(expected, actual);
    }
}
