package com.example.cakeshop.servlet;



import com.example.cakeshop.service.GoodsService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/index")
public class indexServlet extends HttpServlet {
    private GoodsService gService = new GoodsService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取得条幅商品
        Map<String,Object> scrollgoods =  gService.getScrollGoods();
        request.setAttribute("scroll",scrollgoods);
        //取得热销商品
        List<Map<String,Object>> hotlist =  gService.getHotGoodsList();
        request.setAttribute("hotList",hotlist);
        //取得新品
        List<Map<String,Object>> newlist = gService.getNewGoodsList();
        request.setAttribute("newlist",newlist);
        //跳转到index.jsp
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
