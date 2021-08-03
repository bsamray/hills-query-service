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
    public void testFilterByMultipleCategories() {
        List<HillInfo> hillInfoList = TestUtils.getHillInfoList();
        when(hillInfoDataSource.getHills()).thenReturn(hillInfoList);

        List<HillInfo> hillsByCategory = hillsRepository.filter(List.of("MUN", "TOP"), 2, 1000.4, 1000.2);

        assertEquals(2, hillsByCategory.size());
        assertTrue(List.of(1000.2, 1000.3).contains(hillsByCategory.get(0).getHeightInMetres()));
        assertTrue(List.of(1000.2, 1000.3).contains(hillsByCategory.get(1).getHeightInMetres()));
//        assertTrue(List.of("MUN", "TOP").contains(hillsByCategory.get(0).getPost1997()));
//        assertTrue(List.of(1).contains(hillsByCategory.get(0).getHeightInMetres()));
//        assertTrue(List.of("MUN", "TOP").contains(hillsByCategory.get(1).getPost1997()));
//        assertTrue(List.of("MUN", "TOP").contains(hillsByCategory.get(1).getPost1997()));
    }

    @Test
    public void testFilterBySingleCategory() {
        List<HillInfo> hillInfoList = TestUtils.getHillInfoList();
        when(hillInfoDataSource.getHills()).thenReturn(hillInfoList);

        List<HillInfo> hillsByCategory = hillsRepository.filter(List.of("MUN"), 10, 1000.4, 1000.2);

        assertEquals(1, hillsByCategory.size());
        assertEquals("MUN", hillsByCategory.get(0).getPost1997());
        assertEquals(1000.3, hillsByCategory.get(0).getHeightInMetres());
    }

    @Test
    public void testNameSortAscending() {
        List<HillInfo> hillInfoList = TestUtils.getHillInfoList();

        List<HillInfo> sortedRes = hillsRepository.sort(hillInfoList, "NAME", "");

        assertEquals(5, sortedRes.size());
        assertEquals("name1", sortedRes.get(0).getName());
        assertEquals("name2", sortedRes.get(1).getName());
        assertEquals("name3", sortedRes.get(2).getName());
        assertEquals("name4", sortedRes.get(3).getName());
        assertEquals("name5", sortedRes.get(4).getName());
    }

    @Test
    public void testNameSortDescending() {
        List<HillInfo> hillInfoList = TestUtils.getHillInfoList();

        List<HillInfo> sortedRes = hillsRepository.sort(hillInfoList, "NAME", "DESC");

        assertEquals(5, sortedRes.size());
        assertEquals("name5", sortedRes.get(0).getName());
        assertEquals("name4", sortedRes.get(1).getName());
        assertEquals("name3", sortedRes.get(2).getName());
        assertEquals("name2", sortedRes.get(3).getName());
        assertEquals("name1", sortedRes.get(4).getName());
    }

    @Test
    public void testHeightSortAscending() {
        List<HillInfo> hillInfoList = TestUtils.getHillInfoList();

        List<HillInfo> sortedRes = hillsRepository.sort(hillInfoList, "HEIGHT", "");

        assertEquals(5, sortedRes.size());
        assertEquals(1000.1, sortedRes.get(0).getHeightInMetres());
        assertEquals(1000.2, sortedRes.get(1).getHeightInMetres());
        assertEquals(1000.3, sortedRes.get(2).getHeightInMetres());
        assertEquals(1000.4, sortedRes.get(3).getHeightInMetres());
        assertEquals(1000.5, sortedRes.get(4).getHeightInMetres());
    }

    @Test
    public void testHeightSortDescending() {
        List<HillInfo> hillInfoList = TestUtils.getHillInfoList();

        List<HillInfo> sortedRes = hillsRepository.sort(hillInfoList, "HEIGHT", "DESC");

        assertEquals(5, sortedRes.size());
        assertEquals(1000.5, sortedRes.get(0).getHeightInMetres());
        assertEquals(1000.4, sortedRes.get(1).getHeightInMetres());
        assertEquals(1000.3, sortedRes.get(2).getHeightInMetres());
        assertEquals(1000.2, sortedRes.get(3).getHeightInMetres());
        assertEquals(1000.1, sortedRes.get(4).getHeightInMetres());
    }

}
