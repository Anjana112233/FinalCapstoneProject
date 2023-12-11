package org.perscholas.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductFormBean {
    private Integer id;
    private String productName;
    private String productDescription;
    private String imageUrl;
    private Double price;

}
