package de.org.dexterity.azimuteerp.monolith.repository;

import de.org.dexterity.azimuteerp.monolith.domain.TypeOfPerson;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the TypeOfPerson entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeOfPersonRepository extends JpaRepository<TypeOfPerson, Long> {}
