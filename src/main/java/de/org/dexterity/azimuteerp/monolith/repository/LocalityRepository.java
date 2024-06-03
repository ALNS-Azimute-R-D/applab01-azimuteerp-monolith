package de.org.dexterity.azimuteerp.monolith.repository;

import de.org.dexterity.azimuteerp.monolith.domain.Locality;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Locality entity.
 */
@Repository
public interface LocalityRepository extends JpaRepository<Locality, Long> {
    default Optional<Locality> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Locality> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Locality> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select locality from Locality locality left join fetch locality.country",
        countQuery = "select count(locality) from Locality locality"
    )
    Page<Locality> findAllWithToOneRelationships(Pageable pageable);

    @Query("select locality from Locality locality left join fetch locality.country")
    List<Locality> findAllWithToOneRelationships();

    @Query("select locality from Locality locality left join fetch locality.country where locality.id =:id")
    Optional<Locality> findOneWithToOneRelationships(@Param("id") Long id);
}
