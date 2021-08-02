package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.model.dto.HillInfoDto;
import com.exercise.tech.hills.utils.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MapperTest {

    @Test
    public void testHillInfoToDtoMapping() {
        HillInfo hillInfo = TestUtils.getHillInfo();
        Mapper mapper = new Mapper();

        HillInfoDto hillInfoDto = mapper.mapHillToDto(hillInfo);

        assertNotNull(hillInfoDto);
        assertEquals(hillInfo.getName(), hillInfoDto.getName());
        assertEquals(hillInfo.getPost1997(), hillInfoDto.getCategory());
        assertEquals(hillInfo.getHeightInMetres(), hillInfoDto.getHeightInMetres());
        assertEquals(hillInfo.getGridRef(), hillInfoDto.getGridRef());
    }

}
