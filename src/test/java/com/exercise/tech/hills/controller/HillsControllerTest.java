package com.exercise.tech.hills.controller;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.model.dto.HillInfoDto;
import com.exercise.tech.hills.service.HillsServiceInterface;
import com.exercise.tech.hills.service.Mapper;
import com.exercise.tech.hills.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class HillsControllerTest {

    @InjectMocks
    HillsController hillsController;

    @Mock
    HillsServiceInterface hillsServiceInterface;

    @Mock
    Mapper mapper;

    @Test
    public void testFilterByCategory() {
        HillInfo hillInfo = TestUtils.getHillInfo();
        HillInfoDto hillInfoDto = TestUtils.getHillInfoDto();
        when(hillsServiceInterface.getHillsInfo(anyList(), anyString(), anyString(), anyInt(), anyDouble(),
                anyDouble())).thenReturn(List.of(hillInfo));
        when(mapper.mapHillToDto(hillInfo)).thenReturn(hillInfoDto);

        ResponseEntity<List<HillInfoDto>> hills = hillsController.getHillsInfo(List.of("MUN"), "", "",
                10, 100.0, 1000.3);

        assertNotNull(hills.getBody());
        assertEquals(1, hills.getBody().size());
        HillInfoDto resDto = hills.getBody().get(0);
        assertEquals(hillInfoDto.getName(), resDto.getName());
        assertEquals(hillInfoDto.getCategory(), resDto.getCategory());
        assertEquals(hillInfoDto.getHeightInMetres(), resDto.getHeightInMetres());
        assertEquals(hillInfoDto.getGridRef(), resDto.getGridRef());
    }
}
