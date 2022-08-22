package com.cn.wanxi.dao;

import com.cn.wanxi.model.CuisineModel;

import java.util.List;

public interface CuisineDao  {
    List<CuisineModel> findAll(CuisineModel model);
}
