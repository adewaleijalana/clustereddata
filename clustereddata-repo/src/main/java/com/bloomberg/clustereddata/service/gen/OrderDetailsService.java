package com.bloomberg.clustereddata.service.gen;


import com.bloomberg.clustereddata.domain.OrderDetails;
import com.bloomberg.clustereddata.dto.OrderDetailsDto;
import com.bloomberg.clustereddata.respository.OrderDetailsRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */

@Transactional
public interface OrderDetailsService extends AbstractService<OrderDetails, String> {

	OrderDetailsRepository getRepository();

	OrderDetails getNewWithDefaults();

	OrderDetailsDto entity2DTO(OrderDetails entity);

	 Collection<OrderDetailsDto> entities2DTOs(Collection<OrderDetails> entities);

	OrderDetails dto2Entity(OrderDetailsDto dto);

     Collection<OrderDetails> dtos2Entities(Collection<OrderDetailsDto> dtos);
} 