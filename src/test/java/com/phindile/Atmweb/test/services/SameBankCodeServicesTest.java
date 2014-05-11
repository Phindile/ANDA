/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.services;


import com.phindile.atmweb.domain.atmm;
import com.phindile.atmweb.repository.ATMRepository;
import com.phindile.atmweb.services.SameBankCodeService;
import java.util.List;
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
public class SameBankCodeServicesTest {
    private SameBankCodeService sameATM;
    private ATMRepository atmrepository;
    private static ApplicationContext ctx;
    
    
    public SameBankCodeServicesTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void SameAtmCode()
    {
        //sameATM =ctx.getBean(SameBankCodeService.class);
        sameATM=ctx.getBean(SameBankCodeService.class);
        atmrepository =ctx.getBean(ATMRepository .class);
        
         atmm atm1 = new atmm.Builder(12345)
                      .build();
         atmm atm2 = new atmm.Builder(12345)
                      .build();
         atmm atm3 = new atmm.Builder(1235)
                      .build();
         atmm atm4 = new atmm.Builder(1345)
                      .build();
          atmrepository.save(atm1);
          atmrepository.save(atm2);
          atmrepository.save(atm3);
          atmrepository.save(atm4);
          
          List<atmm> atms = sameATM.getSameAtmBankCode(12345);
          Assert.assertEquals(atms.size(),2,"These Are The ATMS with The same CODE!!!!");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
       ctx= new AnnotationConfigApplicationContext(ATMRepository.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

   
    @AfterMethod
    public void tearDownMethod() throws Exception {
        atmrepository=ctx.getBean(ATMRepository.class);
        atmrepository.deleteAll();
    }
}
