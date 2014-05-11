/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.repository;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.Contact;
import com.phindile.atmweb.domain.Customer;
import com.phindile.atmweb.repository.CustomerRepository;
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
public class CustomerRepositoryTest {
    CustomerRepository customerrepo;
    private Long id;
    private static ApplicationContext ctx;
    
    public CustomerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
   @Test
   public void CreateCustomer()
   {
       customerrepo=ctx.getBean(CustomerRepository.class);
       Contact con=new Contact.Builder("7554")
               .Address("Crossy")
               .Cell("0595755")
               .landline("095775-85775")
               .build();
       Customer cust;
       cust =new Customer.Builder("57994")
               .FirstName("Phindile")
               .ID_NO("906958747443")
               .LastName("Mposwa")
               .pin("7534")
               .Contact(con)
               .build();
       customerrepo.save(cust);
       id=cust.getId();
       Assert.assertNotNull(cust);   
   }
   @Test(dependsOnMethods="CreateCustomer")
   public void ReadCustomer()
   {
       customerrepo=ctx.getBean(CustomerRepository.class);
       Customer cust = customerrepo.findOne(id);
       Assert.assertEquals(cust.getCust_fname(),"Phindile");
   }
   @Test(dependsOnMethods="ReadCustomer")
   public void UpdateCustomer(){
       customerrepo=ctx.getBean(CustomerRepository.class);
       Customer cust =customerrepo.findOne(id);
        Customer updatedCustomer = new Customer.Builder("8574734")
               .Customer(cust)
               .ID_NO("8455644")
               .build();
        customerrepo.save(updatedCustomer);
        Customer newCust = customerrepo.findOne(id);
        Assert.assertEquals(newCust.getID_NO(), "8455644");
   }
   @Test(dependsOnMethods="UpdateCustomer")
  public void DeleteCustomer(){
       customerrepo=ctx.getBean(CustomerRepository.class);
       Customer cust =customerrepo.findOne(id);
       customerrepo.delete(cust);
       Customer deletedcustomer = customerrepo.findOne(id);
       Assert.assertNull(deletedcustomer);
               
    
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
