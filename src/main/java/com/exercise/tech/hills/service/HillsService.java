package com.exercise.tech.hills.service;

import com.exercise.tech.hills.helper.QueryHelper;
import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.validation.RequestValidation;
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
    public List<HillInfo> getHillsInfo(List<String> categories, String sortBy, String order, int limit,
                                       double maxHeight, double minHeight) {
        logger.debug("Received request to get hills info");
        if (maxHeight == 0) {
            maxHeight = Double.MAX_VALUE;
        }
        RequestValidation.validate(categories, sortBy, order, limit, maxHeight, minHeight);
        List<HillInfo> hillInfoList = hillsRepository.filter(defaultCategoryIfNeeded(categories), limit, maxHeight,
                minHeight);
        if (!"".equals(sortBy.trim())) {
            hillsRepository.sort(hillInfoList, sortBy, order);
        }
        return hillInfoList;
    }

    private List<String> defaultCategoryIfNeeded(List<String> categories) {
        if (categories == null || categories.isEmpty()) {
            return QueryHelper.getDefaultCategories();
        }
        return categories;
    }

}
