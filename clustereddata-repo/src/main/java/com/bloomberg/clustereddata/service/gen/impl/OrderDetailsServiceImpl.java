package com.bloomberg.clustereddata.service.gen.impl;



import com.bloomberg.clustereddata.domain.OrderDetails;
import com.bloomberg.clustereddata.dto.OrderDetailsDto;
import com.bloomberg.clustereddata.respository.OrderDetailsRepository;
import com.bloomberg.clustereddata.service.gen.OrderDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
@Transactional
public class OrderDetailsServiceImpl extends AbstractServiceImpl<OrderDetails, String>
		implements OrderDetailsService {

		private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailsServiceImpl.class);

	    @Autowired
	    private OrderDetailsRepository repository;

	    public OrderDetailsServiceImpl() {
	        super(OrderDetails.class);
	    }
	
	
	    @Override
	    public OrderDetailsRepository getRepository() {
	        return repository;
	    }
	
	    public OrderDetails findByIDWithRef(String id) {
	        return repository.findById(id).get();
	    }
	
	    /******************************
	     * Queries and special methods ***************
	     **************************************************************************/
	    @Override
	    public OrderDetails getNewWithDefaults() {
	        return new OrderDetails();
	    }

		@Override
		public OrderDetailsDto entity2DTO(OrderDetails entity) {

			OrderDetailsDto dto = OrderDetailsDto.builder()
					.id(entity.getId())
					.dealId(entity.getDealId())
					.orderingCurrency(entity.getOrderingCurrency())
					.toCurrency(entity.getToCurrency())
					.orderingTime(entity.getOrderTime())
					.amount(entity.getAmount())
				.build();
			return dto;

		}


		@Override
		public Collection<OrderDetailsDto> entities2DTOs(Collection<OrderDetails> entities) {
			Collection<OrderDetailsDto> dtos =
			entities.stream().map(this::entity2DTO).collect(Collectors.toCollection(ArrayList::new));
			return dtos;
        }

        @Override
        public OrderDetails dto2Entity(OrderDetailsDto dto) {
			OrderDetails one = repository.findById(dto.getId()).get();
        	return one;
        }

        @Override
        public Collection<OrderDetails> dtos2Entities(Collection<OrderDetailsDto> dtos) {
            Collection<OrderDetails> entities =
            dtos.stream().map(this::dto2Entity).collect(Collectors.toList());
            return entities;
		}

}