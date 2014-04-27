/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author chiry
 */
@Embeddable
public class CardReader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Atm atm;
   @OneToMany(cascade = CascadeType.ALL)
    private Card card;
   
    
    private CardReader(Builder builder)
    {
        this.atm=builder.atm;
        this.id=builder.id;
        this.card=builder.card;
        
    }
     private CardReader()  
     {
         
     }
     public static class Builder{
         private Long id;
         private Atm atm;
         private Card card;
         
         public Builder Id(Long val)
         {
             this.id=val;
             return this;
         }
         private Builder atm(Atm val)
         {
             this.atm=val;
             return this;
         }
         public Builder Card(Card val){
             this.card=val;
             return this;
         }
         
         public CardReader builder()
         {
             return new CardReader(this);
         }
     }

    public Long getId() {
        return id;
    }

    public com.phindile.atmweb.domain.Card getCard() {
        return card;
    }

    public Atm getAtm() {
        return atm;
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
        if (!(object instanceof CardReader)) {
            return false;
        }
        CardReader other = (CardReader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.CardReader[ id=" + id + " ]";
    }
    
}
