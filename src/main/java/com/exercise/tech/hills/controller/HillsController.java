package com.exercise.tech.hills.controller;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.model.dto.HillInfoDto;
import com.exercise.tech.hills.service.HillsServiceInterface;
import com.exercise.tech.hills.service.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/hills")
public class HillsController {

    private static final Logger log = LoggerFactory.getLogger(HillsController.class);

    @Resource
    private HillsServiceInterface hillsService;

    @Resource
    private Mapper mapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HillInfoDto>> getHillsInfo(
            @RequestParam (name = "cat", required = false) List<String> category,
            @RequestParam(name="sort", defaultValue = "", required = false) String sortBy,
            @RequestParam(name="order", defaultValue = "", required = false) String order,
            @RequestParam(name="limit", defaultValue = "0", required = false) int limit,
            @RequestParam(name="max_ht", defaultValue = "0", required = false) double maxHeight,
            @RequestParam(name="min_ht", defaultValue = "0", required = false) double minHeight) {
        log.debug("Received request to retrieve hills data by: ");

        List<HillInfo> hillInfoList = hillsService.getHillsInfo(category, sortBy, order, limit, maxHeight, minHeight);

        List<HillInfoDto> hillInfoDtos = hillInfoList.stream()
                .map(hillInfo -> mapper.mapHillToDto(hillInfo))
                .collect(Collectors.toList());
        return ResponseEntity.ok(hillInfoDtos);
    }
}
