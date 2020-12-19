package com.bloomberg.clustereddata.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest implements Serializable {

    private static final long serialVersionUID = -5443886491808337816L;

    @NotEmpty
    private String dealId;

    @NotEmpty
    private String orderingCurrency;

    @NotEmpty
    private String toCurrency;

    @NotEmpty
    private String orderingTime;

    @NotNull
    private BigDecimal amount;

    @Override
    public String toString() {
        return "OrderRequest{" +
                "dealId='" + dealId + '\'' +
                ", orderingCurrency='" + orderingCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", orderingTime='" + orderingTime + '\'' +
                ", amount=" + amount +
                '}';
    }
}
