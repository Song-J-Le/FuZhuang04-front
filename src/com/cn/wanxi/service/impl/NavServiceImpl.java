package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.NavDao;
import com.cn.wanxi.dao.impl.NavImpl;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.service.NavService;
import java.util.List;

public class NavServiceImpl implements NavService {
    private NavDao navDao = new NavImpl();

    @Override
    public List<NavModel> getNavModelList() {

        return navDao.getNavModelList();
    }
}
