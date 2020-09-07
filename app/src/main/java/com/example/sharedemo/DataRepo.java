package com.example.sharedemo;

import java.util.ArrayList;
import java.util.List;

public class DataRepo {
    private static List<String> sDataList = new ArrayList<>();

    public static List<String> getDataList() {
        if (!sDataList.isEmpty()) {
            return sDataList;
        }
        for (int i = 0; i < 100; i++) {
            sDataList.add("第" + (i + 1) + "条数据");
        }
        return sDataList;
    }
}
