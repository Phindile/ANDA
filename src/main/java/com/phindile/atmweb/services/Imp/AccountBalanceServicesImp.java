/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.services.Imp;

import com.phindile.atmweb.domain.Account;
import com.phindile.atmweb.repository.AccountRepository;
import com.phindile.atmweb.services.AccountBalanceService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiry
 */
@Service
public class AccountBalanceServicesImp implements AccountBalanceService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getBalanceAbove(double balance) {
       List<Account> accounts = new ArrayList<>();
       List<Account> allaccount = accountRepository.findAll();
       
       for(Account account:allaccount){
       
           if(account.getTotalBalance()>balance){
               accounts.add(account);
           }
       
         }
        return accounts;
       
    }
    
}
