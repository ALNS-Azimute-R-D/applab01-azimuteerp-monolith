package de.org.dexterity.azimuteerp.monolith.service.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.Supplier} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SupplierDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 50)
    private String acronym;

    @NotNull
    @Size(min = 2, max = 120)
    private String companyName;

    @Size(max = 50)
    private String representativeLastName;

    @Size(max = 50)
    private String representativeFirstName;

    @Size(max = 50)
    private String jobTitle;

    @NotNull
    @Size(max = 120)
    private String streetAddress;

    @Size(max = 20)
    private String houseNumber;

    @Size(max = 50)
    private String locationName;

    @Size(max = 50)
    private String city;

    @Size(max = 50)
    private String stateProvince;

    @Size(max = 15)
    private String zipPostalCode;

    @Size(max = 50)
    private String countryRegion;

    @Lob
    private String webPage;

    @Lob
    private byte[] pointLocation;

    private String pointLocationContentType;

    @Size(max = 120)
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    private String mainEmail;

    @Size(max = 15)
    private String landPhoneNumber;

    @Size(max = 15)
    private String mobilePhoneNumber;

    @Size(max = 15)
    private String faxNumber;

    @Lob
    private String extraDetails;

    private Set<ProductDTO> productsLists = new HashSet<>();

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRepresentativeLastName() {
        return representativeLastName;
    }

    public void setRepresentativeLastName(String representativeLastName) {
        this.representativeLastName = representativeLastName;
    }

    public String getRepresentativeFirstName() {
        return representativeFirstName;
    }

    public void setRepresentativeFirstName(String representativeFirstName) {
        this.representativeFirstName = representativeFirstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public byte[] getPointLocation() {
        return pointLocation;
    }

    public void setPointLocation(byte[] pointLocation) {
        this.pointLocation = pointLocation;
    }

    public String getPointLocationContentType() {
        return pointLocationContentType;
    }

    public void setPointLocationContentType(String pointLocationContentType) {
        this.pointLocationContentType = pointLocationContentType;
    }

    public String getMainEmail() {
        return mainEmail;
    }

    public void setMainEmail(String mainEmail) {
        this.mainEmail = mainEmail;
    }

    public String getLandPhoneNumber() {
        return landPhoneNumber;
    }

    public void setLandPhoneNumber(String landPhoneNumber) {
        this.landPhoneNumber = landPhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public Set<ProductDTO> getProductsLists() {
        return productsLists;
    }

    public void setProductsLists(Set<ProductDTO> productsLists) {
        this.productsLists = productsLists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SupplierDTO)) {
            return false;
        }

        SupplierDTO supplierDTO = (SupplierDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, supplierDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SupplierDTO{" +
            "id=" + getId() +
            ", acronym='" + getAcronym() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", representativeLastName='" + getRepresentativeLastName() + "'" +
            ", representativeFirstName='" + getRepresentativeFirstName() + "'" +
            ", jobTitle='" + getJobTitle() + "'" +
            ", streetAddress='" + getStreetAddress() + "'" +
            ", houseNumber='" + getHouseNumber() + "'" +
            ", locationName='" + getLocationName() + "'" +
            ", city='" + getCity() + "'" +
            ", stateProvince='" + getStateProvince() + "'" +
            ", zipPostalCode='" + getZipPostalCode() + "'" +
            ", countryRegion='" + getCountryRegion() + "'" +
            ", webPage='" + getWebPage() + "'" +
            ", pointLocation='" + getPointLocation() + "'" +
            ", mainEmail='" + getMainEmail() + "'" +
            ", landPhoneNumber='" + getLandPhoneNumber() + "'" +
            ", mobilePhoneNumber='" + getMobilePhoneNumber() + "'" +
            ", faxNumber='" + getFaxNumber() + "'" +
            ", extraDetails='" + getExtraDetails() + "'" +
            ", productsLists=" + getProductsLists() +
            "}";
    }
}
