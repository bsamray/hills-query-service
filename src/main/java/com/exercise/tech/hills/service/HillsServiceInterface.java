package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;

import java.util.List;

public interface HillsServiceInterface {
    List<HillInfo> getHillsInfo(List<String> category);
}