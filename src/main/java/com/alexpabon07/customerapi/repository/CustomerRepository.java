package com.alexpabon07.customerapi.repository;

import com.alexpabon07.customerapi.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
