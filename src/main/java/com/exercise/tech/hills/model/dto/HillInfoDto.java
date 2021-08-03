package com.exercise.tech.hills.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HillInfoDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("height_in_metres")
    private double heightInMetres;

    @JsonProperty("category")
    private String category;

    @JsonProperty("grid_ref")
    private String gridRef;

}
