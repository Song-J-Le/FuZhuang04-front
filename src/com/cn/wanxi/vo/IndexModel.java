package com.cn.wanxi.vo;

import com.cn.wanxi.model.CompanyModel;
import com.cn.wanxi.model.NavModel;
import com.cn.wanxi.model.NewsModel;
import com.cn.wanxi.model.ProductModel;

import java.util.List;

public class IndexModel {
    private CompanyModel companyModel ;
    private List<NavModel> navModelList;
    private List<NewsModel> newsModelList;
    private  List<ProductModel> productModelList;

    public CompanyModel getCompanyModel() {
        return companyModel;
    }

    public void setCompanyModel(CompanyModel companyModel) {
        this.companyModel = companyModel;
    }

    public List<NavModel> getNavModelList() {
        return navModelList;
    }

    public void setNavModelList(List<NavModel> navModelList) {
        this.navModelList = navModelList;
    }

    public List<NewsModel> getNewsModelList() {
        return newsModelList;
    }

    public void setNewsModelList(List<NewsModel> newsModelList) {
        this.newsModelList = newsModelList;
    }

    public List<ProductModel> getProductModelList() {
        return productModelList;
    }

    public void setProductModelList(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }
}
