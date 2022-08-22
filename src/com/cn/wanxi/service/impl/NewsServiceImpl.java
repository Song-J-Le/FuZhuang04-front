package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NewsDao;
import com.cn.wanxi.dao.impl.NewsImpl;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private NewsDao newsDao=new NewsImpl();
    @Override
    public List<NewsModel> getNewsModelList(NewsModel newsModel) {
        return newsDao.getNewsModelList(newsModel);
    }
}
