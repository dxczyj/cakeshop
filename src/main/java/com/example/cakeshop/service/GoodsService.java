package com.example.cakeshop.service;

import com.example.cakeshop.dao.GoodsDao;
import com.example.cakeshop.model.Goods;
import com.example.cakeshop.model.Page;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class GoodsService {
    private GoodsDao gDao = new GoodsDao();
    public List<Map<String,Object>> getHotGoodsList()  {
        List<Map<String,Object>> list = null;
        try {
            list = gDao.getHotGoodsList(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }

    public List<Map<String,Object>> getNewGoodsList()  {
        List<Map<String,Object>> list = null;
        try {
            list = gDao.getHotGoodsList(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }

    public Map<String,Object> getScrollGoods()  {
        Map<String,Object> map = null;
        try {
            map = gDao.getScrollGoods();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
//    public List<Goods> selectGoods(int typeId,int pageNumber,int pageSize){
//        List<Goods> list = null;
//        try {
//            list = gDao.selectGoods(typeId,pageNumber,pageSize);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    public Page getGoodsPage(int typeId,int pageNumber){
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
                totalCount = gDao.getGoodsCount(typeId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(8,totalCount);

        List list = null;
        try {
            list = gDao.selectGoods(typeId,pageNumber,8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    public Page getGoodsRecommendPage(int type,int pageNumber){
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
            totalCount = gDao.selectGoodsRecommendCount(type);//TODO

        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(8,totalCount);

        List list = null;
        try {
            list = gDao.selectGoodsRecommend(type,pageNumber,8);
            for (Goods g:(List<Goods>)list){
                g.setScroll(gDao.isScroll(g));
                g.setHot(gDao.isHot(g));
                g.setNew(gDao.isNew(g));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }
    public Goods getById(int id) {
        Goods g = null;
        try {
            g = gDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return g;
    }
    public Page getSearchGoodsPage(String keyword,int pageNumber){
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int totalCount = 0;
        try {
           // totalCount = gDao.getGoodsCount(typeId);
            totalCount = gDao.getSearchCount(keyword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setPageSizeAndTotalCount(8,totalCount);

        List list = null;
        try {
           // list = gDao.selectGoods(keyword,pageNumber,8);
            list = gDao.selectSearchGoods(keyword,pageNumber,8);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }
    public void addRecommend(int id,int type){
        try {
            gDao.addRecommend(id, type);
        } catch (SQLException e) {

        }
    }
    public void removeRecommend(int id, int type){
        try {
            gDao.removeRecommend(id, type);
        } catch (SQLException e) {

        }
    }
    public void insert(Goods g){
        try {
            gDao.add(g);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Goods g){
        try {
            gDao.update(g);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Boolean delete(int id){
        try {
            gDao.delete(id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
