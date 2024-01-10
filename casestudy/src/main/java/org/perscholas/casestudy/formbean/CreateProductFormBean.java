package org.perscholas.casestudy.formbean;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateProductFormBean {
    private Integer id;

    @NotEmpty(message = "Product Name is required.")
    @Length(max = 45, message = " Name must be less than 45 characters.")
    private String productName;

    @NotEmpty(message = "Product Name is required.")
    @Length(max = 1000, message = "product description must be less than 1000 characters.")
    private String productDescription;

    @Length(max = 1000, message = "imageURL must be less than 1000 characters.")
    private String imageUrl;

    @NotNull(message = "price is required.")
    private Double price;

}
