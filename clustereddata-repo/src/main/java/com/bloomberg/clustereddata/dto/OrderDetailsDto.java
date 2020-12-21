package com.bloomberg.clustereddata.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto implements Serializable{

    private static final long serialVersionUID = -2350838876566947902L;

    private String id;
    private String dealId;
    private String orderingCurrency;
    private String toCurrency;
    private ZonedDateTime orderingTime;
    private BigDecimal amount;

}
