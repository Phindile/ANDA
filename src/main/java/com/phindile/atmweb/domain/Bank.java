/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author chiry
 */
@Entity
public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bank_name;
    @Column(unique=true)
    private String bank_code;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="bank_name")
    List<atmm>atm;
    @OneToMany
    @JoinColumn(name="bank_code")   
    List<Customer> cust;
    private Bank(Builder builder)
    {
        id=builder.id;
        bank_name=builder.bank_name;
        bank_code=builder.bank_code;
        cust= builder.cust;
        atm =builder.atm;
        
    }
    private Bank()
    {
        
    }
    public static class Builder{
    private Long id;
    private String bank_name;
    private String bank_code;
    List< Customer>cust;
    List<atmm>atm;
    
    public Builder(String val)
    {
        this.bank_code=val;
        
    }
    public Builder ccust(List<Customer> val)
    {
        this.cust=val;
        return this;
    }
    public Builder atm(List<atmm> atm)
    {
        this.atm=atm;
        return this;
    }
    public Builder bank_name(String val)
    {
        this.bank_name=val;
        return this;
    }
    public Builder id(Long val)
    {
        this.id=val;
        return this;
    }
   
    
    public Builder bank(Bank bank)
    {
        id=bank.getId();
        bank_code=bank.getBank_code();
        bank_name=bank.getBank_name();
        cust=bank.getCust();
        atm=bank.getAtm();
        return this;
    }
    public Bank build(){
        return new Bank(this);
    }

      
    
    }

    public List<atmm> getAtm() {
        return atm;
    }
    

    public List<Customer> getCust() {
        return cust;
    }
    

    public String getBank_name() {
        return bank_name;
    }

    public String getBank_code() {
        return bank_code;
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
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.Bank[ id=" + id + " ]";
    }
    
}
