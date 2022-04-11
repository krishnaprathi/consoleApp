package com.console;
import com.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidationTest {
        @Test
        void testCreateCommandOK() throws InvalidInputException {
        InputCommandFactory input=new InputCommandFactory();
        Assertions.assertEquals(input.validateInput("C 20 4") instanceof CommandCreate,true);
        }

        @Test
        void testLineCommandOK() throws InvalidInputException {
                InputCommandFactory input=new InputCommandFactory();
                Assertions.assertEquals(input.validateInput("L 1 2 6 2") instanceof CommandLin,true);
        }

        @Test
        void testRectangleCommandOK() throws InvalidInputException {
                InputCommandFactory input=new InputCommandFactory();
                Assertions.assertEquals(input.validateInput("R 14 1 18 3") instanceof CommandRectangle,true);
        }

        @Test
        void testAreaFillCommandOK() throws InvalidInputException {
                InputCommandFactory input=new InputCommandFactory();
                Assertions.assertEquals(input.getCommandInstance("B 10 3 o") instanceof CommandFillArea,true);
        }

        @Test
        void testQuitCommandOK() throws InvalidInputException {
                InputCommandFactory input=new InputCommandFactory();
                Assertions.assertEquals(input.validateInput("Q") instanceof CommandQuit,true);
        }

        @Test
        void testEmptyCommandKO() throws InvalidInputException {
                InputCommandFactory input=new InputCommandFactory();
                assertThrows(
                        InvalidInputException.class,
                        () -> input.validateInput("")
                );
        }

        @Test
        void testInputCommandKO() throws InvalidInputException {
                InputCommandFactory input=new InputCommandFactory();
                assertThrows(
                        InvalidInputException.class,
                        () -> input.validateInput("K 20 4")
                );
        }

}
