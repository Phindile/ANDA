/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author chiry
 */
@Embeddable
public class Contact implements Serializable{
   private String landline;
    private String address;
    private String email;
    private String cell;
    
    
    private Contact(Builder builder)
    {
       landline=builder.landline;
       address=builder.address;
       email=builder.email;
       cell=builder.cell;
        
    }
    private Contact()
    {
        
    }
    public static class Builder{
    private String landline;
    private String email;
    private String address;
    private String cell;
    
    public Builder (String value)
    {
        this.email=value;
        
    }
    public Builder landline(String val)
    {
        this.landline=val;
        return this;
    }
    public Builder Cell(String cell)
    {
        this.cell=cell;
        return this;
    }
    public Builder Address(String address)
    {
        this.address=address;
        return this;
    }
    public Contact build()
    {
        return new Contact(this);
    }
        
        
    }
    

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }
    
      
    
    
}
