package com.exercise.tech.hills.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class HillInfo {

    @CsvBindByPosition(position = 0, required = true)
    private int runningNo;

    @CsvBindByPosition(position = 1, required = true)
    private int dobihNo;

    @CsvBindByPosition(position = 2, required = true)
    private String streetMapLink;

    @CsvBindByPosition(position = 3, required = true)
    private String geographLink;

    @CsvBindByPosition(position = 4, required = true)
    private String hillBraggingLink;

    @CsvBindByPosition(position = 5, required = true)
    private String name;

    @CsvBindByPosition(position = 6, required = true)
    private int smcSection;

    @CsvBindByPosition(position = 7, required = true)
    private String rhbSection;

    @CsvBindByPosition(position = 8, required = true)
    private double section;

    @CsvBindByPosition(position = 9, required = true)
    private double heightInFeet;

    @CsvBindByPosition(position = 10, required = true)
    private double heightInMetres;

    @CsvBindByPosition(position = 11, required = true)
    private String map1To50;

    @CsvBindByPosition(position = 12, required = true)
    private String map1To25;

    @CsvBindByPosition(position = 13, required = true)
    private String gridRef;

    @CsvBindByPosition(position = 14, required = true)
    private String gridRefXY;

    @CsvBindByPosition(position = 15, required = true)
    private int xCoord;

    @CsvBindByPosition(position = 16, required = true)
    private int yCoord;

    @CsvBindByPosition(position = 17)
    private String col1891;

    @CsvBindByPosition(position = 18)
    private String col1921;

    @CsvBindByPosition(position = 19)
    private String col1933;

    @CsvBindByPosition(position = 20)
    private String col1953;

    @CsvBindByPosition(position = 21)
    private String col1969;

    @CsvBindByPosition(position = 22)
    private String col1974;

    @CsvBindByPosition(position = 23)
    private String col1981;

    @CsvBindByPosition(position = 24)
    private String col1984;

    @CsvBindByPosition(position = 25)
    private String col1990;

    @CsvBindByPosition(position = 26)
    private String col1997;

    @CsvBindByPosition(position = 27)
    private String post1997;

    @CsvBindByPosition(position = 28)
    private String comments;

}
