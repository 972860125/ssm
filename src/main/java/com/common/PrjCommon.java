package com.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PrjCommon {
    private static String pageSize;

    public static String getPageSize() {
        return pageSize;
    }

    @Value("$(pageSize)")
    public  void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

}
