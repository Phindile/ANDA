/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.services.Imp;

import com.phindile.atmweb.domain.atmm;
import com.phindile.atmweb.repository.ATMRepository;

import com.phindile.atmweb.services.SameBankCodeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiry
 */
@Service
public class SameBankCodeServiceImp implements SameBankCodeService{
    @Autowired
    private ATMRepository atmrepository;

    @Override
    public List<atmm> getSameAtmBankCode(int code) {
        List<atmm> atms = new ArrayList<>();
        List<atmm> atm =atmrepository.findAll() ;
        
        for(atmm at: atm)
        {
            if(at.getAtm_code()==code)
            {
                atms.add(at);
            }
        }
        return atms;
       
    }
}
