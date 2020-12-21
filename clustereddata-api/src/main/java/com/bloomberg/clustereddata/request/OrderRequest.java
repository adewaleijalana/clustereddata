package com.bloomberg.clustereddata.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

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
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date orderingTime;

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
