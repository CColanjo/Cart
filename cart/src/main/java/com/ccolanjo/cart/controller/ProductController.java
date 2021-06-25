package com.ccolanjo.cart.controller;

import com.ccolanjo.cart.entity.Product;
import com.ccolanjo.cart.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    List<Product> getAllProducts(){ return productRepository.findAll(); }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable long id){
        productRepository.deleteById(id);
    }

    @GetMapping("/findProductApi")
    List<Product> findProductApi(@RequestParam String description) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl
                = "https://taco-food-api.herokuapp.com/api/v1/food";

        ResponseEntity<Product[]> response =  restTemplate
                .getForEntity(resourceUrl, Product[].class);

        List<Product> products = Arrays.asList(response.getBody());
        return  products.stream().filter(p -> p.getDescription().contains(description)).collect(Collectors.toList());
    }
}
