package com.ayoub.customerservice;

import com.ayoub.customerservice.entities.Customer;
import com.ayoub.customerservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepo customerRepo) {
        return args -> {
           /* customerRepo.save(Customer.builder()
                    .name("Jack")
                    .email("jack@gmail.com")
                    .build());
            customerRepo.save(Customer.builder()
                    .name("ayoub")
                    .email("ayoub@gmail.com")
                    .build());
            customerRepo.save(Customer.builder()
                    .name("yassine")
                    .email("yassine@gmail.com")
                    .build());*/
            customerRepo.save(new Customer(null,"Jack","jack@gmail.com"));
            customerRepo.save(new Customer(null,"Ayoub","ayoub@gmail.com"));
            customerRepo.save(new Customer(null,"Yassine","Yassine@gmail.com"));

            customerRepo.findAll().forEach(
                    c->{
                        System.out.println("==========================");
                        System.out.println(c.getId());
                        System.out.println(c.getName());
                        System.out.println(c.getEmail());
                    }
            );
        };
    }

}
