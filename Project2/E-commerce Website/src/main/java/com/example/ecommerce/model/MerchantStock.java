package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class MerchantStock {

    @NotEmpty(message = "Id must not be empty!")
    @Size(min = 3, message = "Id have to be 3 character long")
    private String id;

    @NotEmpty(message = "productId must not be empty!")
    @Size(min = 3, message = "productId have to be 3 character long")
    private String productId;

    @NotEmpty(message = "merchantId must not be empty!")
    @Size(min = 3, message = "merchantId have to be 3 character long")
    private String merchantId;

    @NotNull(message = "Stock must not be empty!")
    @Min(value = 10 , message = "Stock have to be more than 10 at start")
    private Integer stock;
}
