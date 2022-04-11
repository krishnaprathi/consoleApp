package com.console;

import com.exception.InvalidInputException;
import com.model.Canvas;

import java.util.List;

public class CommandRectangle implements InputCommand {
    private Canvas canvas;
    private int x1,x2,y1,y2;
    public CommandRectangle(Canvas canvas) throws InvalidInputException {
        if(canvas!=null){
            this.canvas=canvas;
        }else{
            throw new InvalidInputException("Please create a canvas before drawing a rectangle");
        }
    }

    @Override
    public void validateCommand(List<String> input) throws InvalidInputException {
        if(input==null || input.isEmpty()){
            throw new InvalidInputException("Null Arguments Draw Rectangle command is Wrong syntax should be like L x1 y1 x2 y2");
        }
        if(input.size()!=4){
            throw new InvalidInputException("Rectangle command is Wrong syntax should be like R 14 1 18 3");
        }
        if(!(Integer.parseInt(input.get(0))>0
                && Integer.parseInt(input.get(1))>0
                && Integer.parseInt(input.get(2))>0
                && Integer.parseInt(input.get(3))>0)){
            throw new InvalidInputException("Rectangle command arguments must be positive numbers");
        }
        x1=Integer.parseInt(input.get(0));
        y1=Integer.parseInt(input.get(1));
        x2=Integer.parseInt(input.get(2));
        y2=Integer.parseInt(input.get(3));
        if((x1>x2) || (y1>y2)){
            throw new InvalidInputException("Rectangle command arguments should be like x1>x2 or y1>y2 ");
        }
        if(x1>canvas.width-2 || x2>canvas.width-2 || y1>canvas.height-2 || y2>canvas.height-2 ){
            throw new InvalidInputException("Rectangle command arguments must be in canvas");
        }
    }

    @Override
    public Canvas commandAction() {
        for(int i=y1;i<=y2;i++){
            for(int j=x1;j<=x2;j++){
                if(i==y1 || i==y2 || j==x1 || j==x2)
                    canvas.canvasArray[j][i]=canvas.line_char;
                else
                    canvas.canvasArray[j][i]=canvas.empty_char;
            }
        }
        return canvas;
    }
}
