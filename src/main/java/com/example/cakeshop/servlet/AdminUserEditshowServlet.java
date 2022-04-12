package com.example.cakeshop.servlet;

import com.example.cakeshop.model.User;
import com.example.cakeshop.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/user_editshow")
public class AdminUserEditshowServlet extends HttpServlet {
    private UserService uService  = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = uService.selectById(id);
        request.setAttribute("u",user);
        request.getRequestDispatcher("/admin/user_edit.jsp").forward(request,response);
    }
}
