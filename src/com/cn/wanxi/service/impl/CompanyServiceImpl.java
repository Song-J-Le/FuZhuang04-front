package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.CompanyDao;
import com.cn.wanxi.dao.impl.CompanyImpl;
import com.cn.wanxi.model.CompanyModel;
import com.cn.wanxi.service.CompanyService;


public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao = new CompanyImpl();

    @Override
    public CompanyModel getCompanyModel() {
        return companyDao.getCompanyModel();

    }
}
