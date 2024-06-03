package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.org.dexterity.azimuteerp.monolith.domain.enumeration.CustomerStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * - Category
 * - Article
 * - Order
 * - OrderItem
 */
@Entity
@Table(name = "tb_customer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "customer_business_code", length = 15, nullable = false)
    private String customerBusinessCode;

    @NotNull
    @Size(min = 2, max = 80)
    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(max = 255)
    @Column(name = "address_details", length = 255)
    private String addressDetails;

    @Size(max = 8)
    @Column(name = "zip_code", length = 8)
    private String zipCode;

    @Size(max = 1024)
    @Column(name = "keycloak_group_details", length = 1024)
    private String keycloakGroupDetails;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CustomerStatusEnum status;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "customersLists" }, allowSetters = true)
    private CustomerType customerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "townCity", "personsLists", "customersLists" }, allowSetters = true)
    private District district;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Customer id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerBusinessCode() {
        return this.customerBusinessCode;
    }

    public Customer customerBusinessCode(String customerBusinessCode) {
        this.setCustomerBusinessCode(customerBusinessCode);
        return this;
    }

    public void setCustomerBusinessCode(String customerBusinessCode) {
        this.customerBusinessCode = customerBusinessCode;
    }

    public String getName() {
        return this.name;
    }

    public Customer name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public Customer description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return this.email;
    }

    public Customer email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressDetails() {
        return this.addressDetails;
    }

    public Customer addressDetails(String addressDetails) {
        this.setAddressDetails(addressDetails);
        return this;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public Customer zipCode(String zipCode) {
        this.setZipCode(zipCode);
        return this;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getKeycloakGroupDetails() {
        return this.keycloakGroupDetails;
    }

    public Customer keycloakGroupDetails(String keycloakGroupDetails) {
        this.setKeycloakGroupDetails(keycloakGroupDetails);
        return this;
    }

    public void setKeycloakGroupDetails(String keycloakGroupDetails) {
        this.keycloakGroupDetails = keycloakGroupDetails;
    }

    public CustomerStatusEnum getStatus() {
        return this.status;
    }

    public Customer status(CustomerStatusEnum status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(CustomerStatusEnum status) {
        this.status = status;
    }

    public Boolean getActive() {
        return this.active;
    }

    public Customer active(Boolean active) {
        this.setActive(active);
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CustomerType getCustomerType() {
        return this.customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer customerType(CustomerType customerType) {
        this.setCustomerType(customerType);
        return this;
    }

    public District getDistrict() {
        return this.district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Customer district(District district) {
        this.setDistrict(district);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return getId() != null && getId().equals(((Customer) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", customerBusinessCode='" + getCustomerBusinessCode() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", email='" + getEmail() + "'" +
            ", addressDetails='" + getAddressDetails() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", keycloakGroupDetails='" + getKeycloakGroupDetails() + "'" +
            ", status='" + getStatus() + "'" +
            ", active='" + getActive() + "'" +
            "}";
    }
}
