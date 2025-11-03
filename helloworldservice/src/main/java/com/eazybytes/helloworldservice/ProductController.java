package com.eazybytes.helloworldservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @GetMapping(value = "/product")
    public String gettingProduct() {
        List<Object> products = productService.getAllProducts();
        System.out.println(products);

        if (products.isEmpty()) {
            return String.valueOf(new ResponseEntity<>(products, HttpStatus.OK));
        }


        return String.valueOf(new ResponseEntity<>(products, HttpStatus.CREATED));
    }
}

