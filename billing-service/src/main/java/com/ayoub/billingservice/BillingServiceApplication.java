package com.ayoub.billingservice;

import com.ayoub.billingservice.entities.Bill;
import com.ayoub.billingservice.entities.ProductItem;
import com.ayoub.billingservice.entities.model.Customer;
import com.ayoub.billingservice.entities.model.Product;
import com.ayoub.billingservice.feign.CustomerRestClient;
import com.ayoub.billingservice.feign.ProductRestClient;
import com.ayoub.billingservice.repository.BillRepo;
import com.ayoub.billingservice.repository.ProductItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepo billRepo ,
                                        ProductItemRepo productItemRepo,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        Collection<Customer> customers = customerRestClient.findAllCustomer().getContent();
        Collection<Product> products = productRestClient.getAllProduct().getContent();
        return args -> {
            customers.forEach(customer -> {
                Bill bill = new Bill(null,new Date(),customer.getId(),null,null);
                billRepo.save(bill);
                products.forEach(product -> {
                    ProductItem productItem = new ProductItem(null,product.getId(),bill,1+new Random().nextInt(10),product.getPrix(),null);
                    productItemRepo.save(productItem);
                });
            });


        };
    }
}
