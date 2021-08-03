package com.exercise.tech.hills;

import com.exercise.tech.hills.service.ReferenceDataLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HillsQueryServiceApplicationTests {

	@Resource
	private ReferenceDataLoader referenceDataLoader;

	@Test
	void contextLoads() {
		assertThat(referenceDataLoader).isNotNull();
	}

}
