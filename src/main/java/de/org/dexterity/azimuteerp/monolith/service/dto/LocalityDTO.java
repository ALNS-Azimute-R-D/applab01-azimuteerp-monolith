package de.org.dexterity.azimuteerp.monolith.service.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link de.org.dexterity.azimuteerp.monolith.domain.Locality} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class LocalityDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 8)
    private String acronym;

    @NotNull
    @Size(max = 840)
    private String name;

    @Lob
    private String description;

    @Lob
    private byte[] geoPolygonArea;

    private String geoPolygonAreaContentType;

    @NotNull
    private CountryDTO country;

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

    public byte[] getGeoPolygonArea() {
        return geoPolygonArea;
    }

    public void setGeoPolygonArea(byte[] geoPolygonArea) {
        this.geoPolygonArea = geoPolygonArea;
    }

    public String getGeoPolygonAreaContentType() {
        return geoPolygonAreaContentType;
    }

    public void setGeoPolygonAreaContentType(String geoPolygonAreaContentType) {
        this.geoPolygonAreaContentType = geoPolygonAreaContentType;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LocalityDTO)) {
            return false;
        }

        LocalityDTO localityDTO = (LocalityDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, localityDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LocalityDTO{" +
            "id=" + getId() +
            ", acronym='" + getAcronym() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", geoPolygonArea='" + getGeoPolygonArea() + "'" +
            ", country=" + getCountry() +
            "}";
    }
}
