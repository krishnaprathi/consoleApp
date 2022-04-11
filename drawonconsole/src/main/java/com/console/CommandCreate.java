package com.console;

import com.exception.InvalidInputException;
import com.model.Canvas;

import java.util.List;

public class CommandCreate implements InputCommand {
    private int width;
    private int height;

       @Override
    public void validateCommand(List<String> input) throws InvalidInputException {

           if(input==null || input.isEmpty()){
               throw new InvalidInputException("Null ArgumentsCreate command is Wrong syntax should be like C 20 4");
           }
           if(input.size()!=2){
               throw new InvalidInputException("Create command is Wrong syntax should be like C 20 4");
           }
           if(!(Integer.parseInt(input.get(0))>0 && Integer.parseInt(input.get(1))>0)){
               throw new InvalidInputException("Create command arguments must be positive numbers");
           }
           width=Integer.parseInt(input.get(0));
           height=Integer.parseInt(input.get(1));
    }

    @Override
    public Canvas commandAction() {
        Canvas  canvas=new Canvas(width,height);
        return canvas;
    }
}
