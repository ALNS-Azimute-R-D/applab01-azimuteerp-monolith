package de.org.dexterity.azimuteerp.monolith.service.impl;

import de.org.dexterity.azimuteerp.monolith.domain.TownCity;
import de.org.dexterity.azimuteerp.monolith.repository.TownCityRepository;
import de.org.dexterity.azimuteerp.monolith.service.TownCityService;
import de.org.dexterity.azimuteerp.monolith.service.dto.TownCityDTO;
import de.org.dexterity.azimuteerp.monolith.service.mapper.TownCityMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link de.org.dexterity.azimuteerp.monolith.domain.TownCity}.
 */
@Service
@Transactional
public class TownCityServiceImpl implements TownCityService {

    private final Logger log = LoggerFactory.getLogger(TownCityServiceImpl.class);

    private final TownCityRepository townCityRepository;

    private final TownCityMapper townCityMapper;

    public TownCityServiceImpl(TownCityRepository townCityRepository, TownCityMapper townCityMapper) {
        this.townCityRepository = townCityRepository;
        this.townCityMapper = townCityMapper;
    }

    @Override
    public TownCityDTO save(TownCityDTO townCityDTO) {
        log.debug("Request to save TownCity : {}", townCityDTO);
        TownCity townCity = townCityMapper.toEntity(townCityDTO);
        townCity = townCityRepository.save(townCity);
        return townCityMapper.toDto(townCity);
    }

    @Override
    public TownCityDTO update(TownCityDTO townCityDTO) {
        log.debug("Request to update TownCity : {}", townCityDTO);
        TownCity townCity = townCityMapper.toEntity(townCityDTO);
        townCity = townCityRepository.save(townCity);
        return townCityMapper.toDto(townCity);
    }

    @Override
    public Optional<TownCityDTO> partialUpdate(TownCityDTO townCityDTO) {
        log.debug("Request to partially update TownCity : {}", townCityDTO);

        return townCityRepository
            .findById(townCityDTO.getId())
            .map(existingTownCity -> {
                townCityMapper.partialUpdate(existingTownCity, townCityDTO);

                return existingTownCity;
            })
            .map(townCityRepository::save)
            .map(townCityMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TownCityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TownCities");
        return townCityRepository.findAll(pageable).map(townCityMapper::toDto);
    }

    public Page<TownCityDTO> findAllWithEagerRelationships(Pageable pageable) {
        return townCityRepository.findAllWithEagerRelationships(pageable).map(townCityMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TownCityDTO> findOne(Long id) {
        log.debug("Request to get TownCity : {}", id);
        return townCityRepository.findOneWithEagerRelationships(id).map(townCityMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TownCity : {}", id);
        townCityRepository.deleteById(id);
    }
}
