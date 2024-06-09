package org.dexterity.darueira.azimuteerp.monolith.spring.repository;

import org.dexterity.darueira.azimuteerp.monolith.spring.domain.CustomerType;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CustomerType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {}
