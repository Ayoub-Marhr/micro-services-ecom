package com.ayoub.billingservice.web;

import com.ayoub.billingservice.entities.Bill;
import com.ayoub.billingservice.entities.ProductItem;
import com.ayoub.billingservice.feign.CustomerRestClient;
import com.ayoub.billingservice.feign.ProductRestClient;
import com.ayoub.billingservice.repository.BillRepo;
import com.ayoub.billingservice.repository.ProductItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private ProductRestClient productRestClient;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductItemRepo productItemRepo;
    @Autowired
    private BillRepo billRepo;
    @GetMapping("Bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepo.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;
    }
}
