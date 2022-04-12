package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Types;
import com.example.cakeshop.service.TypesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( "/admin/type_list")
public class AdminTypeListServlet extends HttpServlet {
    private TypesService tService = new TypesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Types> list =  tService.selectAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/admin/type_list.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
