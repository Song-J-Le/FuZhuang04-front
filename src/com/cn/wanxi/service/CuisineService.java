package com.cn.wanxi.service;

import com.cn.wanxi.model.CuisineModel;

import java.util.List;

public interface CuisineService {
    List<CuisineModel> findAll(CuisineModel model);
}
