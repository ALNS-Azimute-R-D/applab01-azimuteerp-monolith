package de.org.dexterity.azimuteerp.monolith.service.dto;

import de.org.dexterity.azimuteerp.monolith.domain.enumeration.CustomerStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.Customer} entity.
 */
@Schema(description = "- Category\n- Article\n- Order\n- OrderItem")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CustomerDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 15)
    private String customerBusinessCode;

    @NotNull
    @Size(min = 2, max = 80)
    private String name;

    @Lob
    private String description;

    @NotNull
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    private String email;

    @Size(max = 255)
    private String addressDetails;

    @Size(max = 8)
    private String zipCode;

    @Size(max = 1024)
    private String keycloakGroupDetails;

    @NotNull
    private CustomerStatusEnum status;

    @NotNull
    private Boolean active;

    private CustomerTypeDTO customerType;

    private DistrictDTO district;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerBusinessCode() {
        return customerBusinessCode;
    }

    public void setCustomerBusinessCode(String customerBusinessCode) {
        this.customerBusinessCode = customerBusinessCode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getKeycloakGroupDetails() {
        return keycloakGroupDetails;
    }

    public void setKeycloakGroupDetails(String keycloakGroupDetails) {
        this.keycloakGroupDetails = keycloakGroupDetails;
    }

    public CustomerStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CustomerStatusEnum status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CustomerTypeDTO getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeDTO customerType) {
        this.customerType = customerType;
    }

    public DistrictDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictDTO district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerDTO)) {
            return false;
        }

        CustomerDTO customerDTO = (CustomerDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, customerDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerDTO{" +
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
            ", customerType=" + getCustomerType() +
            ", district=" + getDistrict() +
            "}";
    }
}
