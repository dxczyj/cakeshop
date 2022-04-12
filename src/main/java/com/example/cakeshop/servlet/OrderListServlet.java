package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Order;
import com.example.cakeshop.model.User;
import com.example.cakeshop.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/order_list")
public class OrderListServlet extends HttpServlet {
    private OrderService oService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        List<Order> list = oService.selectAll(u.getId());
        request.setAttribute("orderlist",list);
        request.getRequestDispatcher("/order_list.jsp").forward(request,response);

    }
}
