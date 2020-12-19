package com.bloomberg.clustereddata.controller;

import com.bloomberg.clustereddata.domain.OrderDetails;
import com.bloomberg.clustereddata.exception.ProcessingException;
import com.bloomberg.clustereddata.request.OrderRequest;
import com.bloomberg.clustereddata.response.OrderResponse;
import com.bloomberg.clustereddata.service.main.XOrderDetailsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */

@Slf4j
@RestController
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestMapping(value = "/api")
public class OrderController {

    private static final String MAKE_FX_ORDER = "/order";

    private final Gson gson;
    private final XOrderDetailsService xOrderDetailsService;

    public OrderController(XOrderDetailsService xOrderDetailsService) {
        this.xOrderDetailsService = xOrderDetailsService;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @RequestMapping(value = MAKE_FX_ORDER, method = RequestMethod.POST)
    ResponseEntity<OrderResponse> createFXOrder(@Valid @RequestBody OrderRequest orderRequest){
        log.info("incoming FX order request: \n{}", gson.toJson(orderRequest));
        OrderResponse orderResponse = xOrderDetailsService.createFXOrder(orderRequest)
        .orElseThrow(() -> new ProcessingException("ERROR PROCESS FX ORDER"));
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

}
