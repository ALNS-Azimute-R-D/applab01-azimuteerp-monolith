package de.org.dexterity.azimuteerp.monolith.web.rest;

import static de.org.dexterity.azimuteerp.monolith.domain.LocalityAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.org.dexterity.azimuteerp.monolith.IntegrationTest;
import de.org.dexterity.azimuteerp.monolith.domain.Country;
import de.org.dexterity.azimuteerp.monolith.domain.Locality;
import de.org.dexterity.azimuteerp.monolith.repository.LocalityRepository;
import de.org.dexterity.azimuteerp.monolith.service.LocalityService;
import de.org.dexterity.azimuteerp.monolith.service.dto.LocalityDTO;
import de.org.dexterity.azimuteerp.monolith.service.mapper.LocalityMapper;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link LocalityResource} REST controller.
 */
@IntegrationTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
class LocalityResourceIT {

    private static final String DEFAULT_ACRONYM = "AAAAAAAA";
    private static final String UPDATED_ACRONYM = "BBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final byte[] DEFAULT_GEO_POLYGON_AREA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_GEO_POLYGON_AREA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_GEO_POLYGON_AREA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_GEO_POLYGON_AREA_CONTENT_TYPE = "image/png";

    private static final String ENTITY_API_URL = "/api/localities";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private LocalityRepository localityRepository;

    @Mock
    private LocalityRepository localityRepositoryMock;

    @Autowired
    private LocalityMapper localityMapper;

    @Mock
    private LocalityService localityServiceMock;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restLocalityMockMvc;

    private Locality locality;

