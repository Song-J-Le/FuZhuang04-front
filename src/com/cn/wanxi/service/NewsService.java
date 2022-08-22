package com.cn.wanxi.service;

import com.cn.wanxi.model.NewsModel;

import java.util.List;

public interface NewsService {
    List<NewsModel> getNewsModelList(NewsModel newsModel);
}
