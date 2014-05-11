/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.services;

import com.phindile.atmweb.domain.atmm;
import java.util.List;

/**
 *
 * @author chiry
 */
public interface AllBankAtmService {
    public List<atmm> getTotalAtmswithSameName();
    
}
