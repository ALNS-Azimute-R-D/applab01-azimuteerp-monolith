package org.dexterity.darueira.azimuteerp.monolith.spring.repository;

import org.dexterity.darueira.azimuteerp.monolith.spring.domain.AssetType;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the AssetType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AssetTypeRepository extends JpaRepository<AssetType, Long> {}
