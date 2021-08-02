package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;

import java.util.List;

public interface HillsRepository {

    List<HillInfo> filter(List<String> categories);

    List<HillInfo> sort(List<HillInfo> hills, String sortBy, String order);

}
