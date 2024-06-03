package de.org.dexterity.azimuteerp.monolith.service.impl;

import de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmp;
import de.org.dexterity.azimuteerp.monolith.repository.RawAssetProcTmpRepository;
import de.org.dexterity.azimuteerp.monolith.service.RawAssetProcTmpService;
import de.org.dexterity.azimuteerp.monolith.service.dto.RawAssetProcTmpDTO;
import de.org.dexterity.azimuteerp.monolith.service.mapper.RawAssetProcTmpMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmp}.
 */
@Service
@Transactional
public class RawAssetProcTmpServiceImpl implements RawAssetProcTmpService {

    private final Logger log = LoggerFactory.getLogger(RawAssetProcTmpServiceImpl.class);

    private final RawAssetProcTmpRepository rawAssetProcTmpRepository;

    private final RawAssetProcTmpMapper rawAssetProcTmpMapper;

    public RawAssetProcTmpServiceImpl(RawAssetProcTmpRepository rawAssetProcTmpRepository, RawAssetProcTmpMapper rawAssetProcTmpMapper) {
        this.rawAssetProcTmpRepository = rawAssetProcTmpRepository;
        this.rawAssetProcTmpMapper = rawAssetProcTmpMapper;
    }

    @Override
    public RawAssetProcTmpDTO save(RawAssetProcTmpDTO rawAssetProcTmpDTO) {
        log.debug("Request to save RawAssetProcTmp : {}", rawAssetProcTmpDTO);
        RawAssetProcTmp rawAssetProcTmp = rawAssetProcTmpMapper.toEntity(rawAssetProcTmpDTO);
        rawAssetProcTmp = rawAssetProcTmpRepository.save(rawAssetProcTmp);
        return rawAssetProcTmpMapper.toDto(rawAssetProcTmp);
    }

    @Override
    public RawAssetProcTmpDTO update(RawAssetProcTmpDTO rawAssetProcTmpDTO) {
        log.debug("Request to update RawAssetProcTmp : {}", rawAssetProcTmpDTO);
        RawAssetProcTmp rawAssetProcTmp = rawAssetProcTmpMapper.toEntity(rawAssetProcTmpDTO);
        rawAssetProcTmp = rawAssetProcTmpRepository.save(rawAssetProcTmp);
        return rawAssetProcTmpMapper.toDto(rawAssetProcTmp);
    }

    @Override
    public Optional<RawAssetProcTmpDTO> partialUpdate(RawAssetProcTmpDTO rawAssetProcTmpDTO) {
        log.debug("Request to partially update RawAssetProcTmp : {}", rawAssetProcTmpDTO);

        return rawAssetProcTmpRepository
            .findById(rawAssetProcTmpDTO.getId())
            .map(existingRawAssetProcTmp -> {
                rawAssetProcTmpMapper.partialUpdate(existingRawAssetProcTmp, rawAssetProcTmpDTO);

                return existingRawAssetProcTmp;
            })
            .map(rawAssetProcTmpRepository::save)
            .map(rawAssetProcTmpMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RawAssetProcTmpDTO> findAll(Pageable pageable) {
        log.debug("Request to get all RawAssetProcTmps");
        return rawAssetProcTmpRepository.findAll(pageable).map(rawAssetProcTmpMapper::toDto);
    }

    public Page<RawAssetProcTmpDTO> findAllWithEagerRelationships(Pageable pageable) {
        return rawAssetProcTmpRepository.findAllWithEagerRelationships(pageable).map(rawAssetProcTmpMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RawAssetProcTmpDTO> findOne(Long id) {
        log.debug("Request to get RawAssetProcTmp : {}", id);
        return rawAssetProcTmpRepository.findOneWithEagerRelationships(id).map(rawAssetProcTmpMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RawAssetProcTmp : {}", id);
        rawAssetProcTmpRepository.deleteById(id);
    }
}
