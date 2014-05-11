/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author chiry
 */
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Cust_fname;
    private String Cust_lname;
    private String ID_NO;
    private String pin;
    @OneToOne
    private Account account;
    @OneToOne
    private Card card;
    @Column(unique=true)
    private String Account_no;
    @Embedded
    private Contact con;
    
   
    private Customer(Builder builder)
    {
        this.Account_no=builder.Account_no;
        this.Cust_fname=builder.Cust_fname;
        this.ID_NO=builder.ID_NO;
        this.pin=builder.pin;
        this.id=builder.id;
        this.con=builder.con;
        
        
    }
    private Customer()
    {
        
    }
    public static class Builder{
    private Long id;
    private String Account_no;
    private String pin;
    private String Cust_fname;
    private String Cust_lname;
    private String ID_NO;
    private Contact con;
    
    
     public Builder (String val)
    {
        this.Account_no=val;
    }
    public Builder id(Long val){
        this.id=val;
        return this;
    }
    public Builder Contact(Contact val)
    {
        this.con=val;
        return this;
    }
   
    public Builder pin(String val){
        this.pin=val;
        return this;
    }
    public Builder FirstName(String val){
        this.Cust_fname=val;
        return this;
    }
    public Builder LastName(String val){
        this.Cust_lname=val;
              return this;
    }
    public Builder ID_NO(String val){
        this.ID_NO=val;
        return this;
    }
    
    public Builder Customer(Customer cust)
    {
        this.id=cust.getId();
        this.ID_NO=cust.getID_NO();
        this.Account_no=cust.Account_no;
        this.pin=cust.getPin();
        this.Cust_fname=cust.getCust_fname();
        this.Cust_lname=cust.getCust_lname();
        this.con=cust.getCon();
     
        return this;
    }
    
    public Customer build()
    {
        return new Customer(this);
    }
    
    }

    public Contact getCon() {
        return con;
    }
    
    

    public String getAccount_no() {
        return Account_no;
    }

    public String getPin() {
        return pin;
    }

    public String getCust_fname() {
        return Cust_fname;
    }

    public String getCust_lname() {
        return Cust_lname;
    }

    public String getID_NO() {
        return ID_NO;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.Customer[ id=" + id + " ]";
    }
    
}
