package org.perscholas.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderDetailFormBean {
    private Integer id;
    private Integer orderid;
    private Integer productid;
    private Integer quantityordered;
    private Double priceeach;



}
