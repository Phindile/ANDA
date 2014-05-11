/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.services.Imp;

import com.phindile.atmweb.domain.Customer;
import com.phindile.atmweb.repository.CustomerRepository;
import com.phindile.atmweb.services.TotalCustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiry
 */
@Service
public class TotalCustomerServiceImp  implements TotalCustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getTotalCustomer() {
        return customerRepository.findAll(); 
    }
    
}
