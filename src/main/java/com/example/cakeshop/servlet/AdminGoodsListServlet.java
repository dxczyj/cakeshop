package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Goods;
import com.example.cakeshop.model.Page;
import com.example.cakeshop.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/goods_list")
public class AdminGoodsListServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = 1;
        if (request.getParameter("pageNumber")!=null){
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }
        int type = 0;
        if (request.getParameter("type")!=null){
            type = Integer.parseInt(request.getParameter("type"));
        }
        Page p = gService.getGoodsRecommendPage(type,pageNumber);
        request.setAttribute("page",p);
        request.setAttribute("type",type);
        request.getRequestDispatcher("/admin/goods_list.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
