/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eacuamba;

import com.eacuamba.dao.implementation.PessoaDAO;
import com.eacuamba.domain.model.Pessoa;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author EACUAMBA
 */
@WebServlet(urlPatterns = {"/hello"})
public class ServletExemple extends HttpServlet{

//    @Inject
//    private PessoaDAO pesssoDAO;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter pw = resp.getWriter()) {
            pw.append("Edilson Alexandre Cuamba - ");
            
//            if(this.pesssoDAO != null){
//                pw.append("Injectado!");
//                Pessoa pessoa = new Pessoa();
//                pessoa.setNome("Edilson");
//                //this.pesssoDAO.save(pessoa);
//            }
            pw.flush();
            pw.close();
        }
    }
    
}
