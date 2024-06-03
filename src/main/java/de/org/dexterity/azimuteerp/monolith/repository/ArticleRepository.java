package de.org.dexterity.azimuteerp.monolith.repository;

import de.org.dexterity.azimuteerp.monolith.domain.Article;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Article entity.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    default Optional<Article> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Article> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Article> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select article from Article article left join fetch article.mainCategory",
        countQuery = "select count(article) from Article article"
    )
    Page<Article> findAllWithToOneRelationships(Pageable pageable);

    @Query("select article from Article article left join fetch article.mainCategory")
    List<Article> findAllWithToOneRelationships();

    @Query("select article from Article article left join fetch article.mainCategory where article.id =:id")
    Optional<Article> findOneWithToOneRelationships(@Param("id") Long id);
}
