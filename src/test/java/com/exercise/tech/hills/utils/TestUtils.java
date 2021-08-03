package com.exercise.tech.hills.utils;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.model.dto.HillInfoDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {

    private static final String NAME = "Ben Lomond";
    private static final String CATEGORY = "MUN";
    private static final double HEIGHT_METRES = 1044.9;
    private static final String GRID_REF = "NN773308";

    public static HillInfo getHillInfo() {
        HillInfo hillInfo = new HillInfo();
        hillInfo.setName(NAME);
        hillInfo.setPost1997(CATEGORY);
        hillInfo.setGridRef(GRID_REF);
        hillInfo.setHeightInMetres(HEIGHT_METRES);
        return hillInfo;
    }

    public static HillInfo getHillInfo(String name, String category, String gridRef, double height) {
        HillInfo hillInfo = new HillInfo();
        hillInfo.setName(name);
        hillInfo.setPost1997(category);
        hillInfo.setGridRef(gridRef);
        hillInfo.setHeightInMetres(height);
        return hillInfo;
    }

    public static HillInfoDto getHillInfoDto() {
        return HillInfoDto.builder()
                .name(NAME)
                .category(CATEGORY)
                .heightInMetres(HEIGHT_METRES)
                .gridRef(GRID_REF)
                .build();
    }

    public static List<HillInfo> getHillInfoList() {
        HillInfo hillInfo2 = TestUtils.getHillInfo("name2", "TOP", "grid2", 1000.2);
        HillInfo hillInfo4 = TestUtils.getHillInfo("name4", null, "grid4", 1000.4);
        HillInfo hillInfo1 = TestUtils.getHillInfo("name1", "MUN", "grid1", 1000.1);
        HillInfo hillInfo3 = TestUtils.getHillInfo("name3", "MUN", "grid3", 1000.3);
        HillInfo hillInfo5 = TestUtils.getHillInfo("name5", "", "grid5", 1000.5);
        return new ArrayList<>(Arrays.asList(hillInfo2, hillInfo4, hillInfo1,
                hillInfo3, hillInfo5));
    }

}
