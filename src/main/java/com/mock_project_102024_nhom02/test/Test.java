package com.mock_project_102024_nhom02.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> searchBody = new HashMap<>();
        ;
        searchBody.put("searchKey", "searchValue");

        searchBody.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
