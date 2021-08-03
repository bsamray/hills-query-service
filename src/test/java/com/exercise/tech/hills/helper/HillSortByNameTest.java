package com.exercise.tech.hills.helper;

import com.exercise.tech.hills.model.HillInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HillSortByNameTest {

    @Test
    public void testHillSortByNameDesc() {
        HillInfo hillInfo1 = new HillInfo();
        hillInfo1.setName("ab & c");
        HillInfo hillInfo2 = new HillInfo();
        hillInfo2.setName("ab & d");

        assertEquals(-1, new HillSortByName().compare(hillInfo1, hillInfo2));
    }
}
