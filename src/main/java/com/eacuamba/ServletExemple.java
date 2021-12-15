/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eacuamba;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author EACUAMBA
 */
@WebServlet(urlPatterns = {"/hello"})
public class ServletExemple extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter pw = resp.getWriter()) {
            pw.append("Edilson Alexandre Cuamba");
            pw.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd - MM - yyyy HH:mm:ss")));
            
            pw.flush();
        }
    }
    
}
