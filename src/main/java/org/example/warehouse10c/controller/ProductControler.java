package org.example.warehouse10c.controller;


import org.example.warehouse10c.dto.ProductDto;
import org.example.warehouse10c.model.Product;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")


public class ProductControler {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/{id}")
    public Product getbyIdProduct(@PathVariable Integer id) {
        Product product = productService.getProduct(id);
        return product;
    }

    @PostMapping()
    public Result add(@RequestBody ProductDto productDto) {
        Result result = productService.createProduct(productDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        Result result = productService.updateProduct(id, productDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id) {
        Result result = productService.deletedProduct(id);
        return result;
    }


}
