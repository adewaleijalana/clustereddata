package com.bloomberg.clustereddata.service.main;


import com.bloomberg.clustereddata.exception.ModelAlreadyExistException;
import com.bloomberg.clustereddata.request.OrderRequest;
import com.bloomberg.clustereddata.response.OrderResponse;

import java.util.Optional;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */
public interface XOrderDetailsService {

    Optional<OrderResponse> createFXOrder(OrderRequest orderRequest) throws ModelAlreadyExistException;

}
