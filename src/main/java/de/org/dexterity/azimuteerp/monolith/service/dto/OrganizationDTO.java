package de.org.dexterity.azimuteerp.monolith.service.dto;

import de.org.dexterity.azimuteerp.monolith.domain.enumeration.ActivationStatusEnum;
import de.org.dexterity.azimuteerp.monolith.domain.enumeration.OrganizationStatusEnum;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.Organization} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OrganizationDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String acronym;

    @NotNull
    @Size(max = 15)
    private String businessCode;

    @Size(max = 30)
    private String hierarchicalLevel;

    @NotNull
    @Size(min = 2, max = 255)
    private String name;

    @NotNull
    @Size(max = 512)
    private String description;

    @Size(max = 512)
    private String businessHandlerClazz;

    @Lob
    private String mainContactPersonDetails;

    @Lob
    private String technicalEnvironmentsDetails;

    @Lob
    private String commonCustomAttributesDetails;

    @NotNull
    private OrganizationStatusEnum organizationStatus;

    @NotNull
    private ActivationStatusEnum activationStatus;

    @Lob
    private byte[] logoImg;

    private String logoImgContentType;

    @NotNull
    private TenantDTO tenant;

    @NotNull
    private TypeOfOrganizationDTO typeOfOrganization;

    private OrganizationDTO organizationParent;

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

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getHierarchicalLevel() {
        return hierarchicalLevel;
    }

    public void setHierarchicalLevel(String hierarchicalLevel) {
        this.hierarchicalLevel = hierarchicalLevel;
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

    public OrganizationStatusEnum getOrganizationStatus() {
        return organizationStatus;
    }

    public void setOrganizationStatus(OrganizationStatusEnum organizationStatus) {
        this.organizationStatus = organizationStatus;
    }

    public ActivationStatusEnum getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(ActivationStatusEnum activationStatus) {
        this.activationStatus = activationStatus;
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

    public TenantDTO getTenant() {
        return tenant;
    }

    public void setTenant(TenantDTO tenant) {
        this.tenant = tenant;
    }

    public TypeOfOrganizationDTO getTypeOfOrganization() {
        return typeOfOrganization;
    }

    public void setTypeOfOrganization(TypeOfOrganizationDTO typeOfOrganization) {
        this.typeOfOrganization = typeOfOrganization;
    }

    public OrganizationDTO getOrganizationParent() {
        return organizationParent;
    }

    public void setOrganizationParent(OrganizationDTO organizationParent) {
        this.organizationParent = organizationParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrganizationDTO)) {
            return false;
        }

        OrganizationDTO organizationDTO = (OrganizationDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, organizationDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrganizationDTO{" +
            "id=" + getId() +
            ", acronym='" + getAcronym() + "'" +
            ", businessCode='" + getBusinessCode() + "'" +
            ", hierarchicalLevel='" + getHierarchicalLevel() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", businessHandlerClazz='" + getBusinessHandlerClazz() + "'" +
            ", mainContactPersonDetails='" + getMainContactPersonDetails() + "'" +
            ", technicalEnvironmentsDetails='" + getTechnicalEnvironmentsDetails() + "'" +
            ", commonCustomAttributesDetails='" + getCommonCustomAttributesDetails() + "'" +
            ", organizationStatus='" + getOrganizationStatus() + "'" +
            ", activationStatus='" + getActivationStatus() + "'" +
            ", logoImg='" + getLogoImg() + "'" +
            ", tenant=" + getTenant() +
            ", typeOfOrganization=" + getTypeOfOrganization() +
            ", organizationParent=" + getOrganizationParent() +
            "}";
    }
}
