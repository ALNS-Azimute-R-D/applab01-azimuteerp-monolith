package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.ArticleAsserts.*;
import static org.dexterity.darueira.azimuteerp.monolith.spring.domain.ArticleTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArticleMapperTest {

    private ArticleMapper articleMapper;

    @BeforeEach
    void setUp() {
        articleMapper = new ArticleMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getArticleSample1();
        var actual = articleMapper.toEntity(articleMapper.toDto(expected));
        assertArticleAllPropertiesEquals(expected, actual);
    }
}
