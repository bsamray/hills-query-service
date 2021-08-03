package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;

import java.util.List;

public interface HillsRepository {

    List<HillInfo> filter(List<String> categories, int limit, double maxHeight, double minHeight);

    List<HillInfo> sort(List<HillInfo> hills, String sortBy, String order);

}
