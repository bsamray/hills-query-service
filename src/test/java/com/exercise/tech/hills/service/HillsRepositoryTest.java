package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HillsRepositoryTest {

    @InjectMocks
    HillsRepositoryImpl hillsRepository;

    @Mock
    HillInfoDataSource hillInfoDataSource;

    @Test
    public void testGetHillsFiltersByMultipleCategories() {
        List<HillInfo> hillInfoList = TestUtils.getHillInfoList();
        when(hillInfoDataSource.getHills()).thenReturn(hillInfoList);

        List<HillInfo> hillsByCategory = hillsRepository.getHillsByCategory(List.of("MUN", "TOP"));

        assertEquals(3, hillsByCategory.size());
        assertTrue(List.of("MUN", "TOP").contains(hillsByCategory.get(0).getPost1997()));
        assertTrue(List.of("MUN", "TOP").contains(hillsByCategory.get(1).getPost1997()));
        assertTrue(List.of("MUN", "TOP").contains(hillsByCategory.get(2).getPost1997()));
    }

    @Test
    public void testGetHillsFiltersBySingleCategory() {
        List<HillInfo> hillInfoList = TestUtils.getHillInfoList();
        when(hillInfoDataSource.getHills()).thenReturn(hillInfoList);

        List<HillInfo> hillsByCategory = hillsRepository.getHillsByCategory(List.of("MUN"));

        assertEquals(2, hillsByCategory.size());
        assertEquals("MUN", hillsByCategory.get(0).getPost1997());
    }




}
