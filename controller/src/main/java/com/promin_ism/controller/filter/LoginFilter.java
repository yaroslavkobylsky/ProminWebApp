package com.promin_ism.controller.filter;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private static final String loginPage = "/login";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();

        if (httpSession.getAttribute("user") == null && !httpServletRequest.getRequestURI().endsWith(loginPage)){
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            httpServletResponse.sendRedirect(loginPage);
        }
        else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
