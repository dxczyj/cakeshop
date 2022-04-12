package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Goods;
import com.example.cakeshop.model.Page;
import com.example.cakeshop.model.Types;
import com.example.cakeshop.service.GoodsService;
import com.example.cakeshop.service.TypesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/goods_list")
public class GoodsListServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    private TypesService tService = new TypesService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        if (request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
        }
        int pageNumber = 1;
        if(request.getParameter("pageNumber")!=null){
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }

        Page p = gService.getGoodsPage(id,pageNumber);
        request.setAttribute("page",p);
        request.setAttribute("id",id);
        Types t = null;
        if (id!=0){
            t = tService.select(id);
        }
        request.setAttribute("t",t);
        request.getRequestDispatcher("/goodslist.jsp").forward(request,response);
    }

}
