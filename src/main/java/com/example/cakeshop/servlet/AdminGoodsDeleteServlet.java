package com.example.cakeshop.servlet;

import com.example.cakeshop.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/goods_delete")
public class AdminGoodsDeleteServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isSuccess ;
        isSuccess = gService.delete(id);
        if (isSuccess){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("failMsg","删除失败");
        }
        request.getRequestDispatcher("/admin/goods_list").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
