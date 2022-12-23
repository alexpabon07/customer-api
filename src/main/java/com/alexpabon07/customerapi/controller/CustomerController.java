package com.alexpabon07.customerapi.controller;

import com.alexpabon07.customerapi.model.Customer;
import com.alexpabon07.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable(value = "id") int id) {
        return customerRepository.findById(id);
    }

    @PostMapping("/customer/add")
    public Customer saveCostumer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") int id, @RequestBody Customer customer) {
        Customer updateCustomer = customerRepository.findById(id)
                .orElse(new Customer());

        if (updateCustomer != null) {
            updateCustomer.setName(customer.getName());
            updateCustomer.setLastName(customer.getLastName());
            updateCustomer.setEmail(customer.getEmail());
            return customerRepository.save(updateCustomer);
        } else {
            return customerRepository.save(customer);
        }
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable(value = "id") int id) {
        customerRepository.deleteById(id);
    }
}
