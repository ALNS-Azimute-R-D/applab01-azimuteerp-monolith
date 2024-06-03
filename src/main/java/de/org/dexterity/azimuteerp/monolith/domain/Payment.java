package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.org.dexterity.azimuteerp.monolith.domain.enumeration.PaymentStatusEnum;
import de.org.dexterity.azimuteerp.monolith.domain.enumeration.PaymentTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Payment.
 */
@Entity
@Table(name = "tb_payment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "installment_number", nullable = false)
    private Integer installmentNumber;

    @NotNull
    @Column(name = "payment_due_date", nullable = false)
    private Instant paymentDueDate;

    @NotNull
    @Column(name = "payment_paid_date", nullable = false)
    private Instant paymentPaidDate;

    @NotNull
    @Column(name = "payment_amount", precision = 21, scale = 2, nullable = false)
    private BigDecimal paymentAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_payment", nullable = false)
    private PaymentTypeEnum typeOfPayment;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatusEnum status;

    @Lob
    @Column(name = "extra_details")
    private String extraDetails;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "invoicesAsPreferrableLists", "paymentsLists" }, allowSetters = true)
    private PaymentMethod paymentMethod;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Payment id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInstallmentNumber() {
        return this.installmentNumber;
    }

    public Payment installmentNumber(Integer installmentNumber) {
        this.setInstallmentNumber(installmentNumber);
        return this;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public Instant getPaymentDueDate() {
        return this.paymentDueDate;
    }

    public Payment paymentDueDate(Instant paymentDueDate) {
        this.setPaymentDueDate(paymentDueDate);
        return this;
    }

    public void setPaymentDueDate(Instant paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Instant getPaymentPaidDate() {
        return this.paymentPaidDate;
    }

    public Payment paymentPaidDate(Instant paymentPaidDate) {
        this.setPaymentPaidDate(paymentPaidDate);
        return this;
    }

    public void setPaymentPaidDate(Instant paymentPaidDate) {
        this.paymentPaidDate = paymentPaidDate;
    }

    public BigDecimal getPaymentAmount() {
        return this.paymentAmount;
    }

    public Payment paymentAmount(BigDecimal paymentAmount) {
        this.setPaymentAmount(paymentAmount);
        return this;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentTypeEnum getTypeOfPayment() {
        return this.typeOfPayment;
    }

    public Payment typeOfPayment(PaymentTypeEnum typeOfPayment) {
        this.setTypeOfPayment(typeOfPayment);
        return this;
    }

    public void setTypeOfPayment(PaymentTypeEnum typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    public PaymentStatusEnum getStatus() {
        return this.status;
    }

    public Payment status(PaymentStatusEnum status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }

    public String getExtraDetails() {
        return this.extraDetails;
    }

    public Payment extraDetails(String extraDetails) {
        this.setExtraDetails(extraDetails);
        return this;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Payment paymentMethod(PaymentMethod paymentMethod) {
        this.setPaymentMethod(paymentMethod);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Payment)) {
            return false;
        }
        return getId() != null && getId().equals(((Payment) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Payment{" +
            "id=" + getId() +
            ", installmentNumber=" + getInstallmentNumber() +
            ", paymentDueDate='" + getPaymentDueDate() + "'" +
            ", paymentPaidDate='" + getPaymentPaidDate() + "'" +
            ", paymentAmount=" + getPaymentAmount() +
            ", typeOfPayment='" + getTypeOfPayment() + "'" +
            ", status='" + getStatus() + "'" +
            ", extraDetails='" + getExtraDetails() + "'" +
            "}";
    }
}
