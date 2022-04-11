package com.draw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrawOnConsoleTest {

    @Test
    void testCreateCanvasOK(){
        DrawOnConsole drawOnConsole=new DrawOnConsole();
        Assertions.assertEquals(drawOnConsole.createCanvas(20,4),"----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------");
    }
    @Test
    void testCreateCanvasKO(){
        DrawOnConsole drawOnConsole=new DrawOnConsole();
    }
}
