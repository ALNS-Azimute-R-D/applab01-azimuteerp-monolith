package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.ArticleTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrderItemTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrderTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class OrderItemTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(OrderItem.class);
        OrderItem orderItem1 = getOrderItemSample1();
        OrderItem orderItem2 = new OrderItem();
        assertThat(orderItem1).isNotEqualTo(orderItem2);

        orderItem2.setId(orderItem1.getId());
        assertThat(orderItem1).isEqualTo(orderItem2);

        orderItem2 = getOrderItemSample2();
        assertThat(orderItem1).isNotEqualTo(orderItem2);
    }

    @Test
    void articleTest() {
        OrderItem orderItem = getOrderItemRandomSampleGenerator();
        Article articleBack = getArticleRandomSampleGenerator();

        orderItem.setArticle(articleBack);
        assertThat(orderItem.getArticle()).isEqualTo(articleBack);

        orderItem.article(null);
        assertThat(orderItem.getArticle()).isNull();
    }

    @Test
    void orderTest() {
        OrderItem orderItem = getOrderItemRandomSampleGenerator();
        Order orderBack = getOrderRandomSampleGenerator();

        orderItem.setOrder(orderBack);
        assertThat(orderItem.getOrder()).isEqualTo(orderBack);

        orderItem.order(null);
        assertThat(orderItem.getOrder()).isNull();
    }
}