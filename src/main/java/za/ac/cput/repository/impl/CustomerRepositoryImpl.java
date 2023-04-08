package za.ac.cput.repository.impl;


/*
This is a Customer Class
Author @Ndumiso Nkululeko Ngcobo
Date: 07-04-2023
Student Number: 220094861
 */

import za.ac.cput.domain.Customer;

import za.ac.cput.repository.iCustomerRepository;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepositoryImpl implements iCustomerRepository {
    private static CustomerRepositoryImpl customerRepository = null;
    private Set <Customer> customerDB = null;

    private CustomerRepositoryImpl(){
        customerDB = new HashSet<Customer>();
    }

    public static CustomerRepositoryImpl getCustomerRepository(){
        if (customerRepository == null){
            customerRepository = new CustomerRepositoryImpl();
        }
        return customerRepository;
    }
    @Override
    public Customer create(Customer customer) {
        boolean success = customerDB.add(customer);
        System.out.println("Customer: " + customerDB );
        if(!success)
            return null;
        return customer;
    }

    @Override
    public Customer read(String customerId) {
        Customer customer  = customerDB.stream()
                .filter(customer1 -> customer1.getCustomerId()
                        .equals(customerId))
                .findAny()
                .orElse(null);

        return null;
    }

    @Override
    public Customer update(Customer customer) {
        Customer updateCustomer = read(customer.getCustomerId());
        if (updateCustomer !=null){
            customerDB.remove(updateCustomer);
            customerDB.add(customer);

        }
        return null;
    }

    @Override
    public boolean delete(String customerId) {
        Customer deleteCustomer = read(customerId);
        if (deleteCustomer==null)

            return false;
        customerDB.remove(deleteCustomer);
        return true;
    }



    @Override
    public Set<Customer> getAll() {
        return null;
    }
}
