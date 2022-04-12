package com.example.cakeshop.servlet;

import com.example.cakeshop.service.TypesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/admin/type_delete")
public class AdminTypeDeleteServlet extends HttpServlet {
    private TypesService tService = new TypesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Boolean isSuccess = tService.delete(id);
        if (isSuccess){
            request.setAttribute("msg","删除成功");
        }else{
            request.setAttribute("failMsg","类目下包含下商品,删除失败");
        }
        request.getRequestDispatcher("/admin/type_list").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