    private Locality insertedLocality;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Locality createEntity(EntityManager em) {
        Locality locality = new Locality()
            .acronym(DEFAULT_ACRONYM)
            .name(DEFAULT_NAME)
            .description(DEFAULT_DESCRIPTION)
            .geoPolygonArea(DEFAULT_GEO_POLYGON_AREA)
            .geoPolygonAreaContentType(DEFAULT_GEO_POLYGON_AREA_CONTENT_TYPE);
        // Add required entity
        Country country;
        if (TestUtil.findAll(em, Country.class).isEmpty()) {
            country = CountryResourceIT.createEntity(em);
            em.persist(country);
            em.flush();
        } else {
            country = TestUtil.findAll(em, Country.class).get(0);
        }
        locality.setCountry(country);
        return locality;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Locality createUpdatedEntity(EntityManager em) {
        Locality locality = new Locality()
            .acronym(UPDATED_ACRONYM)
            .name(UPDATED_NAME)
            .description(UPDATED_DESCRIPTION)
            .geoPolygonArea(UPDATED_GEO_POLYGON_AREA)
            .geoPolygonAreaContentType(UPDATED_GEO_POLYGON_AREA_CONTENT_TYPE);
        // Add required entity
        Country country;
        if (TestUtil.findAll(em, Country.class).isEmpty()) {
            country = CountryResourceIT.createUpdatedEntity(em);
            em.persist(country);
            em.flush();
        } else {
            country = TestUtil.findAll(em, Country.class).get(0);
        }
        locality.setCountry(country);
        return locality;
    }

    @BeforeEach
    public void initTest() {
        locality = createEntity(em);
    }

    @AfterEach
    public void cleanup() {
        if (insertedLocality != null) {
            localityRepository.delete(insertedLocality);
            insertedLocality = null;
        }
    }

    @Test
    @Transactional
    void createLocality() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Locality
        LocalityDTO localityDTO = localityMapper.toDto(locality);
        var returnedLocalityDTO = om.readValue(
            restLocalityMockMvc
                .perform(
                    post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(localityDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            LocalityDTO.class
        );

        // Validate the Locality in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedLocality = localityMapper.toEntity(returnedLocalityDTO);
        assertLocalityUpdatableFieldsEquals(returnedLocality, getPersistedLocality(returnedLocality));

        insertedLocality = returnedLocality;
    }

    @Test
    @Transactional
    void createLocalityWithExistingId() throws Exception {
        // Create the Locality with an existing ID
        locality.setId(1L);
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restLocalityMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(localityDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Locality in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkAcronymIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        locality.setAcronym(null);

        // Create the Locality, which fails.
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        restLocalityMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(localityDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        locality.setName(null);

        // Create the Locality, which fails.
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        restLocalityMockMvc
            .perform(post(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(localityDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllLocalities() throws Exception {
        // Initialize the database
        insertedLocality = localityRepository.saveAndFlush(locality);

        // Get all the localityList
        restLocalityMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(locality.getId().intValue())))
            .andExpect(jsonPath("$.[*].acronym").value(hasItem(DEFAULT_ACRONYM)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].geoPolygonAreaContentType").value(hasItem(DEFAULT_GEO_POLYGON_AREA_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].geoPolygonArea").value(hasItem(Base64.getEncoder().encodeToString(DEFAULT_GEO_POLYGON_AREA))));
    }

    @SuppressWarnings({ "unchecked" })
    void getAllLocalitiesWithEagerRelationshipsIsEnabled() throws Exception {
        when(localityServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restLocalityMockMvc.perform(get(ENTITY_API_URL + "?eagerload=true")).andExpect(status().isOk());

        verify(localityServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({ "unchecked" })
    void getAllLocalitiesWithEagerRelationshipsIsNotEnabled() throws Exception {
        when(localityServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        restLocalityMockMvc.perform(get(ENTITY_API_URL + "?eagerload=false")).andExpect(status().isOk());
        verify(localityRepositoryMock, times(1)).findAll(any(Pageable.class));
    }

    @Test
    @Transactional
    void getLocality() throws Exception {
        // Initialize the database
        insertedLocality = localityRepository.saveAndFlush(locality);

        // Get the locality
        restLocalityMockMvc
            .perform(get(ENTITY_API_URL_ID, locality.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(locality.getId().intValue()))
            .andExpect(jsonPath("$.acronym").value(DEFAULT_ACRONYM))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.geoPolygonAreaContentType").value(DEFAULT_GEO_POLYGON_AREA_CONTENT_TYPE))
            .andExpect(jsonPath("$.geoPolygonArea").value(Base64.getEncoder().encodeToString(DEFAULT_GEO_POLYGON_AREA)));
    }

    @Test
    @Transactional
    void getNonExistingLocality() throws Exception {
        // Get the locality
        restLocalityMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingLocality() throws Exception {
        // Initialize the database
        insertedLocality = localityRepository.saveAndFlush(locality);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the locality
        Locality updatedLocality = localityRepository.findById(locality.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedLocality are not directly saved in db
        em.detach(updatedLocality);
        updatedLocality
            .acronym(UPDATED_ACRONYM)
            .name(UPDATED_NAME)
            .description(UPDATED_DESCRIPTION)
            .geoPolygonArea(UPDATED_GEO_POLYGON_AREA)
            .geoPolygonAreaContentType(UPDATED_GEO_POLYGON_AREA_CONTENT_TYPE);
        LocalityDTO localityDTO = localityMapper.toDto(updatedLocality);

        restLocalityMockMvc
            .perform(
                put(ENTITY_API_URL_ID, localityDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(localityDTO))
            )
            .andExpect(status().isOk());

        // Validate the Locality in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedLocalityToMatchAllProperties(updatedLocality);
    }

    @Test
    @Transactional
    void putNonExistingLocality() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        locality.setId(longCount.incrementAndGet());

        // Create the Locality
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restLocalityMockMvc
            .perform(
                put(ENTITY_API_URL_ID, localityDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(localityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Locality in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchLocality() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        locality.setId(longCount.incrementAndGet());

        // Create the Locality
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restLocalityMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(localityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Locality in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamLocality() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        locality.setId(longCount.incrementAndGet());

        // Create the Locality
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restLocalityMockMvc
            .perform(put(ENTITY_API_URL).with(csrf()).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(localityDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Locality in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateLocalityWithPatch() throws Exception {
        // Initialize the database
        insertedLocality = localityRepository.saveAndFlush(locality);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the locality using partial update
        Locality partialUpdatedLocality = new Locality();
        partialUpdatedLocality.setId(locality.getId());

        partialUpdatedLocality.description(UPDATED_DESCRIPTION);

        restLocalityMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedLocality.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedLocality))
            )
            .andExpect(status().isOk());

        // Validate the Locality in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertLocalityUpdatableFieldsEquals(createUpdateProxyForBean(partialUpdatedLocality, locality), getPersistedLocality(locality));
    }

    @Test
    @Transactional
    void fullUpdateLocalityWithPatch() throws Exception {
        // Initialize the database
        insertedLocality = localityRepository.saveAndFlush(locality);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the locality using partial update
        Locality partialUpdatedLocality = new Locality();
        partialUpdatedLocality.setId(locality.getId());

        partialUpdatedLocality
            .acronym(UPDATED_ACRONYM)
            .name(UPDATED_NAME)
            .description(UPDATED_DESCRIPTION)
            .geoPolygonArea(UPDATED_GEO_POLYGON_AREA)
            .geoPolygonAreaContentType(UPDATED_GEO_POLYGON_AREA_CONTENT_TYPE);

        restLocalityMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedLocality.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedLocality))
            )
            .andExpect(status().isOk());

        // Validate the Locality in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertLocalityUpdatableFieldsEquals(partialUpdatedLocality, getPersistedLocality(partialUpdatedLocality));
    }

    @Test
    @Transactional
    void patchNonExistingLocality() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        locality.setId(longCount.incrementAndGet());

        // Create the Locality
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restLocalityMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, localityDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(localityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Locality in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchLocality() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        locality.setId(longCount.incrementAndGet());

        // Create the Locality
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restLocalityMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(localityDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Locality in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamLocality() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        locality.setId(longCount.incrementAndGet());

        // Create the Locality
        LocalityDTO localityDTO = localityMapper.toDto(locality);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restLocalityMockMvc
            .perform(
                patch(ENTITY_API_URL).with(csrf()).contentType("application/merge-patch+json").content(om.writeValueAsBytes(localityDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Locality in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteLocality() throws Exception {
        // Initialize the database
        insertedLocality = localityRepository.saveAndFlush(locality);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the locality
        restLocalityMockMvc
            .perform(delete(ENTITY_API_URL_ID, locality.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return localityRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected Locality getPersistedLocality(Locality locality) {
        return localityRepository.findById(locality.getId()).orElseThrow();
    }

    protected void assertPersistedLocalityToMatchAllProperties(Locality expectedLocality) {
        assertLocalityAllPropertiesEquals(expectedLocality, getPersistedLocality(expectedLocality));
    }

    protected void assertPersistedLocalityToMatchUpdatableProperties(Locality expectedLocality) {
        assertLocalityAllUpdatablePropertiesEquals(expectedLocality, getPersistedLocality(expectedLocality));
    }
}
