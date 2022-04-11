package com.console;

import com.exception.InvalidInputException;
import com.model.Canvas;

import java.util.List;

public class CommandQuit implements InputCommand {

    @Override
    public void validateCommand(List<String> input) throws InvalidInputException {
        if(input!=null && !input.isEmpty()){
            throw new InvalidInputException("Quit command is Wrong syntax should be like Q");
        }
    }

    @Override
    public Canvas commandAction() {
       System.exit(0);
        return null;
    }
}
