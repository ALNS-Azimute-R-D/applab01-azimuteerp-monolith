package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A PaymentMethod.
 */
@Entity
@Table(name = "tb_payment_method")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentMethod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "code", length = 10, nullable = false)
    private String code;

    @NotNull
    @Size(max = 40)
    @Column(name = "description", length = 40, nullable = false)
    private String description;

    @Size(max = 512)
    @Column(name = "business_handler_clazz", length = 512)
    private String businessHandlerClazz;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "preferrablePaymentMethod")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "preferrablePaymentMethod" }, allowSetters = true)
    private Set<Invoice> invoicesAsPreferrableLists = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMethod")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "paymentMethod" }, allowSetters = true)
    private Set<Payment> paymentsLists = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public PaymentMethod id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public PaymentMethod code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public PaymentMethod description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusinessHandlerClazz() {
        return this.businessHandlerClazz;
    }

    public PaymentMethod businessHandlerClazz(String businessHandlerClazz) {
        this.setBusinessHandlerClazz(businessHandlerClazz);
        return this;
    }

    public void setBusinessHandlerClazz(String businessHandlerClazz) {
        this.businessHandlerClazz = businessHandlerClazz;
    }

    public Set<Invoice> getInvoicesAsPreferrableLists() {
        return this.invoicesAsPreferrableLists;
    }

    public void setInvoicesAsPreferrableLists(Set<Invoice> invoices) {
        if (this.invoicesAsPreferrableLists != null) {
            this.invoicesAsPreferrableLists.forEach(i -> i.setPreferrablePaymentMethod(null));
        }
        if (invoices != null) {
            invoices.forEach(i -> i.setPreferrablePaymentMethod(this));
        }
        this.invoicesAsPreferrableLists = invoices;
    }

    public PaymentMethod invoicesAsPreferrableLists(Set<Invoice> invoices) {
        this.setInvoicesAsPreferrableLists(invoices);
        return this;
    }

    public PaymentMethod addInvoicesAsPreferrableList(Invoice invoice) {
        this.invoicesAsPreferrableLists.add(invoice);
        invoice.setPreferrablePaymentMethod(this);
        return this;
    }

    public PaymentMethod removeInvoicesAsPreferrableList(Invoice invoice) {
        this.invoicesAsPreferrableLists.remove(invoice);
        invoice.setPreferrablePaymentMethod(null);
        return this;
    }

    public Set<Payment> getPaymentsLists() {
        return this.paymentsLists;
    }

    public void setPaymentsLists(Set<Payment> payments) {
        if (this.paymentsLists != null) {
            this.paymentsLists.forEach(i -> i.setPaymentMethod(null));
        }
        if (payments != null) {
            payments.forEach(i -> i.setPaymentMethod(this));
        }
        this.paymentsLists = payments;
    }

    public PaymentMethod paymentsLists(Set<Payment> payments) {
        this.setPaymentsLists(payments);
        return this;
    }

    public PaymentMethod addPaymentsList(Payment payment) {
        this.paymentsLists.add(payment);
        payment.setPaymentMethod(this);
        return this;
    }

    public PaymentMethod removePaymentsList(Payment payment) {
        this.paymentsLists.remove(payment);
        payment.setPaymentMethod(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentMethod)) {
            return false;
        }
        return getId() != null && getId().equals(((PaymentMethod) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentMethod{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", businessHandlerClazz='" + getBusinessHandlerClazz() + "'" +
            "}";
    }
}
