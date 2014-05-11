/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.services;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.Customer;
import com.phindile.atmweb.repository.CustomerRepository;
import com.phindile.atmweb.services.ListOfCustomerService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author chiry
 */
public class ListOfCustomerServicesTest {
    private CustomerRepository customerRepository;
    private ListOfCustomerService listcustservices;
    private static ApplicationContext ctx;
    
    
    
    public ListOfCustomerServicesTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void ListofCustomerfortheSameName()
    {
        listcustservices =ctx.getBean(ListOfCustomerService.class);
        customerRepository=ctx.getBean(CustomerRepository.class);
        Customer cust1 = new Customer.Builder("7535")
                            .FirstName("Siyamtanda")
                            .build();
        Customer cust2 = new Customer.Builder("7645")
                            .FirstName("Pindile")
                            .build();
        Customer cust3 = new Customer.Builder("7635")
                            .FirstName("Siyamtanda")
                            .build();
        customerRepository.save(cust1);
        customerRepository.save(cust3);
        customerRepository.save(cust3);
        
        List<Customer> cust =listcustservices.getNumberofCustomer("Siyamthanda");
        Assert.assertEquals(cust.size(), 2);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        customerRepository =ctx.getBean(CustomerRepository.class);
        customerRepository.deleteAll();
    }
}
