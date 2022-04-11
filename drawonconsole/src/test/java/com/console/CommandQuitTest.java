package com.console;

import com.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandQuitTest {
    @Test
    void testQuitCommandParamKO() throws InvalidInputException {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandQuit("Q 20")
        );
    }


}
