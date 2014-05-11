/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.services;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.Account;
import com.phindile.atmweb.repository.AccountRepository;
import com.phindile.atmweb.services.AccountBalanceService;
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
public class AccountBalanceAboveTest {
    private AccountRepository accountRepository;
    private AccountBalanceService accservice;
    private static ApplicationContext ctx;
    
    public AccountBalanceAboveTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void BalanceAbove()
    {
        accountRepository=ctx.getBean(AccountRepository.class);
        accservice =ctx.getBean(AccountBalanceService.class);
        
        Account acc1 =new Account.Builder(1234)
                                 .totalBal(200.00)
                                 .build();
        Account acc2 =new Account.Builder(65638)
                                 .totalBal(600.00)
                                 .build();
        Account acc3 =new Account.Builder(8757)
                                 .totalBal(700.000)
                                 .build();
        accountRepository.save(acc1);
        accountRepository.save(acc2);
        accountRepository.save(acc3);
        
        List<Account> acco =accservice.getBalanceAbove(100.00);
        //Assert.assertEquals(acco.size(),3);
        //Assert.assertEquals(acco.size(),3);
                
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
//    /*    accountRepository= ctx.getBean(AccountRepository.class);
//        accountRepository.deleteAll();
//        
    }
}
