package org.perscholas.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.Product;

@Getter
@Setter
public class CreateOrderDetailFormBean {
    private Integer id;
    private Integer orderid;
    private Integer productid;
    private Integer quantityordered;
    private Double priceeach;
    private Order order;
    private Product product;




}
