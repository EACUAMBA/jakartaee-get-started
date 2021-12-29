/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eacuamba;

import com.eacuamba.config.StartupConfig;
import com.eacuamba.config.resource_bundle.ResourceBundleWraper;
import com.eacuamba.dao.implementation.PessoaDAO;
import com.eacuamba.domain.model.Lancamento;
import com.eacuamba.domain.model.Pessoa;
import com.eacuamba.domain.repository.LancamentoRepository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 *
 * @author EACUAMBA
 */
@WebServlet(urlPatterns = {"/teste"})
public class ServletExemple extends HttpServlet{

    @Inject
    private LancamentoRepository lancamentoRepository;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter pw = resp.getWriter()) {
            StartupConfig.init();
            pw.append(ResourceBundleWraper.getBundle("messages", new Locale("pt"), new ResourceBundleWraper.Control("UTF8", "properties")).getString("uma.frase.em.utf8"));
            pw.append("\n\n\n");
            lancamentoRepository.findAll().forEach((lancamento -> pw.append(lancamento.toString()).append("\n\n")));

            pw.flush();
        }
    }
    
}
