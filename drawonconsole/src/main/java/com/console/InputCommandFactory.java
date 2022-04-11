package com.console;

import com.exception.InvalidInputException;
import com.model.Canvas;

import java.util.List;
import java.util.Locale;

public class InputCommandFactory {

    public static InputCommand getCommandInstance(List<String> inputList, Canvas canvas)
            throws InvalidInputException {
        if(inputList!=null && !inputList.isEmpty()){
            char first = inputList.get(0).toUpperCase(Locale.ROOT).charAt(0);//make uppercase
           switch (first){
               case 'C':
                   return new CommandCreate();
               case 'L':
                   return new CommandLin(canvas);
               case 'R':
                   return new CommandRectangle(canvas);
               case 'B':
                   return new CommandFillArea(canvas);
               case 'Q':
                   return new CommandQuit();
               default:
                   throw new InvalidInputException("Invalid input");
           }
        }
        throw new InvalidInputException("Invalid input");
    }
}
