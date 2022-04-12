package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Page;
import com.example.cakeshop.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/goods_search")
public class GoodsSearchServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        int pageNumber = 1;
        if(request.getParameter("pageNumber")!=null){
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }
        Page p = gService.getSearchGoodsPage(keyword,pageNumber);
        request.setAttribute("page",p);
        request.setAttribute("keyword",URLEncoder.encode(keyword,"utf-8"));
        request.getRequestDispatcher("/goods_search.jsp").forward(request,response);


    }
}
