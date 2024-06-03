package de.org.dexterity.azimuteerp.monolith.domain;

import static de.org.dexterity.azimuteerp.monolith.domain.OrderItemTestSamples.*;
import static de.org.dexterity.azimuteerp.monolith.domain.OrderTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Order.class);
        Order order1 = getOrderSample1();
        Order order2 = new Order();
        assertThat(order1).isNotEqualTo(order2);

        order2.setId(order1.getId());
        assertThat(order1).isEqualTo(order2);

        order2 = getOrderSample2();
        assertThat(order1).isNotEqualTo(order2);
    }

    @Test
    void ordersItemsListTest() {
        Order order = getOrderRandomSampleGenerator();
        OrderItem orderItemBack = getOrderItemRandomSampleGenerator();

        order.addOrdersItemsList(orderItemBack);
        assertThat(order.getOrdersItemsLists()).containsOnly(orderItemBack);
        assertThat(orderItemBack.getOrder()).isEqualTo(order);

        order.removeOrdersItemsList(orderItemBack);
        assertThat(order.getOrdersItemsLists()).doesNotContain(orderItemBack);
        assertThat(orderItemBack.getOrder()).isNull();

        order.ordersItemsLists(new HashSet<>(Set.of(orderItemBack)));
        assertThat(order.getOrdersItemsLists()).containsOnly(orderItemBack);
        assertThat(orderItemBack.getOrder()).isEqualTo(order);

        order.setOrdersItemsLists(new HashSet<>());
        assertThat(order.getOrdersItemsLists()).doesNotContain(orderItemBack);
        assertThat(orderItemBack.getOrder()).isNull();
    }
}
