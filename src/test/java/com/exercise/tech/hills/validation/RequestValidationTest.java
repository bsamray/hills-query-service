package com.exercise.tech.hills.validation;

import com.exercise.tech.hills.exception.InvalidApiRequestException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequestValidationTest {

    @Test
    public void testGoodRequestGoesThrough() {
        RequestValidation.validate(List.of("MUN", "TOP"), "NAME", "DESC", 10, 1000.3, 100.4);
        RequestValidation.validate(List.of(), "NAME", "DESC", 10, 1000.3, 100.4);
    }

    @Test
    public void testRequestValidation() {
        assertThrows(InvalidApiRequestException.class, () -> RequestValidation.validate(List.of("INVALID"),
                "NAME", "DESC", 10, 1000.3, 100.4));
        assertThrows(InvalidApiRequestException.class, () -> RequestValidation.validate(List.of("MUN"),
                "INVALID", "DESC", 10, 1000.3, 100.4));
        assertThrows(InvalidApiRequestException.class, () -> RequestValidation.validate(List.of("TOP"),
                "NAME", "INVALID", 10, 1000.3, 100.4));
        assertThrows(InvalidApiRequestException.class, () -> RequestValidation.validate(List.of("MUN", "TOP"), "",
                "DESC", 10, 1000.3, 100.4));
        assertThrows(InvalidApiRequestException.class, () -> RequestValidation.validate(List.of("TOP"),
                "NAME", "DESC", -1, 1000.3, 100.4));
        assertThrows(InvalidApiRequestException.class, () -> RequestValidation.validate(List.of("TOP"),
                "NAME", "DESC", 10, -1, 0));
        assertThrows(InvalidApiRequestException.class, () -> RequestValidation.validate(List.of("TOP"),
                "NAME", "DESC", 10, 100.0, 1000.6));
    }

}
