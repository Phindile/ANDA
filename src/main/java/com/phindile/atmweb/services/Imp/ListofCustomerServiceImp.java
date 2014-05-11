/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.services.Imp;

import com.phindile.atmweb.domain.Customer;
import com.phindile.atmweb.repository.CustomerRepository;
import com.phindile.atmweb.services.ListOfCustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiry
 */
@Service
public class ListofCustomerServiceImp implements ListOfCustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public List<Customer> getNumberofCustomer(String name) {
        
         List<Customer> customers = new ArrayList<>();
         List<Customer> customer =customerRepository.findAll();
         
         for(Customer cust: customer)
         {
             if(cust.getCust_fname().equals(name))
             {
                 customers.add(cust);
             }
         }
        
        return customers;
        
    }
    
}
