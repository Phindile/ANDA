/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.domain;

import java.io.Serializable;
import java.net.InetAddress;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author chiry
 */
@Entity
public class Atm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Long ATM_ID_CODE;
    private String Location;
    private String Bank_Name;
    private InetAddress bankaddress;
    private int State;
    private boolean switchon;
    private boolean cardInserted;
    private  int OFF_STATE ;
    private  int IDLE_STATE;
    private  int SERVING_CUSTOMER_STATE;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="ATM_ID_CODE")
    private CardReader card_reader;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="ATM_ID_CODE")
    private CashDespenser cash_despeneser;
    @Embedded
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="ATM_ID_CODE")
    private CustomerConsole Customer_console;
    @Embedded
    @OneToOne
    @JoinColumn(name="ATM_ID_CODE")
    private EnvelopAcceptor envelop_accepter;
    @Embedded
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="ATM_ID_CODE")
    private Log log;
    @Embedded
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="ATM_ID_CODE")
    private NetworkToBank net_to_bank;
    @Embedded
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="ATM_ID_CODE")
    private OperatorPanel operator_panel;
    @Embedded
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="ATM_ID_CODE")
    private RecieptPrinter reciept_printer;
    
    private Atm(Builder builder)
    {
        this.id=builder.id;
        this.ATM_ID_CODE=builder.ATM_ID_CODE;
        this.Bank_Name =builder.Bank_Name;
        this.Location=builder.Location;
        this.IDLE_STATE=builder.IDLE_STATE;
        this.OFF_STATE =builder.OFF_STATE;
        this.SERVING_CUSTOMER_STATE =builder.SERVING_CUSTOMER_STATE;
        this.bankaddress=builder.bankaddress;
        this.State =builder.State;
        this.Customer_console=builder.Customer_console;
        this.cardInserted=builder.cardInserted;
        this.card_reader=builder.card_reader;
        this.cash_despeneser=builder.cash_despeneser;
        this.envelop_accepter=builder.envelop_accepter;
        this.log=builder.log;
        this.reciept_printer=builder.reciept_printer;
        this.operator_panel=builder.operator_panel;
        
    }
    private Atm()
    {
        
        
    }
    public static class Builder{
      private Long id;
      private Long ATM_ID_CODE;
      private String Location;
      private String Bank_Name;
      private InetAddress bankaddress;
      private int State;
      private boolean switchon;
      private boolean cardInserted;
      private int OFF_STATE;
      private int IDLE_STATE;
      private int SERVING_CUSTOMER_STATE;
      private CardReader card_reader;
      private CashDespenser cash_despeneser;
      private CustomerConsole Customer_console;
      private EnvelopAcceptor envelop_accepter;
      private Log log;
      private NetworkToBank net_to_bank;
      private OperatorPanel operator_panel;
      private RecieptPrinter reciept_printer;
      
      public Builder ID(Long val)
      {
          this.id =val;
          return this;
      }
      
      public Builder ATM_ID_CODE(Long val)
      {
          this.ATM_ID_CODE = val;
          return this;
                  
      }
      public Builder Location(String val)
      {
          this.Location = val;
          return this;
      }
      public Builder BankName(String val)
      {
          this.Bank_Name= val;
          return this;
      }
      public Builder BankAddress(InetAddress val)
      {
          this.bankaddress =val;
          return this;
      }
      public Builder State(int val)
      {
          this.State = val;
          return this;
      }
       public Builder switchON( boolean val)
       {
           this.switchon =val;
           return this;
       }
      public Builder Cardinserted( boolean val)
      {
          this.cardInserted=val;
          return this;
      }
      public Builder OFF_STATE(int val)
      {
         this.OFF_STATE =val;
         return this;
      }
      public Builder IDLE_STATE(int val)
      {
          this.IDLE_STATE = val;
          return this;
      }
      public Builder ServingCustomers(int val)
      {
          this.SERVING_CUSTOMER_STATE=val;
          return this;
      }
      public Builder CardReader(CardReader val){
          this.card_reader=val;
          return this;
      }
      public Builder CashDespenser(CashDespenser val)
      {
          this.cash_despeneser=val;
          return this;
      }
    
      public Builder CustomerConsole(CustomerConsole val)
      {
          this.Customer_console=val;
          return this;
      }
      
      public Builder EnvelopAcceptor(EnvelopAcceptor val)
      {
          this.envelop_accepter =val;
          return this;
      }
      public Builder Log(Log val)
      {
          this.log =val;
          return this;
      }
      public Builder NetworkToBank(NetworkToBank val)
      {
          this.net_to_bank=val;
          return this;   
      }
      public Builder OperatorPanel(OperatorPanel val)
      {
          this.operator_panel=val;
          return this;
      }
      public Builder RecieptPrinter(RecieptPrinter val)
      {
          this.reciept_printer =val;
          return this;
      }

       public Atm builder(){
           return new Atm(this);
       } 
    }


    public Long getATM_ID_CODE() {
        return ATM_ID_CODE;
    }

    public String getLocation() {
        return Location;
    }

    public String getBank_Name() {
        return Bank_Name;
    }

    public InetAddress getBankaddress() {
        return bankaddress;
    }

    public int getState() {
        return State;
    }

    public boolean isSwitchon() {
        return switchon;
    }

    public boolean isCardInserted() {
        return cardInserted;
    }

    public int getOFF_STATE() {
        return OFF_STATE;
    }

    public int getIDLE_STATE() {
        return IDLE_STATE;
    }

    public int getSERVING_CUSTOMER_STATE() {
        return SERVING_CUSTOMER_STATE;
    }

    public com.phindile.atmweb.domain.CardReader getCard_reader() {
        return card_reader;
    }

    public com.phindile.atmweb.domain.CashDespenser getCash_despeneser() {
        return cash_despeneser;
    }

    public com.phindile.atmweb.domain.CustomerConsole getCustomer_console() {
        return Customer_console;
    }

    public com.phindile.atmweb.domain.EnvelopAcceptor getEnvelop_accepter() {
        return envelop_accepter;
    }

    public com.phindile.atmweb.domain.Log getLog() {
        return log;
    }

    public com.phindile.atmweb.domain.NetworkToBank getNet_to_bank() {
        return net_to_bank;
    }

    public com.phindile.atmweb.domain.OperatorPanel getOperator_panel() {
        return operator_panel;
    }

    public com.phindile.atmweb.domain.RecieptPrinter getReciept_printer() {
        return reciept_printer;
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
        if (!(object instanceof Atm)) {
            return false;
        }
        Atm other = (Atm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phindile.atmweb.domain.Atm[ id=" + id + " ]";
    }
    
}
