package de.org.dexterity.azimuteerp.monolith.service.impl;

import de.org.dexterity.azimuteerp.monolith.domain.Locality;
import de.org.dexterity.azimuteerp.monolith.repository.LocalityRepository;
import de.org.dexterity.azimuteerp.monolith.service.LocalityService;
import de.org.dexterity.azimuteerp.monolith.service.dto.LocalityDTO;
import de.org.dexterity.azimuteerp.monolith.service.mapper.LocalityMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link de.org.dexterity.azimuteerp.monolith.domain.Locality}.
 */
@Service
@Transactional
public class LocalityServiceImpl implements LocalityService {

    private final Logger log = LoggerFactory.getLogger(LocalityServiceImpl.class);

    private final LocalityRepository localityRepository;

    private final LocalityMapper localityMapper;

    public LocalityServiceImpl(LocalityRepository localityRepository, LocalityMapper localityMapper) {
        this.localityRepository = localityRepository;
        this.localityMapper = localityMapper;
    }

    @Override
    public LocalityDTO save(LocalityDTO localityDTO) {
        log.debug("Request to save Locality : {}", localityDTO);
        Locality locality = localityMapper.toEntity(localityDTO);
        locality = localityRepository.save(locality);
        return localityMapper.toDto(locality);
    }

    @Override
    public LocalityDTO update(LocalityDTO localityDTO) {
        log.debug("Request to update Locality : {}", localityDTO);
        Locality locality = localityMapper.toEntity(localityDTO);
        locality = localityRepository.save(locality);
        return localityMapper.toDto(locality);
    }

    @Override
    public Optional<LocalityDTO> partialUpdate(LocalityDTO localityDTO) {
        log.debug("Request to partially update Locality : {}", localityDTO);

        return localityRepository
            .findById(localityDTO.getId())
            .map(existingLocality -> {
                localityMapper.partialUpdate(existingLocality, localityDTO);

                return existingLocality;
            })
            .map(localityRepository::save)
            .map(localityMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LocalityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Localities");
        return localityRepository.findAll(pageable).map(localityMapper::toDto);
    }

    public Page<LocalityDTO> findAllWithEagerRelationships(Pageable pageable) {
        return localityRepository.findAllWithEagerRelationships(pageable).map(localityMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LocalityDTO> findOne(Long id) {
        log.debug("Request to get Locality : {}", id);
        return localityRepository.findOneWithEagerRelationships(id).map(localityMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Locality : {}", id);
        localityRepository.deleteById(id);
    }
}
