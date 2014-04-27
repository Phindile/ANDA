/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author chiry
 */
@Entity
public class Money implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long cents;
    private int dollars;
    
    private Money(Builder builder)
    {
        this.cents=builder.cents + builder.dollars;
        this.dollars=builder.dollars;
        this.id=builder.id;
     
    }
    
    public Money()
    {
        
    }
    
    public static class Builder{
       private Long id;
       private Long cents;
       private int dollars;
     
        
       public Builder id(Long val)
       {
           this.id=val;
           return this;
       }
       public Builder Cents(int val)
       {
           this.dollars=val;
           return this;
       }
       public Builder dollars(int val)
       {
           this.dollars=val;
           return this;
       }
       public Money builder()
       {
           return new Money(this);
       }
       
        
    }

    public Long getCents() {
        return cents;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDollars() {
        return dollars;
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
        if (!(object instanceof Money)) {
            return false;
        }
        Money other = (Money) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.Money[ id=" + id + " ]";
    }
    
}
