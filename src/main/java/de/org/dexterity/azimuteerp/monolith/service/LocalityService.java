package de.org.dexterity.azimuteerp.monolith.service;

import de.org.dexterity.azimuteerp.monolith.service.dto.LocalityDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link de.org.dexterity.azimuteerp.monolith.domain.Locality}.
 */
public interface LocalityService {
    /**
     * Save a locality.
     *
     * @param localityDTO the entity to save.
     * @return the persisted entity.
     */
    LocalityDTO save(LocalityDTO localityDTO);

    /**
     * Updates a locality.
     *
     * @param localityDTO the entity to update.
     * @return the persisted entity.
     */
    LocalityDTO update(LocalityDTO localityDTO);

    /**
     * Partially updates a locality.
     *
     * @param localityDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<LocalityDTO> partialUpdate(LocalityDTO localityDTO);

    /**
     * Get all the localities.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LocalityDTO> findAll(Pageable pageable);

    /**
     * Get all the localities with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<LocalityDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" locality.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<LocalityDTO> findOne(Long id);

    /**
     * Delete the "id" locality.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
