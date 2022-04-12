package com.example.cakeshop.servlet;

import com.example.cakeshop.model.User;
import com.example.cakeshop.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/user_changeaddress")
public class ChangeAddressServlet extends HttpServlet {
    private UserService uService = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User loginUser = (User) request.getSession().getAttribute("user");

        try {
            BeanUtils.copyProperties(loginUser,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        uService.updateUserAddress(loginUser);
        request.setAttribute("msg","个人信息更新成功");
        request.getRequestDispatcher("/user_center.jsp").forward(request,response);

    }


}
