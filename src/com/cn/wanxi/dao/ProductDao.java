package com.cn.wanxi.dao;

import com.cn.wanxi.model.ProductModel;

import java.util.List;

public interface ProductDao {
    List<ProductModel> getProductModelList(ProductModel model);

    List<ProductModel> findById(ProductModel model);

}
