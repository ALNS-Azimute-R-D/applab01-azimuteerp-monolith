package de.org.dexterity.azimuteerp.monolith.repository;

import de.org.dexterity.azimuteerp.monolith.domain.OrganizationMemberRole;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the OrganizationMemberRole entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrganizationMemberRoleRepository extends JpaRepository<OrganizationMemberRole, Long> {}
