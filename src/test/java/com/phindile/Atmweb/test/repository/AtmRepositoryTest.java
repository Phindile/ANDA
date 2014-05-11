/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.repository;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.atmm;
import com.phindile.atmweb.repository.ATMRepository;
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
public class AtmRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private ATMRepository atmrepo;
    
    
    public AtmRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CreateATM()
    {
        atmrepo=ctx.getBean(ATMRepository.class);
        atmm atm;
        atm = new atmm.Builder(307255)
                .atmname("SARNDARD BANK ATM")
                .Loctation("6574 Observatory Rochester")
                .build();
        
        atmrepo.save(atm);
        id=atm.getId();
      Assert.assertNotNull(atm);
    }
    @Test(dependsOnMethods="CreateATM")
    public void ReadATM()
    {
        atmrepo=ctx.getBean(ATMRepository.class);
        atmm atm =atmrepo.findOne(id);
        Assert.assertEquals(atm.getAtm_code(),307255);
    }
    @Test(dependsOnMethods="ReadATM")
    public void UpdateATM()
    {
        atmrepo =ctx.getBean(ATMRepository.class);
        atmm atm = atmrepo.findOne(id);
        atmm updatedatm =new atmm.Builder(30893)
                .atmm(atm)
                .atmname("FNB BANK ATM")
                .build();
        atmrepo.save(updatedatm);
        atmm newatm =atmrepo.findOne(id);
       Assert.assertEquals(newatm.getAtm_code(),307255);
    }
    @Test(dependsOnMethods="UpdateATM")
    public void DeleteATM()
    {
        atmrepo =ctx.getBean(ATMRepository.class);
        atmm atm =atmrepo.findOne(id);
        atmrepo.delete(atm);
        atmm deletedbank = atmrepo.findOne(id);
        Assert.assertNull(deletedbank); 
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx= new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
