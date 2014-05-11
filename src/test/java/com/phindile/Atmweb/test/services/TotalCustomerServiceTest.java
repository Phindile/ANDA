/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.services;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.Customer;
import com.phindile.atmweb.services.TotalCustomerService;
import java.util.List;
import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class TotalCustomerServiceTest {
    private static ApplicationContext ctx;
    private TotalCustomerService custservice;
    
    
    public TotalCustomerServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TotalCustomers()
    {
        custservice=ctx.getBean(TotalCustomerService.class);
        List<Customer> customers = custservice.getTotalCustomer();
        Assert.assertEquals("Expct No Customer",0, customers.size());
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx=new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
