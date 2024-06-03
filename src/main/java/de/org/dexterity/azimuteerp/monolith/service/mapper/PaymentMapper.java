package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Payment;
import de.org.dexterity.azimuteerp.monolith.domain.PaymentMethod;
import de.org.dexterity.azimuteerp.monolith.service.dto.PaymentDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.PaymentMethodDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Payment} and its DTO {@link PaymentDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment> {
    @Mapping(target = "paymentMethod", source = "paymentMethod", qualifiedByName = "paymentMethodCode")
    PaymentDTO toDto(Payment s);

    @Named("paymentMethodCode")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "code", source = "code")
    PaymentMethodDTO toDtoPaymentMethodCode(PaymentMethod paymentMethod);
}
