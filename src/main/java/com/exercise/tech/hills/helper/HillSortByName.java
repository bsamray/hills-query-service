package com.exercise.tech.hills.helper;

import com.exercise.tech.hills.model.HillInfo;

import java.util.Comparator;

public class HillSortByName implements Comparator<HillInfo> {

    public int compare(HillInfo hillInfo1, HillInfo hillInfo2) {
        return hillInfo1.getName().compareTo(hillInfo2.getName());
    }

}