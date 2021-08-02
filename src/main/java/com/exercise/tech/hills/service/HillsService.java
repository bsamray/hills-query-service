package com.exercise.tech.hills.service;

import com.exercise.tech.hills.helper.QueryHelper;
import com.exercise.tech.hills.model.HillInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HillsService implements HillsServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(HillsService.class);

    @Resource
    private HillsRepository hillsRepository;

    @Override
    public List<HillInfo> getHillsInfo(List<String> categories) {
        return hillsRepository.getHillsByCategory(defaultCategoryIfNeeded(categories));
    }

    private List<String> defaultCategoryIfNeeded(List<String> categories) {
        if (categories.isEmpty()) {
            return QueryHelper.getDefaultCategories();
        }
        return categories;
    }

}
