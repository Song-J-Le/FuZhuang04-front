package com.cn.wanxi.service.impl;

import com.cn.wanxi.dao.ProductDao;
import com.cn.wanxi.dao.impl.ProductImpl;
import com.cn.wanxi.model.ProductModel;
import com.cn.wanxi.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductImpl();
//
//    @Override
//    public List<ProductModel> getProductModelListForHomePage() {
//        return productDao.getProductModelListForHomePage();
//    }

    @Override
    public List<ProductModel> getProductModelList(ProductModel model) {
        return productDao.getProductModelList(model);
    }

    @Override
    public List<ProductModel> findById(ProductModel model) {
        return productDao.findById(model);
    }

//    @Override
//    public List<ProductModel> getProductModelListForProductPage() {
//        return productDao.getProductModelListForProductPage();
//    }
}
