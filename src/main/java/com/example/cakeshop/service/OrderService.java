package com.example.cakeshop.service;

import com.example.cakeshop.dao.OrderDao;
import com.example.cakeshop.model.Order;
import com.example.cakeshop.model.Orderitem;
import com.example.cakeshop.model.Page;
import com.example.cakeshop.utils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDao oDao = new OrderDao();


    public void addOrder(Order order) {
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);

            oDao.insertOrder(con, order);
            int id = oDao.getLastInsertId(con);
            order.setId(id);
            for (Orderitem item : order.getOrderitemMap().values()) {
                oDao.insertOrderItem(con, item);
            }

            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if (con != null)
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
    }
    public List<Order> selectAll(int userid){
        List<Order> list = null;
        try {
            list = oDao.selectAll(userid);
            for (Order o : list){
                List<Orderitem> l = oDao.selectAllItem(o.getId());
                o.setItemList(l);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Page getOrderPage( int status,int pageNumber) {
        Page p = new Page();
        int pageSize = 10;
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = oDao.getOrderCount(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(pageSize,totalCount);

        List list = null;
        try {
            list = oDao.selectOrderList(status,pageNumber,pageSize);
            for (Order o:(List<Order>)list){
                List<Orderitem> l = oDao.selectAllItem(o.getId());
                o.setItemList(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public void updateStatus(int id,int status){
        try {
            oDao.updateStatus(id,status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        Connection con = null;
        try {
            con = DBUtil.getDataSource().getConnection();
            con.setAutoCommit(false);

            oDao.deleteOrderItem(con,id);
            oDao.deleteOrder(con,id);
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }


}
