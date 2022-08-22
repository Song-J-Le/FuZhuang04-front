package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.CuisineDao;
import com.cn.wanxi.model.CuisineModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuisineImpl implements CuisineDao {

    @Override
    public List<CuisineModel> findAll(CuisineModel cuisineModel) {
        String sql = "select * from cuisine where is_show=1";
        return getList(sql);
    }

    private List<CuisineModel> getList(String sql) {
        List<CuisineModel> list = new ArrayList<>();
        ResultSet resultSet = JDBC.query(sql);
        try {
            while (resultSet.next()) {
                CuisineModel model = new CuisineModel();
                model.setId(resultSet.getInt("id"));
                model.setName(resultSet.getString("name"));
                list.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
