package de.org.dexterity.azimuteerp.monolith.service.dto;

import de.org.dexterity.azimuteerp.monolith.domain.enumeration.InvoiceStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.Invoice} entity.
 */
@Schema(description = "- Invoice\n- PaymentMethod\n- Payment")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InvoiceDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 15)
    private String businessCode;

    private Long originalOrderId;

    private Instant invoiceDate;

    private Instant dueDate;

    @NotNull
    @Size(max = 80)
    private String description;

    private BigDecimal taxValue;

    private BigDecimal shippingValue;

    private BigDecimal amountDueValue;

    @NotNull
    private Integer numberOfInstallmentsOriginal;

    private Integer numberOfInstallmentsPaid;

    private BigDecimal amountPaidValue;

    @NotNull
    private InvoiceStatusEnum status;

    @Lob
    private String extraDetails;

    private PaymentMethodDTO preferrablePaymentMethod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public Long getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(Long originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    public Instant getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Instant invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    public BigDecimal getShippingValue() {
        return shippingValue;
    }

    public void setShippingValue(BigDecimal shippingValue) {
        this.shippingValue = shippingValue;
    }

    public BigDecimal getAmountDueValue() {
        return amountDueValue;
    }

    public void setAmountDueValue(BigDecimal amountDueValue) {
        this.amountDueValue = amountDueValue;
    }

    public Integer getNumberOfInstallmentsOriginal() {
        return numberOfInstallmentsOriginal;
    }

    public void setNumberOfInstallmentsOriginal(Integer numberOfInstallmentsOriginal) {
        this.numberOfInstallmentsOriginal = numberOfInstallmentsOriginal;
    }

    public Integer getNumberOfInstallmentsPaid() {
        return numberOfInstallmentsPaid;
    }

    public void setNumberOfInstallmentsPaid(Integer numberOfInstallmentsPaid) {
        this.numberOfInstallmentsPaid = numberOfInstallmentsPaid;
    }

    public BigDecimal getAmountPaidValue() {
        return amountPaidValue;
    }

    public void setAmountPaidValue(BigDecimal amountPaidValue) {
        this.amountPaidValue = amountPaidValue;
    }

    public InvoiceStatusEnum getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatusEnum status) {
        this.status = status;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public PaymentMethodDTO getPreferrablePaymentMethod() {
        return preferrablePaymentMethod;
    }

    public void setPreferrablePaymentMethod(PaymentMethodDTO preferrablePaymentMethod) {
        this.preferrablePaymentMethod = preferrablePaymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InvoiceDTO)) {
            return false;
        }

        InvoiceDTO invoiceDTO = (InvoiceDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, invoiceDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InvoiceDTO{" +
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
            ", preferrablePaymentMethod=" + getPreferrablePaymentMethod() +
            "}";
    }
}
