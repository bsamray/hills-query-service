package com.exercise.tech.hills.service;

import com.exercise.tech.hills.model.HillInfo;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Service
public class CsvReferenceDataLoader implements ReferenceDataLoader {

    private static final Logger logger = LoggerFactory.getLogger(CsvReferenceDataLoader.class);

    @Value("${application.ref-data-file}")
    private String fileName;

    @Override
    @SuppressWarnings("unchecked")
    public List<HillInfo> load() {
        logger.debug("Loading hills data into the system from file ({})", fileName);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        return new CsvToBeanBuilder(reader)
                .withType(HillInfo.class)
                .withSkipLines(1)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
    }

}
