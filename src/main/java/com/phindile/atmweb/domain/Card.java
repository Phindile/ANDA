/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author chiry
 */
@Entity
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private int Card_Number;
    
    private Card(){   
    }
    private Card(Builder builder)
    {
        this.id=builder.id;
        this.Card_Number=builder.Card_Number;
    }
    public static class Builder{
        private  int Card_Number;
        private Long id;
        
       public Builder id(Long val)
       {
           this.id=val;
           return this;
       }
       public Builder Card_number(int val)
       {
           this.Card_Number=val;
           return this;
       } 
       public Card builder()
       {
           return new Card(this);
       }
    }
    
    public Long getId() {
        return id;
    }

    public int getCard_Number() {
        return Card_Number;
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
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.Card[ id=" + id + " ]";
    }
    
}
