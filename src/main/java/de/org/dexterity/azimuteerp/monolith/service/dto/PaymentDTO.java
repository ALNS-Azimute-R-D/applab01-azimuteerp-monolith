package de.org.dexterity.azimuteerp.monolith.service.dto;

import de.org.dexterity.azimuteerp.monolith.domain.enumeration.PaymentStatusEnum;
import de.org.dexterity.azimuteerp.monolith.domain.enumeration.PaymentTypeEnum;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.Payment} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer installmentNumber;

    @NotNull
    private Instant paymentDueDate;

    @NotNull
    private Instant paymentPaidDate;

    @NotNull
    private BigDecimal paymentAmount;

    @NotNull
    private PaymentTypeEnum typeOfPayment;

    @NotNull
    private PaymentStatusEnum status;

    @Lob
    private String extraDetails;

    @NotNull
    private PaymentMethodDTO paymentMethod;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(Integer installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public Instant getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Instant paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Instant getPaymentPaidDate() {
        return paymentPaidDate;
    }

    public void setPaymentPaidDate(Instant paymentPaidDate) {
        this.paymentPaidDate = paymentPaidDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public PaymentTypeEnum getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(PaymentTypeEnum typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentDTO)) {
            return false;
        }

        PaymentDTO paymentDTO = (PaymentDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paymentDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentDTO{" +
            "id=" + getId() +
            ", installmentNumber=" + getInstallmentNumber() +
            ", paymentDueDate='" + getPaymentDueDate() + "'" +
            ", paymentPaidDate='" + getPaymentPaidDate() + "'" +
            ", paymentAmount=" + getPaymentAmount() +
            ", typeOfPayment='" + getTypeOfPayment() + "'" +
            ", status='" + getStatus() + "'" +
            ", extraDetails='" + getExtraDetails() + "'" +
            ", paymentMethod=" + getPaymentMethod() +
            "}";
    }
}
