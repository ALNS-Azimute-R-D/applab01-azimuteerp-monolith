package de.org.dexterity.azimuteerp.monolith.service.dto;

import de.org.dexterity.azimuteerp.monolith.domain.enumeration.ActivationStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.Tenant} entity.
 */
@Schema(description = "- Tenant\n- TypeOfOrganization\n- Organization\n- BusinessUnit")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TenantDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String acronym;

    @NotNull
    @Size(max = 128)
    private String name;

    @NotNull
    @Size(max = 255)
    private String description;

    @NotNull
    @Size(max = 15)
    private String customerBusinessCode;

    @Size(max = 512)
    private String businessHandlerClazz;

    @Lob
    private String mainContactPersonDetails;

    @Lob
    private String billingDetails;

    @Lob
    private String technicalEnvironmentsDetails;

    @Lob
    private String commonCustomAttributesDetails;

    @Lob
    private byte[] logoImg;

    private String logoImgContentType;

    @NotNull
    private ActivationStatusEnum activationStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerBusinessCode() {
        return customerBusinessCode;
    }

    public void setCustomerBusinessCode(String customerBusinessCode) {
        this.customerBusinessCode = customerBusinessCode;
    }

    public String getBusinessHandlerClazz() {
        return businessHandlerClazz;
    }

    public void setBusinessHandlerClazz(String businessHandlerClazz) {
        this.businessHandlerClazz = businessHandlerClazz;
    }

    public String getMainContactPersonDetails() {
        return mainContactPersonDetails;
    }

    public void setMainContactPersonDetails(String mainContactPersonDetails) {
        this.mainContactPersonDetails = mainContactPersonDetails;
    }

    public String getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(String billingDetails) {
        this.billingDetails = billingDetails;
    }

    public String getTechnicalEnvironmentsDetails() {
        return technicalEnvironmentsDetails;
    }

    public void setTechnicalEnvironmentsDetails(String technicalEnvironmentsDetails) {
        this.technicalEnvironmentsDetails = technicalEnvironmentsDetails;
    }

    public String getCommonCustomAttributesDetails() {
        return commonCustomAttributesDetails;
    }

    public void setCommonCustomAttributesDetails(String commonCustomAttributesDetails) {
        this.commonCustomAttributesDetails = commonCustomAttributesDetails;
    }

    public byte[] getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(byte[] logoImg) {
        this.logoImg = logoImg;
    }

    public String getLogoImgContentType() {
        return logoImgContentType;
    }

    public void setLogoImgContentType(String logoImgContentType) {
        this.logoImgContentType = logoImgContentType;
    }

    public ActivationStatusEnum getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(ActivationStatusEnum activationStatus) {
        this.activationStatus = activationStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TenantDTO)) {
            return false;
        }

        TenantDTO tenantDTO = (TenantDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tenantDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TenantDTO{" +
            "id=" + getId() +
            ", acronym='" + getAcronym() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", customerBusinessCode='" + getCustomerBusinessCode() + "'" +
            ", businessHandlerClazz='" + getBusinessHandlerClazz() + "'" +
            ", mainContactPersonDetails='" + getMainContactPersonDetails() + "'" +
            ", billingDetails='" + getBillingDetails() + "'" +
            ", technicalEnvironmentsDetails='" + getTechnicalEnvironmentsDetails() + "'" +
            ", commonCustomAttributesDetails='" + getCommonCustomAttributesDetails() + "'" +
            ", logoImg='" + getLogoImg() + "'" +
            ", activationStatus='" + getActivationStatus() + "'" +
            "}";
    }
}
