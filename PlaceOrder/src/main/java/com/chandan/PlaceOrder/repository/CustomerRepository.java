package com.chandan.PlaceOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chandan.PlaceOrder.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
