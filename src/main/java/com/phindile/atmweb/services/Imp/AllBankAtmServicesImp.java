/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.services.Imp;

import com.phindile.atmweb.domain.atmm;
import com.phindile.atmweb.repository.ATMRepository;
import com.phindile.atmweb.services.AllBankAtmService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiry
 */
@Service
public class AllBankAtmServicesImp implements AllBankAtmService{
    @Autowired
    private ATMRepository Atmrepository;

    @Override
    public List<atmm> getTotalAtmswithSameName() {
        return Atmrepository.findAll();
    }
    
}
