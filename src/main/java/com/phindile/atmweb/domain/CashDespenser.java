/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author chiry
 */
@Embeddable
public class CashDespenser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private int cash_id;
    @OneToOne
    private Log log;
    @Embedded
    @OneToMany
    List<Money> cash_on_hand;
    
    private CashDespenser(Builder builder)
    {
        this.id=builder.id;
        this.cash_on_hand=builder.cash_on_hand;
        this.log=builder.log;
        this.cash_id =builder.cash_id;
    }
    private CashDespenser()
    {
        
    }
    
    public static class Builder{
    private Long id;
    private int cash_id;
    private Log log;
    List<Money> cash_on_hand;
    
    public Builder id(Long val)
    {
        this.id=val;
        return this;
    }
    public Builder cash_id(int val)
    {
        this.cash_id=val;
        return this;
    }
    public Builder Log(Log val)
    {
        this.log=val;
        return this;
    }
    public Builder Log(List<Money> val)
    {
        this.cash_on_hand=val;
        return this;
    }
    
    public CashDespenser builder()
    {
        return new CashDespenser(this);
    }

        public Long getId() {
            return id;
        }

        public int getCash_id() {
            return cash_id;
        }

        public Log getLog() {
            return log;
        }

        public List<Money> getCash_on_hand() {
            return cash_on_hand;
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
        if (!(object instanceof CashDespenser)) {
            return false;
        }
        CashDespenser other = (CashDespenser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.CashDespenser[ id=" + id + " ]";
    }
    }
    
}
