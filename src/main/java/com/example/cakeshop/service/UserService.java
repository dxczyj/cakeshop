package com.example.cakeshop.service;

import com.example.cakeshop.dao.UserDao;
import com.example.cakeshop.model.Order;
import com.example.cakeshop.model.Orderitem;
import com.example.cakeshop.model.Page;
import com.example.cakeshop.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao uDao = new UserDao();
    public boolean register(User user){
        try {
            if (uDao.isUsernameExist(user.getUsername())){
                return false;
            }
            if (uDao.isEmailExist(user.getEmail())){
                return false;
            }
            uDao.addUser(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public User login(String ue,String password)  {
        User u = null;
        try {
            u = uDao.selectUsernamePassword(ue,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (u!=null){
            return u;
        }
        try {
            u = uDao.selectEmailPassword(ue, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (u!=null){
            return u;
        }
        return null;
    }

    public void updateUserAddress(User u){
        try {
            uDao.updateUserAddress(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User selectById(int id)  {
        User u = null;
        try {
            u = uDao.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public void updateUserPassword(User u){
        try {
            uDao.updateUserPassword(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Page getUserPage(int pageNumber) {
        Page p = new Page();
        int pageSize = 7;
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = uDao.selectUserCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize,totalCount);

        List list = null;
        try {
            list = uDao.selectUserList(pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }
    public boolean delete(int id){
        try {
            uDao.delete(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
