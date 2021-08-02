package com.exercise.tech.hills.helper;

import com.exercise.tech.hills.model.HillInfo;

import java.util.Comparator;

public class HillSortByHeight implements Comparator<HillInfo> {

    public int compare(HillInfo hillInfo1, HillInfo hillInfo2) {
        return Double.compare(hillInfo1.getHeightInMetres(), hillInfo2.getHeightInMetres());
    }

}
