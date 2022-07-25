package com.github.fernandocchaves.architecture.customer.domain.repository;

import com.github.fernandocchaves.architecture.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
