package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;

import java.util.List;

public interface HillsRepository {

    List<HillInfo> getHillsByCategory(List<String> categories);

}
