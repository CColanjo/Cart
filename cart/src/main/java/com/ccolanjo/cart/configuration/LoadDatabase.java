package com.ccolanjo.cart.configuration;

import com.ccolanjo.cart.entity.Product;
import com.ccolanjo.cart.entity.ShoppingList;
import com.ccolanjo.cart.repository.ProductRepository;
import com.ccolanjo.cart.repository.ShoppingListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repositoryProduct, ShoppingListRepository repositoryList) {
        return args -> {
            log.info("Preloading " + repositoryProduct.save(new Product("Coca cola")));
            log.info("Preloading " + repositoryProduct.save(new Product("Arroz")));
            log.info("Preloading " + repositoryList.save(new ShoppingList(Long.parseLong("1"),"Coca cola",2 , false)));
            log.info("Preloading " + repositoryList.save(new ShoppingList(Long.parseLong("2"),"Arroz", 3, false)));
        };
    }
}
