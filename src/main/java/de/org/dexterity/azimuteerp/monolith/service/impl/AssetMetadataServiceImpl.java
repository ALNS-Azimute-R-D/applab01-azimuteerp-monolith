package de.org.dexterity.azimuteerp.monolith.service.impl;

import de.org.dexterity.azimuteerp.monolith.domain.AssetMetadata;
import de.org.dexterity.azimuteerp.monolith.repository.AssetMetadataRepository;
import de.org.dexterity.azimuteerp.monolith.service.AssetMetadataService;
import de.org.dexterity.azimuteerp.monolith.service.dto.AssetMetadataDTO;
import de.org.dexterity.azimuteerp.monolith.service.mapper.AssetMetadataMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link de.org.dexterity.azimuteerp.monolith.domain.AssetMetadata}.
 */
@Service
@Transactional
public class AssetMetadataServiceImpl implements AssetMetadataService {

    private final Logger log = LoggerFactory.getLogger(AssetMetadataServiceImpl.class);

    private final AssetMetadataRepository assetMetadataRepository;

    private final AssetMetadataMapper assetMetadataMapper;

    public AssetMetadataServiceImpl(AssetMetadataRepository assetMetadataRepository, AssetMetadataMapper assetMetadataMapper) {
        this.assetMetadataRepository = assetMetadataRepository;
        this.assetMetadataMapper = assetMetadataMapper;
    }

    @Override
    public AssetMetadataDTO save(AssetMetadataDTO assetMetadataDTO) {
        log.debug("Request to save AssetMetadata : {}", assetMetadataDTO);
        AssetMetadata assetMetadata = assetMetadataMapper.toEntity(assetMetadataDTO);
        assetMetadata = assetMetadataRepository.save(assetMetadata);
        return assetMetadataMapper.toDto(assetMetadata);
    }

    @Override
    public AssetMetadataDTO update(AssetMetadataDTO assetMetadataDTO) {
        log.debug("Request to update AssetMetadata : {}", assetMetadataDTO);
        AssetMetadata assetMetadata = assetMetadataMapper.toEntity(assetMetadataDTO);
        assetMetadata = assetMetadataRepository.save(assetMetadata);
        return assetMetadataMapper.toDto(assetMetadata);
    }

    @Override
    public Optional<AssetMetadataDTO> partialUpdate(AssetMetadataDTO assetMetadataDTO) {
        log.debug("Request to partially update AssetMetadata : {}", assetMetadataDTO);

        return assetMetadataRepository
            .findById(assetMetadataDTO.getId())
            .map(existingAssetMetadata -> {
                assetMetadataMapper.partialUpdate(existingAssetMetadata, assetMetadataDTO);

                return existingAssetMetadata;
            })
            .map(assetMetadataRepository::save)
            .map(assetMetadataMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AssetMetadataDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AssetMetadata");
        return assetMetadataRepository.findAll(pageable).map(assetMetadataMapper::toDto);
    }

    public Page<AssetMetadataDTO> findAllWithEagerRelationships(Pageable pageable) {
        return assetMetadataRepository.findAllWithEagerRelationships(pageable).map(assetMetadataMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AssetMetadataDTO> findOne(Long id) {
        log.debug("Request to get AssetMetadata : {}", id);
        return assetMetadataRepository.findOneWithEagerRelationships(id).map(assetMetadataMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete AssetMetadata : {}", id);
        assetMetadataRepository.deleteById(id);
    }
}
