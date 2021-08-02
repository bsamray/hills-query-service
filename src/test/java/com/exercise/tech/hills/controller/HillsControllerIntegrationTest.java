package com.exercise.tech.hills.controller;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.service.HillsServiceInterface;
import com.exercise.tech.hills.service.Mapper;
import com.exercise.tech.hills.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HillsControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HillsServiceInterface hillsService;

    @MockBean
    private Mapper mapper;

    @Test
    public void testApiReturnsHills() throws Exception {
        HillInfo hillInfo = TestUtils.getHillInfo();
        when(hillsService.getHillsInfo(List.of("MUN", "TOP"))).thenReturn(List.of(hillInfo));
        when(mapper.mapHillToDto(hillInfo)).thenReturn(TestUtils.getHillInfoDto());

        this.mockMvc.perform(get("/v1/hills")
                    .queryParam("cat", "MUN,TOP"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Ben Lomond"))
                .andExpect(jsonPath("$[0].category").value("Munro"))
                .andExpect(jsonPath("$[0].grid_ref").value("NN773308"))
                .andExpect(jsonPath("$[0].height_in_metres").value(1044.9));
    }

}
