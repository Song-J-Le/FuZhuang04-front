package com.cn.wanxi.util;

public enum MyEnum {
    HOME_WHERE_SHOW(1),//显示在首页
    COMPANY_WHERE_SHOW(2),
    NEWS_WHERE_SHOW(3),
    PRODUCT_WHERE_SHOW(4),
    HOME_NEWS_PAGE(1),
    HOME_NEWS_LIMIT(3),
    HOME_PRODUCT_PAGE(1),
    HOME_PRODUCT_LIMIT(2),
    HOME_PRODUCT_WHERE_SHOW(1);

    private Integer value;

    public Integer getValue() {
        return value;
    }

    MyEnum(int i) {
        this.value=i;
    }
}
