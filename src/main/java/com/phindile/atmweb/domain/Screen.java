/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author chiry
 */
@Embeddable
public class Screen {
    
    public void DisplayMessage(String message)
    {
        System.out.println(message);
        
    }
    public void displayMessageLine(String message)
    {
        System.out.println(message);
    }
    
    public void displayDollarAmmount(double amount){
        System.out.printf("$%,.2",amount);
    }
    
}
