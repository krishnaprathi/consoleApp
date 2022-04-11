package com.console;

import com.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandLinTest {
    @Test
    void testLineCommandParamKO()  {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandLin("L 20")
        );
    }

    @Test
    void testLineCommandParamKO2()  {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandLin("L 20 -4 20 -5")
        );
    }

    @Test
    void testLineCommandParamKO3()  {
        assertThrows(
                NumberFormatException.class,
                () -> new CommandLin("L L -4 20 -5")
        );
    }
}
