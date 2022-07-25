package com.github.fernandocchaves.architecture.customer.domain.repository;

import com.github.fernandocchaves.architecture.customer.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
