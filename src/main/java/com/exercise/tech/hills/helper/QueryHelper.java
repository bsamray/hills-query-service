package com.exercise.tech.hills.helper;

import java.util.List;

public class QueryHelper {

    private static final List<String> DEFAULT_CATEGORIES = List.of("MUN", "TOP");

    public static List<String> getDefaultCategories() {
        return DEFAULT_CATEGORIES;
    }

}
