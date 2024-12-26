package com.ayoub.billingservice.repository;

import com.ayoub.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface BillRepo extends JpaRepository<Bill, Long> {
}
