package com.exercise.tech.hills.service;

import com.exercise.tech.hills.helper.QueryHelper;
import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HillsServiceTest {

    @InjectMocks
    HillsService hillsService;

    @Mock
    HillsRepository hillsRepository;

    @Test
    public void testGetHillsNoCategoryAndDescHeight() {
        List<HillInfo> input = TestUtils.getHillInfoList();
        when(hillsRepository.filter(QueryHelper.getDefaultCategories(), 10, 1000.0, 1000.0))
                .thenReturn(input);
        when(hillsRepository.sort(input, "HEIGHT", "DESC")).thenReturn(input);

        List<HillInfo> hillInfoList = hillsService.getHillsInfo(List.of(), "HEIGHT", "DESC", 10, 1000.0, 1000.0);

        assertEquals(5, hillInfoList.size());
    }

    @Test
    public void testGetHillsSingleCategory() {
        List<HillInfo> input = List.of(TestUtils.getHillInfo());
        when(hillsRepository.filter(List.of("MUN"), 10, 1000.6, 1000.0)).thenReturn(input);
        when(hillsRepository.sort(input, "NAME", "")).thenReturn(input);

        List<HillInfo> hillInfoList = hillsService.getHillsInfo(List.of("MUN"), "NAME", "", 10, 1000.6, 1000.0);

        assertEquals(input.size(), hillInfoList.size());
    }

    @Test
    public void testGetHillsUsesDoubleMaxAsDefaultValue() {
        List<HillInfo> input = List.of(TestUtils.getHillInfo());
        when(hillsRepository.filter(List.of("MUN"), 10, Double.MAX_VALUE, 1000.0)).thenReturn(input);
        when(hillsRepository.sort(input, "NAME", "")).thenReturn(input);

        List<HillInfo> hillInfoList = hillsService.getHillsInfo(List.of("MUN"), "NAME", "", 10, 0, 1000.0);

        assertEquals(input.size(), hillInfoList.size());
    }


    @Test
    public void testGetHillsNoCategoryAndAscHeight() {
        List<HillInfo> input = TestUtils.getHillInfoList();
        when(hillsRepository.filter(QueryHelper.getDefaultCategories(), 10, 1000.0, 1000.0)).thenReturn(input);

        List<HillInfo> hillInfoList = hillsService.getHillsInfo(List.of(), "", "", 10, 1000.0, 1000.0);

        assertEquals(5, hillInfoList.size());
    }

}
