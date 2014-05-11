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
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int Account_number;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    private String Acc_type;

    private Account(Builder builder) {

    }

    private Account() {

    }

    public static class Builder {

        private Long id;
        private int Account_number;
        private int pin;
        private double availableBalance;
        private double totalBalance;
        private String Acc_type;

        public Builder(int acc_num) {
            this.Account_number = acc_num;
        }

        public Builder pin(int pin) {
            this.pin = pin;
            return this;
        }

        public Builder Acc_typ(String acc_typ) {
            this.Acc_type = acc_typ;
            return this;
        }

        public Builder availablebalance(double avail_bal) {
            this.availableBalance = avail_bal;
            return this;
        }

        public Builder totalBal(double tot_bal) {
            this.totalBalance = tot_bal;
            return this;
        }

        public Builder Account(Account account) {
            this.Account_number = account.getAccount_number();
            this.availableBalance = account.getAvailableBalance();
            this.pin = account.getPin();
            this.Acc_type = account.getAcc_type();
            this.id = account.getId();
            return this;
        }

        public Account build() {
            return new Account(this);
        }

    }

    public String getAcc_type() {
        return Acc_type;
    }

    public int getAccount_number() {
        return Account_number;
    }

    public int getPin() {
        return pin;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.Account[ id=" + id + " ]";
    }

}
