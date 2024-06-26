package org.dexterity.darueira.azimuteerp.monolith.spring.service.impl;

import java.util.Optional;
import org.dexterity.darueira.azimuteerp.monolith.spring.domain.AssetType;
import org.dexterity.darueira.azimuteerp.monolith.spring.repository.AssetTypeRepository;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.AssetTypeService;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.AssetTypeDTO;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper.AssetTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link org.dexterity.darueira.azimuteerp.monolith.spring.domain.AssetType}.
 */
@Service
@Transactional
public class AssetTypeServiceImpl implements AssetTypeService {

    private final Logger log = LoggerFactory.getLogger(AssetTypeServiceImpl.class);

    private final AssetTypeRepository assetTypeRepository;

    private final AssetTypeMapper assetTypeMapper;

    public AssetTypeServiceImpl(AssetTypeRepository assetTypeRepository, AssetTypeMapper assetTypeMapper) {
        this.assetTypeRepository = assetTypeRepository;
        this.assetTypeMapper = assetTypeMapper;
    }

    @Override
    public AssetTypeDTO save(AssetTypeDTO assetTypeDTO) {
        log.debug("Request to save AssetType : {}", assetTypeDTO);
        AssetType assetType = assetTypeMapper.toEntity(assetTypeDTO);
        assetType = assetTypeRepository.save(assetType);
        return assetTypeMapper.toDto(assetType);
    }

    @Override
    public AssetTypeDTO update(AssetTypeDTO assetTypeDTO) {
        log.debug("Request to update AssetType : {}", assetTypeDTO);
        AssetType assetType = assetTypeMapper.toEntity(assetTypeDTO);
        assetType = assetTypeRepository.save(assetType);
        return assetTypeMapper.toDto(assetType);
    }

    @Override
    public Optional<AssetTypeDTO> partialUpdate(AssetTypeDTO assetTypeDTO) {
        log.debug("Request to partially update AssetType : {}", assetTypeDTO);

        return assetTypeRepository
            .findById(assetTypeDTO.getId())
            .map(existingAssetType -> {
                assetTypeMapper.partialUpdate(existingAssetType, assetTypeDTO);

                return existingAssetType;
            })
            .map(assetTypeRepository::save)
            .map(assetTypeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AssetTypeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AssetTypes");
        return assetTypeRepository.findAll(pageable).map(assetTypeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AssetTypeDTO> findOne(Long id) {
        log.debug("Request to get AssetType : {}", id);
        return assetTypeRepository.findById(id).map(assetTypeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete AssetType : {}", id);
        assetTypeRepository.deleteById(id);
    }
}
