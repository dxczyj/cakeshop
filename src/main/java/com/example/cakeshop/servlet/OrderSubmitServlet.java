package com.example.cakeshop.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/order_submit")
public class OrderSubmitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user")!=null){
            request.getRequestDispatcher("/order_submit.jsp").forward(request,response);
        }else{
            request.setAttribute("failMsg","请登陆后，再提交订单");
            request.getRequestDispatcher("/user_login.jsp").forward(request,response);
        }



    }
}
