package org.example.warehouse10c.service;

import org.example.warehouse10c.dto.ProductDto;
import org.example.warehouse10c.model.Measurement;
import org.example.warehouse10c.model.Product;
import org.example.warehouse10c.model.Result;
import org.example.warehouse10c.repository.MeasurementRepository;
import org.example.warehouse10c.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MeasurementRepository measurementRepository;

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;

    }

    public Product getProduct(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }

    public Result createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode(productDto.getCode());
        product.setActive(productDto.isActive());
        Optional<Measurement> measurementOptional = measurementRepository.findById(productDto.getMeasurementId());
        Measurement measurement = measurementOptional.get();
        product.setMeasurement(measurement);
        productRepository.save(product);
        return new Result(true, "Successfully");
    }

    public Result updateProduct(Integer id, ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDto.getName());
            product.setCode(productDto.getCode());
            product.setActive(productDto.isActive());

            Optional<Measurement> measurementOptional = measurementRepository.findById(productDto.getMeasurementId());
            Measurement measurement = measurementOptional.get();
            product.setMeasurement(measurement);
            productRepository.save(product);

            return new Result(true, "Updated");
        }
        return new Result(false, "Product not found");
    }

    public Result deletedProduct(Integer id) {
        productRepository.deleteById(id);
        return new Result(true, "Deleted");
    }


}
