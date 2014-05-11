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
import javax.persistence.Embeddable;
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
public class CardReader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String atm_name;
    
    @Column(unique=true)
    private String cardreader_num;
   @OneToMany(cascade=CascadeType.ALL)
   @JoinColumn(name="atm_name")
    List<Card> card;
    
   
    
    private CardReader(Builder builder)
    {
        this.atm_name=builder.atm_name;
        this.id=builder.id;
        this.card=builder.card;
        this.cardreader_num=builder.cardreader_num;
        
    }
     private CardReader()  
     {
         
     }
     public static class Builder{
         private Long id;
         private String atm_name;
         List<Card> card;
         private String cardreader_num;
         
         public Builder(String cardreader_num)
         {
             this.cardreader_num=cardreader_num;
         }
         public Builder Id(Long val)
         {
             this.id=val;
             return this;
         }
         public Builder atm_name_cardr(String val)
         {
             this.atm_name=val;
             return this;
         }
         public Builder Card(List<Card> val){
             this.card=val;
             return this;
         }
         public Builder CardReader(CardReader cardreader)
         {
             this.cardreader_num=cardreader.getCardreader_num();
             this.card=cardreader.getCard();
             this.id=cardreader.getId();
             this.atm_name=cardreader.getAtm();
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

    public List<Card> getCard() {
        return card;
    }

    public String getCardreader_num() {
        return cardreader_num;
    }
    

    public String getAtm() {
        return atm_name;
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
