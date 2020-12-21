package com.bloomberg.clustereddata.service.main.impl;

import com.bloomberg.clustereddata.domain.OrderDetails;
import com.bloomberg.clustereddata.exception.ModelAlreadyExistException;
import com.bloomberg.clustereddata.request.OrderRequest;
import com.bloomberg.clustereddata.response.OrderResponse;
import com.bloomberg.clustereddata.service.gen.OrderDetailsService;
import com.bloomberg.clustereddata.service.main.XOrderDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */
@Slf4j
@Service
public class XOrderDetailsServiceImpl implements XOrderDetailsService {

    private final OrderDetailsService orderDetailsService;

    public XOrderDetailsServiceImpl(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @Override
    public Optional<OrderResponse> createFXOrder(OrderRequest orderRequest) throws ModelAlreadyExistException{

        log.info("validating deal ID");
        orderDetailsService.getRepository()
                .findByDealId(orderRequest.getDealId())
                .ifPresent(s -> {throw new ModelAlreadyExistException(orderRequest.getDealId() + " already exist");});

        OrderDetails orderDetails = OrderDetails.builder()
                .dealId(orderRequest.getDealId())
                .orderingCurrency(orderRequest.getOrderingCurrency())
                .toCurrency(orderRequest.getToCurrency())
                .orderTime(new Date())
                .amount(orderRequest.getAmount())
                .build();

        log.info("saving FX Order details");

        OrderDetails savedOrderDetails =
                orderDetailsService.saveNew(orderDetails);
        if (null == savedOrderDetails)
            return Optional.empty();
        else
            return Optional.of(OrderResponse.builder()
                    .responseCode("00")
                    .responseMessage("FX Order Successful")
                    .build());
    }
}
