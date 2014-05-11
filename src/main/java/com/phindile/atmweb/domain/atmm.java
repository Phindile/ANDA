/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author chiry
 */
@Entity
public class atmm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String atm_name;
    private String Location;
    @Embedded
    private Screen screen;
    @Embedded
    private DepositSlot depositslot;
    @Column(unique=true)
    private int atm_code;

   
   
    
    
    private atmm(Builder builder){
        this.Location=builder.Location;
        this.atm_code=builder.atm_code;
        this.id=builder.id;
        this.atm_name=builder.atm_name;
        this.depositslot=builder.depositslot;
        this.screen=builder.screen;
        
    }
    private atmm(){
        
    }
    public static class Builder{
    private Long id;
    private String atm_name;
    private int atm_code;
    private String Location;
    private Screen screen;
    private DepositSlot depositslot;
    
    public Builder(int atm_code){
        this.atm_code=atm_code;
    }
    public Builder screen(Screen screen)
    {
        this.screen =screen;
        return this;
    }
    public Builder despositslot(DepositSlot depo)
    {
        this.depositslot=depo;
        return this;
    }
    public Builder atmname(String atmname)
    {
        this.atm_name=atm_name;
        return this;
    }
    public Builder Loctation(String location)
    {
        this.Location=location;
        return this;
    }
    
    public Builder atmm(atmm atm)
    {
        this.Location=atm.getLocation();
        this.atm_code=atm.getAtm_code();
        this.atm_name=atm.getAtm_name();
        this.depositslot=atm.getDepositslot();
        this.screen=atm.getScreen();
        this.id=atm.getId();
        return this;
    }
    
    public atmm build()
    {
        return new atmm(this);
    }
        
    }

    public Screen getScreen() {
        return screen;
    }

    public DepositSlot getDepositslot() {
        return depositslot;
    }
    

    public String getAtm_name() {
        return atm_name;
    }

    public int getAtm_code() {
        return atm_code;
    }

    public String getLocation() {
        return Location;
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
        if (!(object instanceof atmm)) {
            return false;
        }
        atmm other = (atmm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.atmm[ id=" + id + " ]";
    }
    
}
