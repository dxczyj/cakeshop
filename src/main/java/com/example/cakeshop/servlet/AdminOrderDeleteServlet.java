package com.example.cakeshop.servlet;

import com.example.cakeshop.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/order_delete")
public class AdminOrderDeleteServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        oService.delete(id);
        request.getRequestDispatcher("/admin/order_list").forward(request,response);

    }
}
