package com.example.cakeshop.servlet;

import com.example.cakeshop.model.Goods;
import com.example.cakeshop.model.Order;
import com.example.cakeshop.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
    private GoodsService gService =new GoodsService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Map<String,String[]> map = request    .getParameterMap();
//        for (String key:map.keySet()) {
//            System.out.println(key+":"+map.get(key));
//        }
        Order o = null;
        if(request.getSession().getAttribute("order") != null) {
            o = (Order) request.getSession().getAttribute("order");
        }else {
            o = new Order();
            request.getSession().setAttribute("order", o);
        }
        int goodsid = Integer.parseInt(request.getParameter("goodsid"));
        Goods goods = gService.getById(goodsid);
        if(goods.getStock()>0) {
            o.addGoods(goods);
            response.getWriter().print("ok");
        }else {
            response.getWriter().print("fail");
        }
    }

}


