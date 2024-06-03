package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.org.dexterity.azimuteerp.monolith.domain.enumeration.ActivationStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * - Tenant
 * - TypeOfOrganization
 * - Organization
 * - BusinessUnit
 */
@Entity
@Table(name = "tb_tenant")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Tenant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "acronym", length = 20, nullable = false)
    private String acronym;

    @NotNull
    @Size(max = 128)
    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @NotNull
    @Size(max = 255)
    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @NotNull
    @Size(max = 15)
    @Column(name = "customer_business_code", length = 15, nullable = false)
    private String customerBusinessCode;

    @Size(max = 512)
    @Column(name = "business_handler_clazz", length = 512)
    private String businessHandlerClazz;

    @Lob
    @Column(name = "main_contact_person_details")
    private String mainContactPersonDetails;

    @Lob
    @Column(name = "billing_details")
    private String billingDetails;

    @Lob
    @Column(name = "technical_environments_details")
    private String technicalEnvironmentsDetails;

    @Lob
    @Column(name = "common_custom_attributes_details")
    private String commonCustomAttributesDetails;

    @Lob
    @Column(name = "logo_img")
    private byte[] logoImg;

    @Column(name = "logo_img_content_type")
    private String logoImgContentType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "activation_status", nullable = false)
    private ActivationStatusEnum activationStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tenant")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(
        value = {
            "tenant",
            "typeOfOrganization",
            "organizationParent",
            "organizationDomainsLists",
            "organizationAttributesLists",
            "businessUnitsLists",
            "childrenOrganizationsLists",
            "organizationRolesLists",
            "organizationMembershipsLists",
        },
        allowSetters = true
    )
    private Set<Organization> organizationsLists = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Tenant id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public Tenant acronym(String acronym) {
        this.setAcronym(acronym);
        return this;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return this.name;
    }

    public Tenant name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public Tenant description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerBusinessCode() {
        return this.customerBusinessCode;
    }

    public Tenant customerBusinessCode(String customerBusinessCode) {
        this.setCustomerBusinessCode(customerBusinessCode);
        return this;
    }

    public void setCustomerBusinessCode(String customerBusinessCode) {
        this.customerBusinessCode = customerBusinessCode;
    }

    public String getBusinessHandlerClazz() {
        return this.businessHandlerClazz;
    }

    public Tenant businessHandlerClazz(String businessHandlerClazz) {
        this.setBusinessHandlerClazz(businessHandlerClazz);
        return this;
    }

    public void setBusinessHandlerClazz(String businessHandlerClazz) {
        this.businessHandlerClazz = businessHandlerClazz;
    }

    public String getMainContactPersonDetails() {
        return this.mainContactPersonDetails;
    }

    public Tenant mainContactPersonDetails(String mainContactPersonDetails) {
        this.setMainContactPersonDetails(mainContactPersonDetails);
        return this;
    }

    public void setMainContactPersonDetails(String mainContactPersonDetails) {
        this.mainContactPersonDetails = mainContactPersonDetails;
    }

    public String getBillingDetails() {
        return this.billingDetails;
    }

    public Tenant billingDetails(String billingDetails) {
        this.setBillingDetails(billingDetails);
        return this;
    }

    public void setBillingDetails(String billingDetails) {
        this.billingDetails = billingDetails;
    }

    public String getTechnicalEnvironmentsDetails() {
        return this.technicalEnvironmentsDetails;
    }

    public Tenant technicalEnvironmentsDetails(String technicalEnvironmentsDetails) {
        this.setTechnicalEnvironmentsDetails(technicalEnvironmentsDetails);
        return this;
    }

    public void setTechnicalEnvironmentsDetails(String technicalEnvironmentsDetails) {
        this.technicalEnvironmentsDetails = technicalEnvironmentsDetails;
    }

    public String getCommonCustomAttributesDetails() {
        return this.commonCustomAttributesDetails;
    }

    public Tenant commonCustomAttributesDetails(String commonCustomAttributesDetails) {
        this.setCommonCustomAttributesDetails(commonCustomAttributesDetails);
        return this;
    }

    public void setCommonCustomAttributesDetails(String commonCustomAttributesDetails) {
        this.commonCustomAttributesDetails = commonCustomAttributesDetails;
    }

    public byte[] getLogoImg() {
        return this.logoImg;
    }

    public Tenant logoImg(byte[] logoImg) {
        this.setLogoImg(logoImg);
        return this;
    }

    public void setLogoImg(byte[] logoImg) {
        this.logoImg = logoImg;
    }

    public String getLogoImgContentType() {
        return this.logoImgContentType;
    }

    public Tenant logoImgContentType(String logoImgContentType) {
        this.logoImgContentType = logoImgContentType;
        return this;
    }

    public void setLogoImgContentType(String logoImgContentType) {
        this.logoImgContentType = logoImgContentType;
    }

    public ActivationStatusEnum getActivationStatus() {
        return this.activationStatus;
    }

    public Tenant activationStatus(ActivationStatusEnum activationStatus) {
        this.setActivationStatus(activationStatus);
        return this;
    }

    public void setActivationStatus(ActivationStatusEnum activationStatus) {
        this.activationStatus = activationStatus;
    }

    public Set<Organization> getOrganizationsLists() {
        return this.organizationsLists;
    }

    public void setOrganizationsLists(Set<Organization> organizations) {
        if (this.organizationsLists != null) {
            this.organizationsLists.forEach(i -> i.setTenant(null));
        }
        if (organizations != null) {
            organizations.forEach(i -> i.setTenant(this));
        }
        this.organizationsLists = organizations;
    }

    public Tenant organizationsLists(Set<Organization> organizations) {
        this.setOrganizationsLists(organizations);
        return this;
    }

    public Tenant addOrganizationsList(Organization organization) {
        this.organizationsLists.add(organization);
        organization.setTenant(this);
        return this;
    }

    public Tenant removeOrganizationsList(Organization organization) {
        this.organizationsLists.remove(organization);
        organization.setTenant(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tenant)) {
            return false;
        }
        return getId() != null && getId().equals(((Tenant) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Tenant{" +
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
            ", logoImgContentType='" + getLogoImgContentType() + "'" +
            ", activationStatus='" + getActivationStatus() + "'" +
            "}";
    }
}
