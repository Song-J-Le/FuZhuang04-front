package com.cn.wanxi.servlet;

import com.alibaba.fastjson.JSONObject;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.service.NewsService;
import com.cn.wanxi.service.ProductService;
import com.cn.wanxi.service.impl.NewsServiceImpl;
import com.cn.wanxi.service.impl.ProductServiceImpl;
import com.cn.wanxi.util.MyEnum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        2.取得前端的值
//        3.封装model
        NewsModel newsModel = new NewsModel();
        newsModel.setWhereShow(MyEnum.HOME_WHERE_SHOW.getValue());
        newsModel.setPage(MyEnum.HOME_NEWS_PAGE.getValue());
        newsModel.setLimit(MyEnum.HOME_NEWS_LIMIT.getValue());
        ProductModel productModel = new ProductModel();
        productModel.setWhereShow(MyEnum.HOME_PRODUCT_WHERE_SHOW.getValue());
        productModel.setPage(MyEnum.HOME_PRODUCT_PAGE.getValue());
        productModel.setLimit(MyEnum.HOME_PRODUCT_LIMIT.getValue());
//        4.调用服务逻辑层
        NewsService newsServcie = new NewsServiceImpl();
        ProductService produceService = new ProductServiceImpl();
//        5.得到数据
        List<NewsModel> newsModelList = newsServcie.getNewsModelList(newsModel);
        List<ProductModel> productModelList = produceService.getProductModelList(productModel);
//          (1)用list合并多个对象
//          (2)用map合并多个对象
//        Map map=new HashMap();
//        hashmap和hashset的区别？
//          (3)用set合并多个对象;
//          (4)用vo自定义页面对象合并多个对象
//          (5)用JSONObject合并多个对象
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("newsModelList", newsModelList);
        jsonObject.put("productModelList", productModelList);
//        6.返回数据
        resp.getWriter().println(jsonObject);
    }
}
