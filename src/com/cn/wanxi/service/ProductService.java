package com.cn.wanxi.service;

import com.cn.wanxi.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> getProductModelList(ProductModel model);

    List<ProductModel> findById(ProductModel model);

}
