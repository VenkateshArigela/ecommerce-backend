package com.ecommerce.ecommercebackend.dto;

import jakarta.validation.constraints.*;

public class ProductDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}