package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.org.dexterity.azimuteerp.monolith.domain.enumeration.OrderStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Order.
 */
@Entity
@Table(name = "jhi_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "business_code", length = 20, nullable = false)
    private String businessCode;

    @NotNull
    @Column(name = "customer_user_id", nullable = false)
    private String customerUserId;

    @NotNull
    @Column(name = "placed_date", nullable = false)
    private Instant placedDate;

    @Column(name = "total_tax_value", precision = 21, scale = 2)
    private BigDecimal totalTaxValue;

    @Column(name = "total_due_value", precision = 21, scale = 2)
    private BigDecimal totalDueValue;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatusEnum status;

    @Column(name = "invoice_id")
    private Long invoiceId;

    @Column(name = "estimated_delivery_date")
    private Instant estimatedDeliveryDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "article", "order" }, allowSetters = true)
    private Set<OrderItem> ordersItemsLists = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Order id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessCode() {
        return this.businessCode;
    }

    public Order businessCode(String businessCode) {
        this.setBusinessCode(businessCode);
        return this;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getCustomerUserId() {
        return this.customerUserId;
    }

    public Order customerUserId(String customerUserId) {
        this.setCustomerUserId(customerUserId);
        return this;
    }

    public void setCustomerUserId(String customerUserId) {
        this.customerUserId = customerUserId;
    }

    public Instant getPlacedDate() {
        return this.placedDate;
    }

    public Order placedDate(Instant placedDate) {
        this.setPlacedDate(placedDate);
        return this;
    }

    public void setPlacedDate(Instant placedDate) {
        this.placedDate = placedDate;
    }

    public BigDecimal getTotalTaxValue() {
        return this.totalTaxValue;
    }

    public Order totalTaxValue(BigDecimal totalTaxValue) {
        this.setTotalTaxValue(totalTaxValue);
        return this;
    }

    public void setTotalTaxValue(BigDecimal totalTaxValue) {
        this.totalTaxValue = totalTaxValue;
    }

    public BigDecimal getTotalDueValue() {
        return this.totalDueValue;
    }

    public Order totalDueValue(BigDecimal totalDueValue) {
        this.setTotalDueValue(totalDueValue);
        return this;
    }

    public void setTotalDueValue(BigDecimal totalDueValue) {
        this.totalDueValue = totalDueValue;
    }

    public OrderStatusEnum getStatus() {
        return this.status;
    }

    public Order status(OrderStatusEnum status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public Long getInvoiceId() {
        return this.invoiceId;
    }

    public Order invoiceId(Long invoiceId) {
        this.setInvoiceId(invoiceId);
        return this;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Instant getEstimatedDeliveryDate() {
        return this.estimatedDeliveryDate;
    }

    public Order estimatedDeliveryDate(Instant estimatedDeliveryDate) {
        this.setEstimatedDeliveryDate(estimatedDeliveryDate);
        return this;
    }

    public void setEstimatedDeliveryDate(Instant estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Set<OrderItem> getOrdersItemsLists() {
        return this.ordersItemsLists;
    }

    public void setOrdersItemsLists(Set<OrderItem> orderItems) {
        if (this.ordersItemsLists != null) {
            this.ordersItemsLists.forEach(i -> i.setOrder(null));
        }
        if (orderItems != null) {
            orderItems.forEach(i -> i.setOrder(this));
        }
        this.ordersItemsLists = orderItems;
    }

    public Order ordersItemsLists(Set<OrderItem> orderItems) {
        this.setOrdersItemsLists(orderItems);
        return this;
    }

    public Order addOrdersItemsList(OrderItem orderItem) {
        this.ordersItemsLists.add(orderItem);
        orderItem.setOrder(this);
        return this;
    }

    public Order removeOrdersItemsList(OrderItem orderItem) {
        this.ordersItemsLists.remove(orderItem);
        orderItem.setOrder(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        return getId() != null && getId().equals(((Order) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Order{" +
            "id=" + getId() +
            ", businessCode='" + getBusinessCode() + "'" +
            ", customerUserId='" + getCustomerUserId() + "'" +
            ", placedDate='" + getPlacedDate() + "'" +
            ", totalTaxValue=" + getTotalTaxValue() +
            ", totalDueValue=" + getTotalDueValue() +
            ", status='" + getStatus() + "'" +
            ", invoiceId=" + getInvoiceId() +
            ", estimatedDeliveryDate='" + getEstimatedDeliveryDate() + "'" +
            "}";
    }
}
