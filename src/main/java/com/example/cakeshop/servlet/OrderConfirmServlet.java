package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Order;
import com.example.cakeshop.model.User;
import com.example.cakeshop.service.OrderService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@WebServlet("/order_confirm")
public class OrderConfirmServlet extends HttpServlet {
    private OrderService oService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order o= (Order) request.getSession().getAttribute("order");
        try {
            BeanUtils.copyProperties(o,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        o.setDatetime(new Date());
        o.setStatus(2);
        o.setUser((User) request.getSession().getAttribute("user"));

        oService.addOrder(o);
        request.getSession().removeAttribute("order");

        request.setAttribute("msg","订单支付成功！");
        request.getRequestDispatcher("order_success.jsp").forward(request,response);
    }
}
