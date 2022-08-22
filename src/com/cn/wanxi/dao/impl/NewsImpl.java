package com.cn.wanxi.dao.impl;

import com.cn.wanxi.dao.NewsDao;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.util.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsImpl implements NewsDao {
    /**
     * 如果后台代码只想写一个查询方法，则需要根据不同的页面显示不同的内容
     *
     * @param model
     * @return
     */
    @Override
    public List<NewsModel> getNewsModelList(NewsModel model) {
        String sql = "select *,date_format(create_time,'%Y-%m-%d') temp from news where 1=1 ";
        sql += " and where_show=" + model.getWhereShow();
        sql += " order by id desc ";
        int start = (model.getPage() - 1) * model.getLimit();
        sql += " limit " + start + "," + model.getLimit();
        ResultSet resultSet = JDBC.query(sql);
        List<NewsModel> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                NewsModel newsModel = new NewsModel();
                newsModel.setId(resultSet.getInt("id"));
                newsModel.setTitle(resultSet.getString("title"));
                newsModel.setContent(resultSet.getString("content"));
                newsModel.setCreateTime(resultSet.getString("temp"));
                list.add(newsModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

