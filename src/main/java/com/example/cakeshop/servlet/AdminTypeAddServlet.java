package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Types;
import com.example.cakeshop.service.TypesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.StringWriter;

@WebServlet("/admin/type_add")
public class AdminTypeAddServlet extends HttpServlet {
    private TypesService tService = new TypesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        tService.insert(new Types(name));
        request.getRequestDispatcher("/admin/type_list").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
