package com.example.cakeshop.servlet;

import com.example.cakeshop.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/user_delete")
public class AdminUserDeleteServlet extends HttpServlet {
    private UserService uService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isSuccess = uService.delete(id);
        if (isSuccess){
            request.setAttribute("msg","客户删除成功");
        }else{
            request.setAttribute("failMsg","客户有下的订单,请先删除订单");
        }
        request.getRequestDispatcher("/admin/user_list").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
