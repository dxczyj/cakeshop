package com.example.cakeshop.servlet;


import com.example.cakeshop.model.Page;
import com.example.cakeshop.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/user_list")
public class AdminUserListServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber=1;
        if (request.getParameter("pageNumber")!=null){
            pageNumber= Integer.parseInt(request.getParameter("pageNumber"));
        }
        Page p = userService.getUserPage(pageNumber);
        request.setAttribute("page",p);
        request.getRequestDispatcher("/admin/user_list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
