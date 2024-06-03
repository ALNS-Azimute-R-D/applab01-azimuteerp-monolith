package de.org.dexterity.azimuteerp.monolith.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Supplier.
 */
@Entity
@Table(name = "tb_supplier")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "acronym", length = 50, nullable = false)
    private String acronym;

    @NotNull
    @Size(min = 2, max = 120)
    @Column(name = "company_name", length = 120, nullable = false)
    private String companyName;

    @Size(max = 50)
    @Column(name = "representative_last_name", length = 50)
    private String representativeLastName;

    @Size(max = 50)
    @Column(name = "representative_first_name", length = 50)
    private String representativeFirstName;

    @Size(max = 50)
    @Column(name = "job_title", length = 50)
    private String jobTitle;

    @NotNull
    @Size(max = 120)
    @Column(name = "street_address", length = 120, nullable = false)
    private String streetAddress;

    @Size(max = 20)
    @Column(name = "house_number", length = 20)
    private String houseNumber;

    @Size(max = 50)
    @Column(name = "location_name", length = 50)
    private String locationName;

    @Size(max = 50)
    @Column(name = "city", length = 50)
    private String city;

    @Size(max = 50)
    @Column(name = "state_province", length = 50)
    private String stateProvince;

    @Size(max = 15)
    @Column(name = "zip_postal_code", length = 15)
    private String zipPostalCode;

    @Size(max = 50)
    @Column(name = "country_region", length = 50)
    private String countryRegion;

    @Lob
    @Column(name = "web_page")
    private String webPage;

    @Lob
    @Column(name = "point_location")
    private byte[] pointLocation;

    @Column(name = "point_location_content_type")
    private String pointLocationContentType;

    @Size(max = 120)
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    @Column(name = "main_email", length = 120)
    private String mainEmail;

    @Size(max = 15)
    @Column(name = "land_phone_number", length = 15)
    private String landPhoneNumber;

    @Size(max = 15)
    @Column(name = "mobile_phone_number", length = 15)
    private String mobilePhoneNumber;

    @Size(max = 15)
    @Column(name = "fax_number", length = 15)
    private String faxNumber;

    @Lob
    @Column(name = "extra_details")
    private String extraDetails;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "rel_tb_supplier__products_list",
        joinColumns = @JoinColumn(name = "tb_supplier_id"),
        inverseJoinColumns = @JoinColumn(name = "products_list_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "brand", "productsLists", "stockLevelsLists", "suppliersLists" }, allowSetters = true)
    private Set<Product> productsLists = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "supplier", "product", "warehouse" }, allowSetters = true)
    private Set<InventoryTransaction> inventoryTransactionsLists = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Supplier id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public Supplier acronym(String acronym) {
        this.setAcronym(acronym);
        return this;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public Supplier companyName(String companyName) {
        this.setCompanyName(companyName);
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRepresentativeLastName() {
        return this.representativeLastName;
    }

    public Supplier representativeLastName(String representativeLastName) {
        this.setRepresentativeLastName(representativeLastName);
        return this;
    }

    public void setRepresentativeLastName(String representativeLastName) {
        this.representativeLastName = representativeLastName;
    }

    public String getRepresentativeFirstName() {
        return this.representativeFirstName;
    }

    public Supplier representativeFirstName(String representativeFirstName) {
        this.setRepresentativeFirstName(representativeFirstName);
        return this;
    }

    public void setRepresentativeFirstName(String representativeFirstName) {
        this.representativeFirstName = representativeFirstName;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public Supplier jobTitle(String jobTitle) {
        this.setJobTitle(jobTitle);
        return this;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public Supplier streetAddress(String streetAddress) {
        this.setStreetAddress(streetAddress);
        return this;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public Supplier houseNumber(String houseNumber) {
        this.setHouseNumber(houseNumber);
        return this;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public Supplier locationName(String locationName) {
        this.setLocationName(locationName);
        return this;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCity() {
        return this.city;
    }

    public Supplier city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return this.stateProvince;
    }

    public Supplier stateProvince(String stateProvince) {
        this.setStateProvince(stateProvince);
        return this;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getZipPostalCode() {
        return this.zipPostalCode;
    }

    public Supplier zipPostalCode(String zipPostalCode) {
        this.setZipPostalCode(zipPostalCode);
        return this;
    }

    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    public String getCountryRegion() {
        return this.countryRegion;
    }

    public Supplier countryRegion(String countryRegion) {
        this.setCountryRegion(countryRegion);
        return this;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getWebPage() {
        return this.webPage;
    }

    public Supplier webPage(String webPage) {
        this.setWebPage(webPage);
        return this;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public byte[] getPointLocation() {
        return this.pointLocation;
    }

    public Supplier pointLocation(byte[] pointLocation) {
        this.setPointLocation(pointLocation);
        return this;
    }

    public void setPointLocation(byte[] pointLocation) {
        this.pointLocation = pointLocation;
    }

    public String getPointLocationContentType() {
        return this.pointLocationContentType;
    }

    public Supplier pointLocationContentType(String pointLocationContentType) {
        this.pointLocationContentType = pointLocationContentType;
        return this;
    }

    public void setPointLocationContentType(String pointLocationContentType) {
        this.pointLocationContentType = pointLocationContentType;
    }

    public String getMainEmail() {
        return this.mainEmail;
    }

    public Supplier mainEmail(String mainEmail) {
        this.setMainEmail(mainEmail);
        return this;
    }

    public void setMainEmail(String mainEmail) {
        this.mainEmail = mainEmail;
    }

    public String getLandPhoneNumber() {
        return this.landPhoneNumber;
    }

    public Supplier landPhoneNumber(String landPhoneNumber) {
        this.setLandPhoneNumber(landPhoneNumber);
        return this;
    }

    public void setLandPhoneNumber(String landPhoneNumber) {
        this.landPhoneNumber = landPhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return this.mobilePhoneNumber;
    }

    public Supplier mobilePhoneNumber(String mobilePhoneNumber) {
        this.setMobilePhoneNumber(mobilePhoneNumber);
        return this;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getFaxNumber() {
        return this.faxNumber;
    }

    public Supplier faxNumber(String faxNumber) {
        this.setFaxNumber(faxNumber);
        return this;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getExtraDetails() {
        return this.extraDetails;
    }

    public Supplier extraDetails(String extraDetails) {
        this.setExtraDetails(extraDetails);
        return this;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public Set<Product> getProductsLists() {
        return this.productsLists;
    }

    public void setProductsLists(Set<Product> products) {
        this.productsLists = products;
    }

    public Supplier productsLists(Set<Product> products) {
        this.setProductsLists(products);
        return this;
    }

    public Supplier addProductsList(Product product) {
        this.productsLists.add(product);
        return this;
    }

    public Supplier removeProductsList(Product product) {
        this.productsLists.remove(product);
        return this;
    }

    public Set<InventoryTransaction> getInventoryTransactionsLists() {
        return this.inventoryTransactionsLists;
    }

    public void setInventoryTransactionsLists(Set<InventoryTransaction> inventoryTransactions) {
        if (this.inventoryTransactionsLists != null) {
            this.inventoryTransactionsLists.forEach(i -> i.setSupplier(null));
        }
        if (inventoryTransactions != null) {
            inventoryTransactions.forEach(i -> i.setSupplier(this));
        }
        this.inventoryTransactionsLists = inventoryTransactions;
    }

    public Supplier inventoryTransactionsLists(Set<InventoryTransaction> inventoryTransactions) {
        this.setInventoryTransactionsLists(inventoryTransactions);
        return this;
    }

    public Supplier addInventoryTransactionsList(InventoryTransaction inventoryTransaction) {
        this.inventoryTransactionsLists.add(inventoryTransaction);
        inventoryTransaction.setSupplier(this);
        return this;
    }

    public Supplier removeInventoryTransactionsList(InventoryTransaction inventoryTransaction) {
        this.inventoryTransactionsLists.remove(inventoryTransaction);
        inventoryTransaction.setSupplier(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Supplier)) {
            return false;
        }
        return getId() != null && getId().equals(((Supplier) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Supplier{" +
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
            ", pointLocationContentType='" + getPointLocationContentType() + "'" +
            ", mainEmail='" + getMainEmail() + "'" +
            ", landPhoneNumber='" + getLandPhoneNumber() + "'" +
            ", mobilePhoneNumber='" + getMobilePhoneNumber() + "'" +
            ", faxNumber='" + getFaxNumber() + "'" +
            ", extraDetails='" + getExtraDetails() + "'" +
            "}";
    }
}
