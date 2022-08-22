package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.CuisineDao;
import com.cn.wanxi.dao.impl.CuisineImpl;
import com.cn.wanxi.model.CuisineModel;
import com.cn.wanxi.service.CuisineService;

import java.util.List;

public class CuisineServiceImpl implements CuisineService {
    private CuisineDao cuisineDao = new CuisineImpl();


    @Override
    public List<CuisineModel> findAll(CuisineModel model) {
        return cuisineDao.findAll(model);
    }
}
