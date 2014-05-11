/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.repository;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.Account;
import com.phindile.atmweb.repository.AccountRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author chiry
 */
public class AccountRepositoryTest {
    
    private static  ApplicationContext ctx;
    private Long id;
    private AccountRepository accountrepo;
    
    
    public AccountRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CreateAccount()
    {
        accountrepo=ctx.getBean(AccountRepository.class);
        
        Account account;
                account = new Account.Builder(1234)
                          .Acc_typ("Savings")
                          .build();
                accountrepo.save(account);
                id = account.getId();
                Assert.assertNotNull(account);
            
    }
  @Test(dependsOnMethods="CreateAccount")
    public void readAccount()
    {
        accountrepo =ctx.getBean(AccountRepository.class);
        Account account =accountrepo.findOne(id);
        Assert.assertEquals("Savings",account.getAcc_type());
    }
   @Test(dependsOnMethods="readAccount")
    public void UpdateAccount()
    {
        accountrepo=ctx.getBean(AccountRepository.class);
        Account account = accountrepo.findOne(id);
        Account updatedAccount= new Account.Builder(3456)
                                .Account(account)
                                .Acc_typ("Check")
                                .availablebalance(230000.000)
                                .totalBal(400000.0000)
                                .pin(6574)
                                .build();
        
           accountrepo.save(updatedAccount);
           Account newAccount =accountrepo.findOne(id);
           Assert.assertEquals(newAccount.getAccount_number(),3456);
        
    }
//    @Test(dependsOnMethods="UpdateAccount")
//    public void DeleteAccount()
//    {
//        accountrepo =ctx.getBean(AccountRepository.class);
//        Account account = accountrepo.findOne(id);
//        accountrepo.delete(account);
//        Account deletedaccount =accountrepo.findOne(id);
//        Assert.assertNull(deletedaccount);
//    }

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
