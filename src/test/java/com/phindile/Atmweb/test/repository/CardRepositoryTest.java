/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.Atmweb.test.repository;

import com.phindile.atmweb.app.config.ConnectionConfig;
import com.phindile.atmweb.domain.Card;
import com.phindile.atmweb.repository.CardRepository;
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
public class CardRepositoryTest {
    private static  ApplicationContext ctx;
    private CardRepository cardrepo;
    private Long id;
    
    
    public CardRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CreateCard()
    {
        cardrepo = ctx.getBean(CardRepository.class);
        
//        ATM atm=new ATM.Builder(756546)
//                .atmname("NedBank")
//                .build();
        Card card;
        card=new Card.Builder(35566)
                .Cardname("ABSA")
                .build();
        cardrepo.save(card);
        id =card.getId();
        Assert.assertNotNull(card);
    }
    @Test(dependsOnMethods="CreateCard")
    public void ReadCard()
    {
        cardrepo =ctx.getBean(CardRepository.class);
        Card card =cardrepo.findOne(id);
        Assert.assertEquals(card.getCard_name(),"ABSA");
    }
    @Test(dependsOnMethods="ReadCard")
    public void UpdateCard()
    {
        cardrepo =ctx.getBean(CardRepository.class);
        Card card = cardrepo.findOne(id);
//        ATM atm = new ATM.Builder(657466)
//                .atmname("ABSA")
//                .build();
        Card Updatedcard = new Card.Builder(7964)
                .card(card)
                .Cardname("StarndardBank")
                .build();
        cardrepo.save(Updatedcard);
        Card newcard =cardrepo.findOne(id);
        Assert.assertEquals(newcard.getCard_name(),"StarndardBank");
    }
    @Test(dependsOnMethods="UpdateCard")
    public void DeleteCard()
    {
        cardrepo =ctx.getBean(CardRepository.class);
        Card card =cardrepo.findOne(id);
        cardrepo.delete(card);
        Card deletedcard =cardrepo.findOne(id);
        Assert.assertNull(deletedcard);
        
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
