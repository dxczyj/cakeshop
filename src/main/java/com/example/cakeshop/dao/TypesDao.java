package com.example.cakeshop.dao;

import com.example.cakeshop.model.Types;
import com.example.cakeshop.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public class TypesDao {
   public List<Types> selectAll() throws SQLException {
       QueryRunner r = new QueryRunner(DBUtil.getDataSource());
       String sql = "select * from types";
       return r.query(sql,new BeanListHandler<Types>(Types.class));
   }
   public Types select(int id) throws SQLException {
       QueryRunner r = new QueryRunner(DBUtil.getDataSource());
       String sql = "select * from types where id = ?";
       return r.query(sql,new BeanHandler<Types>(Types.class),id);
   }
   public void insert(Types t) throws SQLException {
       QueryRunner r = new QueryRunner(DBUtil.getDataSource());
       String sql = "insert into types(name) values(?)";
       r.update(sql,t.getName());
   }
   public void update(Types t) throws SQLException {
       QueryRunner r =new QueryRunner(DBUtil.getDataSource());
       String sql = "update types set name=? where id = ?";
       r.update(sql,t.getName(),t.getId());
   }

    public void delete(int id) throws SQLException {
        QueryRunner r =new QueryRunner(DBUtil.getDataSource());
        String sql = "delete from types where id = ?";
        r.update(sql,id);
    }

}
