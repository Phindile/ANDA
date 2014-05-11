/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.repository;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.CardReader;
import com.phindile.atmweb.repository.CardReaderRepository;
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
public class CardReaderRepositoryTest {
    private static ApplicationContext ctx;
    private CardReaderRepository cardreaderepo;
    private Long id;
    
    public CardReaderRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CreateCardReader()
    {
        cardreaderepo =ctx.getBean(CardReaderRepository.class);
        CardReader card_r;
        card_r = new CardReader.Builder("123456")
                .atm_name_cardr("ABSA")
                .builder();
        cardreaderepo.save(card_r);
        id=card_r.getId();
        Assert.assertNotNull(card_r);
    }
    @Test(dependsOnMethods="CreateCardReader")
    public void ReadCardReader()
    {
        cardreaderepo =ctx.getBean(CardReaderRepository.class);
        CardReader card_r =cardreaderepo.findOne(id);
        Assert.assertEquals(card_r.getAtm(), "ABSA");
        
    }
    @Test(dependsOnMethods="ReadCardReader")
    public void UpdateCardReader()
    {
        cardreaderepo =ctx.getBean(CardReaderRepository.class);
        CardReader card_r =cardreaderepo.findOne(id);
        CardReader updatedcard = new CardReader.Builder("23445")
                   .CardReader(card_r)
                   .atm_name_cardr("CAPITEC")
                   .builder();
        cardreaderepo.save(updatedcard);
        CardReader newreader=cardreaderepo.findOne(id);
        Assert.assertEquals(newreader.getAtm(),"CAPITEC");
    }
    @Test(dependsOnMethods="UpdateCardReader")
    public void DeleteCardReader()
    {
        cardreaderepo = ctx.getBean(CardReaderRepository.class);
        CardReader card_r = cardreaderepo.findOne(id);
        cardreaderepo.delete(card_r);
        CardReader deletedcardreader = cardreaderepo.findOne(id);
        Assert.assertNull(deletedcardreader);
        
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
