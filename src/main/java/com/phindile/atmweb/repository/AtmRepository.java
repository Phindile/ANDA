/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.phindile.atmweb.repository;

import com.phindile.atmweb.domain.Atm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author chiry
 */
public interface AtmRepository extends JpaRepository<Atm,Long>{

}
