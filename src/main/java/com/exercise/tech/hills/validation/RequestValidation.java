package com.exercise.tech.hills.validation;

import com.exercise.tech.hills.exception.InvalidApiRequestException;
import com.exercise.tech.hills.helper.QueryHelper;

import java.util.ArrayList;
import java.util.List;

public class RequestValidation {

    public static void validate(List<String> category, String sortBy, String order, int limit,double maxHeight,
                                double minHeight) {
        List<String> errors = new ArrayList<>();
        if (hasInvalidCategory(category)) {
            errors.add("Invalid category presented in query");
        }

        if (isInvalidSort(sortBy)) {
            errors.add("Invalid sort presented in query");
        }

        if (isInvalidOrder(order)) {
            errors.add("Invalid order presented in query");
        }

        if (isOrderWithoutSort(sortBy, order)) {
            errors.add("Order must be accompanied by a sort input");
        }

        if (isInvalidLimit(limit)) {
            errors.add("Invalid limit presented in query");
        }

        if (isInvalidHeight(minHeight, maxHeight) || isInvalidHeightCombination(minHeight, maxHeight)) {
            errors.add("Invalid height presented in query");
        }

        if (!errors.isEmpty()) {
            throw new InvalidApiRequestException(errors.toString());
        }

    }

    private static boolean hasInvalidCategory(List<String> categories) {
        return categories != null &&
                categories.stream().anyMatch(category -> !QueryHelper.getDefaultCategories().contains(category));
    }

    private static boolean isInvalidOrder(String order) {
        return !List.of("", "ASC", "DESC").contains(order);
    }

    private static boolean isOrderWithoutSort(String sort, String order) {
        return "".equals(sort) && !"".equals(order);
    }

    private static boolean isInvalidSort(String sort) {
        return !List.of("", "HEIGHT", "NAME").contains(sort);
    }

    private static boolean isInvalidLimit(int limit) {
        return limit < 0;
    }

    private static boolean isInvalidHeight(double minHeight, double maxHeight) {
        return minHeight < 0 || maxHeight < 0;
    }

    private static boolean isInvalidHeightCombination(double minHeight, double maxHeight) {
        return minHeight > maxHeight;
    }

}
