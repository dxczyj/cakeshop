package com.example.cakeshop.filter;

import com.example.cakeshop.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req =  ((HttpServletRequest)request);
        HttpServletResponse resp = ((HttpServletResponse)response);
        User u = (User) req.getSession().getAttribute("user");
        if (u==null || u.isIsadmin()==false){
            resp.sendRedirect(req.getContextPath());
        }else{
            chain.doFilter(request, response);
        }
    }
}
