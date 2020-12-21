package com.bloomberg.clustereddata.service.main;

import com.bloomberg.clustereddata.request.OrderRequest;
import com.bloomberg.clustereddata.response.OrderResponse;
import com.bloomberg.clustereddata.respository.OrderDetailsRepository;
import com.bloomberg.clustereddata.service.gen.OrderDetailsService;
import com.bloomberg.clustereddata.service.gen.impl.OrderDetailsServiceImpl;
import com.bloomberg.clustereddata.service.main.impl.XOrderDetailsServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com, adewale.ijalana@xpresspayments.com
 * @created : 19/12/2020
 */
@ExtendWith(MockitoExtension.class)
class XOrderDetailsServiceTest {

    @InjectMocks
    private OrderDetailsServiceImpl orderDetailsService;

    @Mock
    private OrderDetailsRepository repository;

    @InjectMocks
    private XOrderDetailsServiceImpl xOrderDetailsService;


    @Before
    private void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void createFXOrder() {

        OrderResponse response = OrderResponse.builder()
                .responseMessage("00")
                .responseMessage("Successful")
                .build();
/*

        given(orderDetailsService.getRepository().findByDealId(eq("Test")))
                .willReturn(any());
*/

        OrderRequest request = OrderRequest.builder().build();

        given(xOrderDetailsService.createFXOrder(request))
                .willReturn(Optional.of(response));

        verify(xOrderDetailsService.createFXOrder(any()), times(1));

    }
}