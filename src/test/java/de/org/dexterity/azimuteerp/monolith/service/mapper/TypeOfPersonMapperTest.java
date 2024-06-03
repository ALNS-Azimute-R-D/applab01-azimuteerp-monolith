package de.org.dexterity.azimuteerp.monolith.service.mapper;

import static de.org.dexterity.azimuteerp.monolith.domain.TypeOfPersonAsserts.*;
import static de.org.dexterity.azimuteerp.monolith.domain.TypeOfPersonTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeOfPersonMapperTest {

    private TypeOfPersonMapper typeOfPersonMapper;

    @BeforeEach
    void setUp() {
        typeOfPersonMapper = new TypeOfPersonMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTypeOfPersonSample1();
        var actual = typeOfPersonMapper.toEntity(typeOfPersonMapper.toDto(expected));
        assertTypeOfPersonAllPropertiesEquals(expected, actual);
    }
}
