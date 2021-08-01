package com.exercise.tech.hills.service;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReferenceDataLoaderTest {

    private ReferenceDataLoader referenceDataLoader;

    @Test
    public void testPriceChartLoadsWithValidFile() {
        referenceDataLoader = new CsvReferenceDataLoader();
        ReflectionTestUtils.setField(referenceDataLoader, "fileName", "munro_good.csv");

        List hillInfoList = referenceDataLoader.load();

        assertNotNull(hillInfoList);
        assertEquals(1, hillInfoList.size());
    }

    @Test
    public void testPriceChartLoadErrorsWhenBadFile() {
        referenceDataLoader = new CsvReferenceDataLoader();
        ReflectionTestUtils.setField(referenceDataLoader, "fileName", "munro_bad.csv");

        assertThrows(RuntimeException.class, () -> referenceDataLoader.load());
    }

}
