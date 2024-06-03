package de.org.dexterity.azimuteerp.monolith.service.impl;

import de.org.dexterity.azimuteerp.monolith.domain.TypeOfPerson;
import de.org.dexterity.azimuteerp.monolith.repository.TypeOfPersonRepository;
import de.org.dexterity.azimuteerp.monolith.service.TypeOfPersonService;
import de.org.dexterity.azimuteerp.monolith.service.dto.TypeOfPersonDTO;
import de.org.dexterity.azimuteerp.monolith.service.mapper.TypeOfPersonMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link de.org.dexterity.azimuteerp.monolith.domain.TypeOfPerson}.
 */
@Service
@Transactional
public class TypeOfPersonServiceImpl implements TypeOfPersonService {

    private final Logger log = LoggerFactory.getLogger(TypeOfPersonServiceImpl.class);

    private final TypeOfPersonRepository typeOfPersonRepository;

    private final TypeOfPersonMapper typeOfPersonMapper;

    public TypeOfPersonServiceImpl(TypeOfPersonRepository typeOfPersonRepository, TypeOfPersonMapper typeOfPersonMapper) {
        this.typeOfPersonRepository = typeOfPersonRepository;
        this.typeOfPersonMapper = typeOfPersonMapper;
    }

    @Override
    public TypeOfPersonDTO save(TypeOfPersonDTO typeOfPersonDTO) {
        log.debug("Request to save TypeOfPerson : {}", typeOfPersonDTO);
        TypeOfPerson typeOfPerson = typeOfPersonMapper.toEntity(typeOfPersonDTO);
        typeOfPerson = typeOfPersonRepository.save(typeOfPerson);
        return typeOfPersonMapper.toDto(typeOfPerson);
    }

    @Override
    public TypeOfPersonDTO update(TypeOfPersonDTO typeOfPersonDTO) {
        log.debug("Request to update TypeOfPerson : {}", typeOfPersonDTO);
        TypeOfPerson typeOfPerson = typeOfPersonMapper.toEntity(typeOfPersonDTO);
        typeOfPerson = typeOfPersonRepository.save(typeOfPerson);
        return typeOfPersonMapper.toDto(typeOfPerson);
    }

    @Override
    public Optional<TypeOfPersonDTO> partialUpdate(TypeOfPersonDTO typeOfPersonDTO) {
        log.debug("Request to partially update TypeOfPerson : {}", typeOfPersonDTO);

        return typeOfPersonRepository
            .findById(typeOfPersonDTO.getId())
            .map(existingTypeOfPerson -> {
                typeOfPersonMapper.partialUpdate(existingTypeOfPerson, typeOfPersonDTO);

                return existingTypeOfPerson;
            })
            .map(typeOfPersonRepository::save)
            .map(typeOfPersonMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TypeOfPersonDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TypeOfPeople");
        return typeOfPersonRepository.findAll(pageable).map(typeOfPersonMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TypeOfPersonDTO> findOne(Long id) {
        log.debug("Request to get TypeOfPerson : {}", id);
        return typeOfPersonRepository.findById(id).map(typeOfPersonMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete TypeOfPerson : {}", id);
        typeOfPersonRepository.deleteById(id);
    }
}