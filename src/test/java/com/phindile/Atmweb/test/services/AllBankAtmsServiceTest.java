/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.services;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.atmm;
import com.phindile.atmweb.repository.ATMRepository;

import com.phindile.atmweb.services.AllBankAtmService;
import java.util.List;
import org.apache.derby.iapi.jdbc.ConnectionContext;
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
public class AllBankAtmsServiceTest {
    private static ApplicationContext ctx;
    private AllBankAtmService allatmservice;
    private ATMRepository atmrepo;
    
    public AllBankAtmsServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void AllAtmswithsamename()
    {
        allatmservice=ctx.getBean(AllBankAtmService.class);
      
    
        List<atmm> atm =allatmservice.getTotalAtmswithSameName();
         junit.framework.Assert.assertEquals("Expct No Customer",0, atm.size());
        
        
        
                     
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx =new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
