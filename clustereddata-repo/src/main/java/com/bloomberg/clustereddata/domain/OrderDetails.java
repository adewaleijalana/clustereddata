package com.bloomberg.clustereddata.domain;

import com.bloomberg.clustereddata.domain.xtras.AbstractBaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_details")
@EqualsAndHashCode(callSuper = false)
public class OrderDetails extends AbstractBaseEntity implements java.io.Serializable{

    @Column(name="deal_id", nullable=false)
    private String dealId;

    @Column(name="ordering_currency", nullable=false)
    private String orderingCurrency;

    @Column(name="to_currency", nullable=false)
    private String toCurrency;

    @Column(name="amount", nullable=false)
    private BigDecimal amount;

}
