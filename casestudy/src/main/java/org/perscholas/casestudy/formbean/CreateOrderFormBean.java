package org.perscholas.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CreateOrderFormBean {
    private Integer id;
    private Integer userid;
    private Timestamp orderdate;
    private Timestamp requireddate;
    private Timestamp shippeddate;
    private String status;
}
