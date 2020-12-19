package com.bloomberg.clustereddata.domain.xtras;

import java.io.Serializable;
import java.time.ZonedDateTime;


public interface AbstractEntity<PK extends Serializable> {


    /**
     * @return the primary key as String
     */
    String getIdx();

    /**
     * @returnn
     */
    PK getPk();


    String getIde();

    /**
     * Helper method to know whether the primary key is set or not.
     *
     * @return true if the primary key is set, false otherwise
     */
    boolean isIdSet();


    String getId();

    void setId(String Id);

    ZonedDateTime getOrderDate();

    void setOrderDate(ZonedDateTime createdDate);


}
