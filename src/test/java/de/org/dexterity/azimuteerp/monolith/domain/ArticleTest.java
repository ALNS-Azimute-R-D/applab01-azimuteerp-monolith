package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.ArticleTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.CategoryTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrderItemTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ArticleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Article.class);
        Article article1 = getArticleSample1();
        Article article2 = new Article();
        assertThat(article1).isNotEqualTo(article2);

        article2.setId(article1.getId());
        assertThat(article1).isEqualTo(article2);

        article2 = getArticleSample2();
        assertThat(article1).isNotEqualTo(article2);
    }

    @Test
    void mainCategoryTest() {
        Article article = getArticleRandomSampleGenerator();
        Category categoryBack = getCategoryRandomSampleGenerator();

        article.setMainCategory(categoryBack);
        assertThat(article.getMainCategory()).isEqualTo(categoryBack);

        article.mainCategory(null);
        assertThat(article.getMainCategory()).isNull();
    }

    @Test
    void ordersItemsListTest() {
        Article article = getArticleRandomSampleGenerator();
        OrderItem orderItemBack = getOrderItemRandomSampleGenerator();

        article.addOrdersItemsList(orderItemBack);
        assertThat(article.getOrdersItemsLists()).containsOnly(orderItemBack);
        assertThat(orderItemBack.getArticle()).isEqualTo(article);

        article.removeOrdersItemsList(orderItemBack);
        assertThat(article.getOrdersItemsLists()).doesNotContain(orderItemBack);
        assertThat(orderItemBack.getArticle()).isNull();

        article.ordersItemsLists(new HashSet<>(Set.of(orderItemBack)));
        assertThat(article.getOrdersItemsLists()).containsOnly(orderItemBack);
        assertThat(orderItemBack.getArticle()).isEqualTo(article);

        article.setOrdersItemsLists(new HashSet<>());
        assertThat(article.getOrdersItemsLists()).doesNotContain(orderItemBack);
        assertThat(orderItemBack.getArticle()).isNull();
    }
}
