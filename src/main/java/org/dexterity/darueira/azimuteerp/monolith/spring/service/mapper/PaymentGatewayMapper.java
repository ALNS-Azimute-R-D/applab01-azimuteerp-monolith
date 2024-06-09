package org.dexterity.darueira.azimuteerp.monolith.spring.service.mapper;

import org.dexterity.darueira.azimuteerp.monolith.spring.domain.PaymentGateway;
import org.dexterity.darueira.azimuteerp.monolith.spring.service.dto.PaymentGatewayDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentGateway} and its DTO {@link PaymentGatewayDTO}.
 */
@Mapper(componentModel = "spring")
public interface PaymentGatewayMapper extends EntityMapper<PaymentGatewayDTO, PaymentGateway> {}
