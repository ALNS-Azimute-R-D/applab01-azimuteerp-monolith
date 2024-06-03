package de.org.dexterity.azimuteerp.monolith.service;

import de.org.dexterity.azimuteerp.monolith.service.dto.TypeOfPersonDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link de.org.dexterity.azimuteerp.monolith.domain.TypeOfPerson}.
 */
public interface TypeOfPersonService {
    /**
     * Save a typeOfPerson.
     *
     * @param typeOfPersonDTO the entity to save.
     * @return the persisted entity.
     */
    TypeOfPersonDTO save(TypeOfPersonDTO typeOfPersonDTO);

    /**
     * Updates a typeOfPerson.
     *
     * @param typeOfPersonDTO the entity to update.
     * @return the persisted entity.
     */
    TypeOfPersonDTO update(TypeOfPersonDTO typeOfPersonDTO);

    /**
     * Partially updates a typeOfPerson.
     *
     * @param typeOfPersonDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TypeOfPersonDTO> partialUpdate(TypeOfPersonDTO typeOfPersonDTO);

    /**
     * Get all the typeOfPeople.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<TypeOfPersonDTO> findAll(Pageable pageable);

    /**
     * Get the "id" typeOfPerson.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TypeOfPersonDTO> findOne(Long id);

    /**
     * Delete the "id" typeOfPerson.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
