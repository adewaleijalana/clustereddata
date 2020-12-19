package com.bloomberg.clustereddata.respository;

import com.bloomberg.clustereddata.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @auther .: adewale.ijalana
 * @email ..: adewaleijalana@gmail.com
 * @created : 18/12/2020
 */

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {

    Optional<OrderDetails> findByDealId(String dealId);
}
