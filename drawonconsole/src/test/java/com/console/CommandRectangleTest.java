package com.console;

import com.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandRectangleTest {
    @Test
    void testRectangleCommandParamKO() throws InvalidInputException {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandRectangle("R 20")
        );
    }

    @Test
    void testRectangleCommandParamKO2()  {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandRectangle("R 14 1 18 -3")
        );
    }

    @Test
    void testRectangleCommandParamKO3()  {
        assertThrows(
                NumberFormatException.class,
                () -> new CommandRectangle("R R 1 18 -3")
        );
    }
}
