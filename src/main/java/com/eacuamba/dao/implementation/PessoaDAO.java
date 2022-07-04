/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eacuamba.dao.implementation;

import com.eacuamba.dao.GenericDAO;

import com.eacuamba.project.domain.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author EACUAMBA
 */
//@ApplicationScoped
public class PessoaDAO extends GenericDAO<Pessoa, Long>{  
    public PessoaDAO(){
        this.setClass(Pessoa.class);
        
    }
}
