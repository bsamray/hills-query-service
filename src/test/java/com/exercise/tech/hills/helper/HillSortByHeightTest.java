package com.exercise.tech.hills.helper;

import com.exercise.tech.hills.model.HillInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HillSortByHeightTest {

    @Test
    public void testHillSortByHeightDesc() {
        HillInfo hillInfo1 = new HillInfo();
        hillInfo1.setHeightInMetres(100.1);
        HillInfo hillInfo2 = new HillInfo();
        hillInfo2.setHeightInMetres(100.2);

        assertEquals(-1, new HillSortByHeight().compare(hillInfo1, hillInfo2));
    }

}
