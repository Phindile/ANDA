/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.repository;

import com.phindile.atmweb.app.config.ConnectionConfig;
//import com.phindile.atmweb.app.config.conn;
import com.phindile.atmweb.domain.Bank;
import com.phindile.atmweb.domain.Customer;
import com.phindile.atmweb.repository.BankRepository;
import java.util.List;
import junit.framework.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author chiry
 */
public class BankRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private BankRepository bankrepository;
    
    public BankRepositoryTest() {
        
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
    public void CreateBank(){
        bankrepository=ctx.getBean(BankRepository.class);
        Bank bank;
        bank=new Bank.Builder("SNB008498")
                .bank_name("STARNDARD BANK")
                .build(); 
        bankrepository.save(bank);
        id=bank.getId();
        Assert.assertNotNull(bank); 
    }
    @Test(dependsOnMethods="CreateBank")
    public void ReadBank(){
        bankrepository=ctx.getBean(BankRepository.class);
        Bank bank = bankrepository.findOne(id);
        Assert.assertEquals("STARNDARD BANK", bank.getBank_name());
       // Assert.assertEquals(null, null);
    }
    @Test(dependsOnMethods="ReadBank")
    public void UpdateBank(){
        bankrepository=ctx.getBean(BankRepository.class);
        Bank bank = bankrepository.findOne(id);
        Bank UpdatedBank = new Bank.Builder("343555")
                .bank(bank)
                .bank_name("FNB")
                .build();
          bankrepository.save(UpdatedBank);
          Bank newBank = bankrepository.findOne(id);
          Assert.assertEquals("FNB", newBank.getBank_name());   
    }
    @Test(dependsOnMethods="UpdateBank")
    public void DeleteBank(){
        
        bankrepository =ctx.getBean(BankRepository.class);
        Bank bank = bankrepository.findOne(id);
        bankrepository.delete(bank);
        Bank deletedbank = bankrepository.findOne(id);
        Assert.assertNull(deletedbank);
        
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
    }
}
