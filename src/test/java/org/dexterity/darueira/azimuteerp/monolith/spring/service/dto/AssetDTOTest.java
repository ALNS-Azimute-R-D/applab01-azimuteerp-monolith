package org.dexterity.darueira.azimuteerp.monolith.spring.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import org.dexterity.darueira.azimuteerp.monolith.spring.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AssetDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AssetDTO.class);
        AssetDTO assetDTO1 = new AssetDTO();
        assetDTO1.setId(UUID.randomUUID());
        AssetDTO assetDTO2 = new AssetDTO();
        assertThat(assetDTO1).isNotEqualTo(assetDTO2);
        assetDTO2.setId(assetDTO1.getId());
        assertThat(assetDTO1).isEqualTo(assetDTO2);
        assetDTO2.setId(UUID.randomUUID());
        assertThat(assetDTO1).isNotEqualTo(assetDTO2);
        assetDTO1.setId(null);
        assertThat(assetDTO1).isNotEqualTo(assetDTO2);
    }
}
