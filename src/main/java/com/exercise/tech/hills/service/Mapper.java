package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.model.dto.HillInfoDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public HillInfoDto mapHillToDto(HillInfo hillInfo) {
        return HillInfoDto.builder()
                .name(hillInfo.getName())
                .category(mapToReadableCategory(hillInfo.getPost1997()))
                .heightInMetres(hillInfo.getHeightInMetres())
                .gridRef(hillInfo.getGridRef())
                .build();
    }

    String mapToReadableCategory(String shortCategory) {
        String readableCategory = "";
        switch(shortCategory) {
            case "MUN":
                readableCategory = "Munro";
                break;
            case "TOP":
                readableCategory = "Munro Top";
        }
        return readableCategory;
    }

}
