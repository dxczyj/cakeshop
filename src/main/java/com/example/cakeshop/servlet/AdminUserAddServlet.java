package com.example.cakeshop.servlet;

import com.example.cakeshop.model.User;
import com.example.cakeshop.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/admin/user_add")
public class AdminUserAddServlet extends HttpServlet {
    private UserService uService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        try {
            BeanUtils.copyProperties(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (uService.register(user)){
            request.setAttribute("msg","注册成功,请登录");
            request.getRequestDispatcher("/admin/user_list").forward(request,response);
        }else{
            request.setAttribute("msg","用户名和邮箱重复,请重试注册");
            request.getRequestDispatcher("/admin/user_add.jsp").forward(request,response);
        }
    }
}
