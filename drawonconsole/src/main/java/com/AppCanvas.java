package com;

import com.console.InputCommand;
import com.console.InputCommandFactory;
import com.exception.InvalidInputException;
import com.model.Canvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppCanvas {
    private static Scanner scanner;
    public static void main(String[] args) throws InvalidInputException {
        scanner = new Scanner(System.in);
        Canvas canvas=null;
        while (true) {
            try {
                System.out.println("Enter command:");
                String commandLines = scanner.nextLine();
                String[] commands = commandLines.split(" "); //Nullpointer exception handle
                List<String> commandList = new ArrayList<>(Arrays.asList(commands));
                InputCommand inputCommand = InputCommandFactory.getCommandInstance(commandList, canvas);
                commandList.remove(0);
                inputCommand.validateCommand(commandList);
                canvas = inputCommand.commandAction();
                System.out.println(canvas.toString());
            }catch(InvalidInputException e){
            System.out.println(e.getMessage());
        }
        }

    }
}
