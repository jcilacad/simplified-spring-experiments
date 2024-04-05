package com.projects.dockercomposesupport.service;

import com.projects.dockercomposesupport.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomer(Long id);

    Customer updateCustomer(Long id, Customer updatedCustomer);

    void deleteCustomer(Long id);
}
