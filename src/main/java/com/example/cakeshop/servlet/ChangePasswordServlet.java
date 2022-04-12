package com.example.cakeshop.servlet;

import com.example.cakeshop.model.User;
import com.example.cakeshop.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user_changepassword")
public class ChangePasswordServlet extends HttpServlet {
    private UserService uSservice = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String passPwd = request.getParameter("passwordNew");

        User u = (User) request.getSession().getAttribute("user");

        if (password.equals(u.getPassword())){

            u.setPasswordNew(passPwd);
            uSservice.updateUserPassword(u);
            request.setAttribute("successMsg","修改成功");
            request.getRequestDispatcher("/user_center.jsp").forward(request,response);
        }else{
            request.setAttribute("failMsg","修改失败,原密码不正确,请重新输入");
            request.getRequestDispatcher("/user_center.jsp").forward(request,response);
        }


    }
}
