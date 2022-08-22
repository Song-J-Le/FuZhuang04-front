package com.cn.wanxi.dao;

import com.cn.wanxi.model.NewsModel;

import java.util.List;

public interface NewsDao {
    List<NewsModel> getNewsModelList(NewsModel newsModel);
}
