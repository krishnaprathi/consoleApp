package com.console;

import com.exception.InvalidInputException;
import com.model.Canvas;

import java.util.List;

public interface InputCommand {
    void validateCommand(List<String> input) throws InvalidInputException;
    Canvas commandAction();
}
