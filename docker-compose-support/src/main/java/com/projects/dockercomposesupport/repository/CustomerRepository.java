package com.projects.dockercomposesupport.repository;

import com.projects.dockercomposesupport.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
