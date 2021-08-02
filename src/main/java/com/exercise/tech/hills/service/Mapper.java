package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.model.dto.HillInfoDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public HillInfoDto mapHillToDto(HillInfo hillInfo) {
        return HillInfoDto.builder()
                .name(hillInfo.getName())
                .category(hillInfo.getPost1997())
                .heightInMetres(hillInfo.getHeightInMetres())
                .gridRef(hillInfo.getGridRef())
                .build();
    }

}
