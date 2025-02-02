package com.ayoub.billingservice.repository;

import com.ayoub.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductItemRepo extends JpaRepository<ProductItem, Long> {
}
