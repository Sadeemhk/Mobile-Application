package com.example.afterchaptertwo;

import java.util.ArrayList;
import java.util.List;

public class Members {
    List<String> getStd(String names) {
        List<String> StdName = new ArrayList<>();
        if (StdName.equals("Sadeem")) {
            StdName.add("Sadeem Hassan Ahmed Aljahdali");
        } else {
            StdName.add("Group Members");
        }
        return StdName;
    }
}
