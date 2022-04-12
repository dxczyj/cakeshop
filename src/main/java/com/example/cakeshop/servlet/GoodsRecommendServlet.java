package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Page;
import com.example.cakeshop.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/goodsrecommend_list")
public class GoodsRecommendServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        int pageNumber = 1;
        if(request.getParameter("pageNumber")!=null){
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }
        Page p = gService.getGoodsRecommendPage(type,pageNumber);
        request.setAttribute("t",type);
        request.setAttribute("page",p);

        request.getRequestDispatcher("goodsrecommend_list.jsp").forward(request,response);
    }
}
