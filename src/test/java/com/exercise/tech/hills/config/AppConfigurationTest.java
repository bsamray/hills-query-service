package com.exercise.tech.hills.config;

import com.exercise.tech.hills.model.HillInfo;
import com.exercise.tech.hills.service.HillInfoDataSource;
import com.exercise.tech.hills.service.ReferenceDataLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AppConfigurationTest {

    private AppConfiguration appConfiguration;

    @Mock
    private ReferenceDataLoader referenceDataLoader;

    @Test
    public void testHillInfoDataSourcePopulates() {
        appConfiguration = new AppConfiguration();
        when(referenceDataLoader.load()).thenReturn(List.of(new HillInfo()));
        ReflectionTestUtils.setField(appConfiguration, "referenceDataLoader", referenceDataLoader);

        HillInfoDataSource hillInfoDataSource = appConfiguration.hillInfoDataSource();
        assertNotNull(hillInfoDataSource);
        assertEquals(1, hillInfoDataSource.getHills().size());
    }

}
