package com.exercise.tech.hills.service;

import com.exercise.tech.hills.helper.HillSortByHeight;
import com.exercise.tech.hills.helper.HillSortByName;
import com.exercise.tech.hills.model.HillInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HillsRepositoryImpl implements HillsRepository {

    private static final Logger logger = LoggerFactory.getLogger(HillsRepositoryImpl.class);

    @Resource
    private HillInfoDataSource hillInfoDataSource;

    @Override
    public List<HillInfo> filter(List<String> categories) {
        logger.debug("Filtering by categories: ({})", categories.toString());
        return hillInfoDataSource.getHills().parallelStream()
                .filter(hillInfo -> categories.contains(hillInfo.getPost1997()))
                .collect(Collectors.toList());
    }

    @Override
    public List<HillInfo> sort(List<HillInfo> hills, String sortBy, String order) {
        logger.debug("Sorting input list by sort ({}) and order ({})", sortBy, order);
        if ("HEIGHT".equals(sortBy)) {
            if ("DESC".equals(order)) {
                hills.sort(new HillSortByHeight().reversed());
            } else {
                hills.sort(new HillSortByHeight());
            }
        } else if ("NAME".equals(sortBy)) {
            if ("DESC".equals(order)) {
                hills.sort(new HillSortByName().reversed());
            } else {
                hills.sort(new HillSortByName());
            }
        }
        return hills;
    }
}
