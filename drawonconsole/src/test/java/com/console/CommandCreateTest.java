package com.console;

import com.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandCreateTest {

    @Test
    void testCreateCommandParamKO()  {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandCreate().draw("C 20")
        );
    }

    @Test
    void testCreateCommandParamKO2()  {
        assertThrows(
                InvalidInputException.class,
                () -> new CommandCreate().draw("C 20 -4")
        );
    }

    @Test
    void testCreateCommandParamKO3()  {
        assertThrows(
                NumberFormatException.class,
                () -> new CommandCreate().draw("C C -4")
        );
    }

    @Test
    void testCreateCommandParamOK() throws InvalidInputException {
      //  Assertions.assertEquals(new CommandCreate().draw("C 20 -4") ,3);
    }

}
