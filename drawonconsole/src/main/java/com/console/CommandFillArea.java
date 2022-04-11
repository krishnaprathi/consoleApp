package com.console;

import com.exception.InvalidInputException;
import com.model.Canvas;

import java.util.List;

public class CommandFillArea implements InputCommand {
    private Canvas canvas;
    private int x,y;
    private char color;
    public CommandFillArea(Canvas canvas) throws InvalidInputException {
        if(canvas!=null){
            this.canvas=canvas;
        }else{
            throw new InvalidInputException("Please create a canvas and fill area.");
        }
    }

    @Override
    public void validateCommand(List<String> input) throws InvalidInputException {
        if(input==null || input.isEmpty()){
            throw new InvalidInputException("Null Arguments Fill Area command is Wrong syntax should be like B x y c");
        }
        if(input.size()!=3){
            throw new InvalidInputException("Fill Area command is Wrong syntax should be like B x y c");
        }
        if(!(Integer.parseInt(input.get(0))>0
                && Integer.parseInt(input.get(1))>0)){
            throw new InvalidInputException("Fill area first two command arguments must be positive numbers");
        }

        x=Integer.parseInt(input.get(0));
        y=Integer.parseInt(input.get(1));
        color=input.get(2).charAt(0);

        if(x>canvas.width-2 || y>canvas.height-2 ){
            throw new InvalidInputException("Fill Area command arguments must be in canvas");
        }
    }

    @Override
    public Canvas commandAction() {
       fillArea(x,y);
        return canvas;
    }

    private Canvas fillArea(int x, int y) {
        if (canvas.canvasArray[x][y] != canvas.empty_char) {
            return canvas;
        }

        if (x > 0 || x < canvas.height-2 || y > 0 || y < canvas.width-2) {
            if (canvas.canvasArray[x][y] == canvas.empty_char)
                canvas.canvasArray[x][y] = color;
            fillArea(x + 1, y);
            fillArea(x - 1, y);
            fillArea(x, y - 1);
            fillArea(x, y + 1);
        }
        return canvas;
    }
}
