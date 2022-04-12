package com.example.cakeshop.service;

import com.example.cakeshop.dao.TypesDao;
import com.example.cakeshop.model.Types;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public class TypesService {
    private TypesDao tDao = new TypesDao();
    public List<Types> selectAll(){
        List<Types> list = null;
        try {
            list = tDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Types select(int id){
        Types t = null;
        try {
            t = tDao.select(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public void insert(Types t){

        try {
            tDao.insert(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Types t){
        try {
            tDao.update(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Boolean delete(int id){
        try {
            tDao.delete(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
