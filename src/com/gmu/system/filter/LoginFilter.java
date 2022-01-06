package com.gmu.system.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        if (uri.contains("login") || "/myWeb/".equals(uri)){
            if (uri.endsWith(".js")||uri.endsWith(".css")){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        HttpSession session = request.getSession(false);
        if (session != null) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        request.getRequestDispatcher("/login.html").forward(servletRequest,servletResponse);
    }
}