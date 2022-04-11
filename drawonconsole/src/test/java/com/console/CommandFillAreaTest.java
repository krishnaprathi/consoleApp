package com.console;

import com.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandFillAreaTest {
    @Test
    void testFillAreaCommandCommandParamKO() {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandFillArea("B 20")
        );
    }

    @Test
    void testFillAreaCommandCommandParamKO2()  {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandFillArea("B 10 -1 o")
        );
    }

    @Test
    void testFillAreaCommandCommandParamKO3()  {
        assertThrows(
                NumberFormatException.class,
                () -> new CommandFillArea("B B -1 o")
        );
    }
}
