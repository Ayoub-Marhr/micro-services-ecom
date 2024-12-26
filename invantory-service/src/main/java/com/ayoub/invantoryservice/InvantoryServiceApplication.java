package com.ayoub.invantoryservice;

import com.ayoub.invantoryservice.entities.Product;
import com.ayoub.invantoryservice.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InvantoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvantoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepo productRepo) {
        return args -> {
            productRepo.save(new Product(null, "casque", 199.0, 19));
            productRepo.save(new Product(null, "sourie", 299.9, 50));
            productRepo.save(new Product(null, "monitor", 1999.9, 15));

            productRepo.findAll().forEach(System.out::println);
        };
    }
}
