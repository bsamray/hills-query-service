package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;

import java.util.List;

public class HillInfoDataSource {

    private List<HillInfo> hills;

    public HillInfoDataSource(List<HillInfo> hills) {
        this.hills = hills;
    }

    public List<HillInfo> getHills() {
        return hills;
    }
}
