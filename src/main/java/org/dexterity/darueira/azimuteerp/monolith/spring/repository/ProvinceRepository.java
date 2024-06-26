package org.dexterity.darueira.azimuteerp.monolith.spring.repository;

import java.util.List;
import java.util.Optional;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Province entity.
 */
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    default Optional<Province> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Province> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Province> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select province from Province province left join fetch province.country",
        countQuery = "select count(province) from Province province"
    )
    Page<Province> findAllWithToOneRelationships(Pageable pageable);

    @Query("select province from Province province left join fetch province.country")
    List<Province> findAllWithToOneRelationships();

    @Query("select province from Province province left join fetch province.country where province.id =:id")
    Optional<Province> findOneWithToOneRelationships(@Param("id") Long id);
}
