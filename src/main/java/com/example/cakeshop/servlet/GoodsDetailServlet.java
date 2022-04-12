package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Goods;
import com.example.cakeshop.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/goods_detail")
public class GoodsDetailServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("typeid"));
        Goods g = gService.getById(id);
        request.setAttribute("g",g);
        request.getRequestDispatcher("detail.jsp").forward(request,response);

    }
}
