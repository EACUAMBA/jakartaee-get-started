package com.eacuamba.project.jsf.servlets;

import com.eacuamba.project.domain.model.Utilizador;
import com.eacuamba.project.jsf.beans.UtilizadorBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AutorizacaoFilter implements Filter {
    @Inject
    private UtilizadorBean utilizadorBean;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletResponse;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if(!utilizadorBean.isLogado() && !httpServletRequest.getRequestURI().contains("project")){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/Login.xhtml");
        }else{
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
