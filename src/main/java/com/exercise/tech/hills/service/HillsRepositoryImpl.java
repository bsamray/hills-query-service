package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HillsRepositoryImpl implements HillsRepository {

    @Resource
    private HillInfoDataSource hillInfoDataSource;

    @Override
    public List<HillInfo> getHillsByCategory(List<String> categories) {
        return hillInfoDataSource.getHills().parallelStream()
                .filter(hillInfo -> categories.contains(hillInfo.getPost1997()))
                .collect(Collectors.toList());
    }
}
