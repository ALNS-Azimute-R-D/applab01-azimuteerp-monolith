package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.org.dexterity.azimuteerp.monolith.domain.enumeration.InvoiceStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * - Invoice
 * - PaymentMethod
 * - Payment
 */
@Entity
@Table(name = "tb_invoice")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "business_code", length = 15, nullable = false)
    private String businessCode;

    @Column(name = "original_order_id")
    private Long originalOrderId;

    @Column(name = "invoice_date")
    private Instant invoiceDate;

    @Column(name = "due_date")
    private Instant dueDate;

    @NotNull
    @Size(max = 80)
    @Column(name = "description", length = 80, nullable = false)
    private String description;

    @Column(name = "tax_value", precision = 21, scale = 2)
    private BigDecimal taxValue;

    @Column(name = "shipping_value", precision = 21, scale = 2)
    private BigDecimal shippingValue;

    @Column(name = "amount_due_value", precision = 21, scale = 2)
    private BigDecimal amountDueValue;

    @NotNull
    @Column(name = "number_of_installments_original", nullable = false)
    private Integer numberOfInstallmentsOriginal;

    @Column(name = "number_of_installments_paid")
    private Integer numberOfInstallmentsPaid;

    @Column(name = "amount_paid_value", precision = 21, scale = 2)
    private BigDecimal amountPaidValue;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private InvoiceStatusEnum status;

    @Lob
    @Column(name = "extra_details")
    private String extraDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "invoicesAsPreferrableLists", "paymentsLists" }, allowSetters = true)
    private PaymentMethod preferrablePaymentMethod;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Invoice id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessCode() {
        return this.businessCode;
    }

    public Invoice businessCode(String businessCode) {
        this.setBusinessCode(businessCode);
        return this;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public Long getOriginalOrderId() {
        return this.originalOrderId;
    }

    public Invoice originalOrderId(Long originalOrderId) {
        this.setOriginalOrderId(originalOrderId);
        return this;
    }

    public void setOriginalOrderId(Long originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    public Instant getInvoiceDate() {
        return this.invoiceDate;
    }

    public Invoice invoiceDate(Instant invoiceDate) {
        this.setInvoiceDate(invoiceDate);
        return this;
    }

    public void setInvoiceDate(Instant invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Instant getDueDate() {
        return this.dueDate;
    }

    public Invoice dueDate(Instant dueDate) {
        this.setDueDate(dueDate);
        return this;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return this.description;
    }

    public Invoice description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTaxValue() {
        return this.taxValue;
    }

    public Invoice taxValue(BigDecimal taxValue) {
        this.setTaxValue(taxValue);
        return this;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    public BigDecimal getShippingValue() {
        return this.shippingValue;
    }

    public Invoice shippingValue(BigDecimal shippingValue) {
        this.setShippingValue(shippingValue);
        return this;
    }

    public void setShippingValue(BigDecimal shippingValue) {
        this.shippingValue = shippingValue;
    }

    public BigDecimal getAmountDueValue() {
        return this.amountDueValue;
    }

    public Invoice amountDueValue(BigDecimal amountDueValue) {
        this.setAmountDueValue(amountDueValue);
        return this;
    }

    public void setAmountDueValue(BigDecimal amountDueValue) {
        this.amountDueValue = amountDueValue;
    }

    public Integer getNumberOfInstallmentsOriginal() {
        return this.numberOfInstallmentsOriginal;
    }

    public Invoice numberOfInstallmentsOriginal(Integer numberOfInstallmentsOriginal) {
        this.setNumberOfInstallmentsOriginal(numberOfInstallmentsOriginal);
        return this;
    }

    public void setNumberOfInstallmentsOriginal(Integer numberOfInstallmentsOriginal) {
        this.numberOfInstallmentsOriginal = numberOfInstallmentsOriginal;
    }

    public Integer getNumberOfInstallmentsPaid() {
        return this.numberOfInstallmentsPaid;
    }

    public Invoice numberOfInstallmentsPaid(Integer numberOfInstallmentsPaid) {
        this.setNumberOfInstallmentsPaid(numberOfInstallmentsPaid);
        return this;
    }

    public void setNumberOfInstallmentsPaid(Integer numberOfInstallmentsPaid) {
        this.numberOfInstallmentsPaid = numberOfInstallmentsPaid;
    }

    public BigDecimal getAmountPaidValue() {
        return this.amountPaidValue;
    }

    public Invoice amountPaidValue(BigDecimal amountPaidValue) {
        this.setAmountPaidValue(amountPaidValue);
        return this;
    }

    public void setAmountPaidValue(BigDecimal amountPaidValue) {
        this.amountPaidValue = amountPaidValue;
    }

    public InvoiceStatusEnum getStatus() {
        return this.status;
    }

    public Invoice status(InvoiceStatusEnum status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(InvoiceStatusEnum status) {
        this.status = status;
    }

    public String getExtraDetails() {
        return this.extraDetails;
    }

    public Invoice extraDetails(String extraDetails) {
        this.setExtraDetails(extraDetails);
        return this;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public PaymentMethod getPreferrablePaymentMethod() {
        return this.preferrablePaymentMethod;
    }

    public void setPreferrablePaymentMethod(PaymentMethod paymentMethod) {
        this.preferrablePaymentMethod = paymentMethod;
    }

    public Invoice preferrablePaymentMethod(PaymentMethod paymentMethod) {
        this.setPreferrablePaymentMethod(paymentMethod);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Invoice)) {
            return false;
        }
        return getId() != null && getId().equals(((Invoice) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Invoice{" +
            "id=" + getId() +
            ", businessCode='" + getBusinessCode() + "'" +
            ", originalOrderId=" + getOriginalOrderId() +
            ", invoiceDate='" + getInvoiceDate() + "'" +
            ", dueDate='" + getDueDate() + "'" +
            ", description='" + getDescription() + "'" +
            ", taxValue=" + getTaxValue() +
            ", shippingValue=" + getShippingValue() +
            ", amountDueValue=" + getAmountDueValue() +
            ", numberOfInstallmentsOriginal=" + getNumberOfInstallmentsOriginal() +
            ", numberOfInstallmentsPaid=" + getNumberOfInstallmentsPaid() +
            ", amountPaidValue=" + getAmountPaidValue() +
            ", status='" + getStatus() + "'" +
            ", extraDetails='" + getExtraDetails() + "'" +
            "}";
    }
}
