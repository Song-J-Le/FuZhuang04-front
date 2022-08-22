package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.ProductDao;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductDao {

    private List<ProductModel> getList(String sql) {
        List<ProductModel> list = new ArrayList<>();
        ResultSet resultSet = JDBC.query(sql);
        try {
            while (resultSet.next()) {
                ProductModel model = new ProductModel();
                model.setId(resultSet.getInt("id"));
                model.setName(resultSet.getString("name"));
                model.setNormalPrice(resultSet.getBigDecimal("normal_price"));
                model.setMarketPrice(resultSet.getBigDecimal("price"));
                model.setImgHref(resultSet.getString("img_href"));
                try {
                    model.setCuisineName(resultSet.getString("cuisineName"));
                } catch (Exception e) {

                }
                model.setIsShow(resultSet.getInt("is_show"));
                model.setIsRecommend(resultSet.getInt("is_recommend"));
                model.setContent(resultSet.getString("content"));
                model.setCuisineId(resultSet.getInt("cuisine_id"));
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ProductModel> getProductModelList(ProductModel model) {
        String sql = "select * from product where where_show=" + model.getWhereShow() + "";
        sql += " order by id desc ";
        sql += " limit " + (model.getPage() - 1) * model.getLimit() + "," + model.getLimit() + "";
        return getList(sql);
    }

    @Override
    public List<ProductModel> findById(ProductModel model) {
        String sql = " select * from product where id=(select max(id) from product where id<" + model.getId() + ")\n" +
                " union all " +
                " select * from product where id=" + model.getId() +
                " union all " +
                " select * from product where id=(select min(id) from product where id>" + model.getId() + ")";
        return getList(sql);
    }
}
