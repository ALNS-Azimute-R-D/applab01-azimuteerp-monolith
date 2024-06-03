package de.org.dexterity.azimuteerp.monolith.web.rest;

import de.org.dexterity.azimuteerp.monolith.repository.LocalityRepository;
import de.org.dexterity.azimuteerp.monolith.service.LocalityService;
import de.org.dexterity.azimuteerp.monolith.service.dto.LocalityDTO;
import de.org.dexterity.azimuteerp.monolith.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link de.org.dexterity.azimuteerp.monolith.domain.Locality}.
 */
@RestController
@RequestMapping("/api/localities")
public class LocalityResource {

    private final Logger log = LoggerFactory.getLogger(LocalityResource.class);

    private static final String ENTITY_NAME = "locality";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final LocalityService localityService;

    private final LocalityRepository localityRepository;

    public LocalityResource(LocalityService localityService, LocalityRepository localityRepository) {
        this.localityService = localityService;
        this.localityRepository = localityRepository;
    }

    /**
     * {@code POST  /localities} : Create a new locality.
     *
     * @param localityDTO the localityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new localityDTO, or with status {@code 400 (Bad Request)} if the locality has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<LocalityDTO> createLocality(@Valid @RequestBody LocalityDTO localityDTO) throws URISyntaxException {
        log.debug("REST request to save Locality : {}", localityDTO);
        if (localityDTO.getId() != null) {
            throw new BadRequestAlertException("A new locality cannot already have an ID", ENTITY_NAME, "idexists");
        }
        localityDTO = localityService.save(localityDTO);
        return ResponseEntity.created(new URI("/api/localities/" + localityDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, localityDTO.getId().toString()))
            .body(localityDTO);
    }

    /**
     * {@code PUT  /localities/:id} : Updates an existing locality.
     *
     * @param id the id of the localityDTO to save.
     * @param localityDTO the localityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated localityDTO,
     * or with status {@code 400 (Bad Request)} if the localityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the localityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<LocalityDTO> updateLocality(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody LocalityDTO localityDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Locality : {}, {}", id, localityDTO);
        if (localityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, localityDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!localityRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        localityDTO = localityService.update(localityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, localityDTO.getId().toString()))
            .body(localityDTO);
    }

    /**
     * {@code PATCH  /localities/:id} : Partial updates given fields of an existing locality, field will ignore if it is null
     *
     * @param id the id of the localityDTO to save.
     * @param localityDTO the localityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated localityDTO,
     * or with status {@code 400 (Bad Request)} if the localityDTO is not valid,
     * or with status {@code 404 (Not Found)} if the localityDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the localityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<LocalityDTO> partialUpdateLocality(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody LocalityDTO localityDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Locality partially : {}, {}", id, localityDTO);
        if (localityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, localityDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!localityRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<LocalityDTO> result = localityService.partialUpdate(localityDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, localityDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /localities} : get all the localities.
     *
     * @param pageable the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of localities in body.
     */
    @GetMapping("")
    public ResponseEntity<List<LocalityDTO>> getAllLocalities(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable,
        @RequestParam(name = "eagerload", required = false, defaultValue = "true") boolean eagerload
    ) {
        log.debug("REST request to get a page of Localities");
        Page<LocalityDTO> page;
        if (eagerload) {
            page = localityService.findAllWithEagerRelationships(pageable);
        } else {
            page = localityService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /localities/:id} : get the "id" locality.
     *
     * @param id the id of the localityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the localityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<LocalityDTO> getLocality(@PathVariable("id") Long id) {
        log.debug("REST request to get Locality : {}", id);
        Optional<LocalityDTO> localityDTO = localityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(localityDTO);
    }

    /**
     * {@code DELETE  /localities/:id} : delete the "id" locality.
     *
     * @param id the id of the localityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocality(@PathVariable("id") Long id) {
        log.debug("REST request to delete Locality : {}", id);
        localityService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
