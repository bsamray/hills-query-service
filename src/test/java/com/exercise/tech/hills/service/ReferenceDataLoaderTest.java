package com.exercise.tech.hills.service;

import com.exercise.tech.hills.exception.ReferenceDataLoadException;
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

    @Test
    public void testPriceChartLoadErrorsWhenFileWithHeaderOnly() {
        referenceDataLoader = new CsvReferenceDataLoader();
        ReflectionTestUtils.setField(referenceDataLoader, "fileName", "munro_headeronly.csv");

        assertThrows(ReferenceDataLoadException.class, () -> referenceDataLoader.load());
    }

    @Test
    public void testPriceChartLoadErrorsWhenEmptyFile() {
        referenceDataLoader = new CsvReferenceDataLoader();
        ReflectionTestUtils.setField(referenceDataLoader, "fileName", "munro_empty.csv");

        assertThrows(ReferenceDataLoadException.class, () -> referenceDataLoader.load());
    }

}
