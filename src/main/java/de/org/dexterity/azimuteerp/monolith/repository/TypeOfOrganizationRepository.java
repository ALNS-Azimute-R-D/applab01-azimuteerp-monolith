package de.org.dexterity.azimuteerp.monolith.repository;

import de.org.dexterity.azimuteerp.monolith.domain.TypeOfOrganization;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the TypeOfOrganization entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeOfOrganizationRepository extends JpaRepository<TypeOfOrganization, Long> {}
