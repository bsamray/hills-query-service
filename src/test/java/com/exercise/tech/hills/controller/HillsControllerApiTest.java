package com.exercise.tech.hills.controller;

import com.exercise.tech.hills.exception.InvalidApiRequestException;
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

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HillsControllerApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HillsServiceInterface hillsService;

    @MockBean
    private Mapper mapper;

    @Test
    public void testApiReturnsHills() throws Exception {
        HillInfo hillInfo = TestUtils.getHillInfo();
        when(hillsService.getHillsInfo(List.of("MUN", "TOP"), "HEIGHT", "ASC", 10, 100.0, 1000.0))
                .thenReturn(List.of(hillInfo));
        when(mapper.mapHillToDto(hillInfo)).thenReturn(TestUtils.getHillInfoDto());

        this.mockMvc.perform(get("/v1/hills")
                    .queryParam("cat", "MUN,TOP")
                .queryParam("sort", "HEIGHT")
                .queryParam("order", "ASC")
                .queryParam("limit", "10")
                .queryParam("max_ht", "100")
                .queryParam("min_ht", "1000")
                .queryParam("other", "test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Ben Lomond"))
                .andExpect(jsonPath("$[0].category").value("MUN"))
                .andExpect(jsonPath("$[0].grid_ref").value("NN773308"))
                .andExpect(jsonPath("$[0].height_in_metres").value(1044.9));
    }

    @Test
    public void testApiReturnsBadRequestForInvalidRequest() throws Exception {

        when(hillsService.getHillsInfo(List.of("MUN", "TOP"), "HEIGHT", "ASC", 10, 100.0, 1000.0))
                .thenThrow(InvalidApiRequestException.class);

        this.mockMvc.perform(get("/v1/hills")
                .queryParam("cat", "MUN,TOP")
                .queryParam("sort", "HEIGHT")
                .queryParam("order", "ASC")
                .queryParam("limit", "10")
                .queryParam("max_ht", "100")
                .queryParam("min_ht", "1000"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.source", is("api")));
    }

}
