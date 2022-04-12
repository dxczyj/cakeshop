package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Types;
import com.example.cakeshop.service.TypesService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/admin/type_edit")
public class AdminTypeEditServlet extends HttpServlet {
    private TypesService tService = new TypesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Types t = new Types();
        try {
            BeanUtils.copyProperties(t,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        tService.update(t);
        request.getRequestDispatcher("/admin/type_list").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
