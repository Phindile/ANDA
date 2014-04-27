/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author chiry
 */
@Embeddable
public class CustomerConsole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Pin;
    private int choice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPin() {
        return Pin;
    }

    public void setPin(int Pin) {
        this.Pin = Pin;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    
    
    private Money readMoney;

    public Money getReadMoney() {
        return readMoney;
    }

    public void setReadMoney(Money readMoney) {
        this.readMoney = readMoney;
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
        if (!(object instanceof CustomerConsole)) {
            return false;
        }
        CustomerConsole other = (CustomerConsole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.CustomerConsole[ id=" + id + " ]";
    }
    
}
