package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Page;
import com.example.cakeshop.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/order_list")
public class AdminOrderListServlet extends HttpServlet {
    OrderService oService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int status = 0;
        if (request.getParameter("status")!=null){
            status = Integer.parseInt(request.getParameter("status"));
        }
        int pageNumber = 1;
        if (request.getParameter("pageNumber")!=null){
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }
        Page p = oService.getOrderPage(status,pageNumber);
        request.setAttribute("page",p);
        request.setAttribute("status",status);
        request.getRequestDispatcher("/admin/order_list.jsp").forward(request,response);



    }
}
