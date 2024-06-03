package de.org.dexterity.azimuteerp.monolith.service.mapper;

import de.org.dexterity.azimuteerp.monolith.domain.Invoice;
import de.org.dexterity.azimuteerp.monolith.domain.PaymentMethod;
import de.org.dexterity.azimuteerp.monolith.service.dto.InvoiceDTO;
import de.org.dexterity.azimuteerp.monolith.service.dto.PaymentMethodDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Invoice} and its DTO {@link InvoiceDTO}.
 */
@Mapper(componentModel = "spring")
public interface InvoiceMapper extends EntityMapper<InvoiceDTO, Invoice> {
    @Mapping(target = "preferrablePaymentMethod", source = "preferrablePaymentMethod", qualifiedByName = "paymentMethodCode")
    InvoiceDTO toDto(Invoice s);

    @Named("paymentMethodCode")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "code", source = "code")
    PaymentMethodDTO toDtoPaymentMethodCode(PaymentMethod paymentMethod);
}
