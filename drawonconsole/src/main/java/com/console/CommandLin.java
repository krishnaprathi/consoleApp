package com.console;

import com.exception.InvalidInputException;
import com.model.Canvas;

import java.util.List;

public class CommandLin implements InputCommand {
    private Canvas canvas;
    private int x1,x2,y1,y2;
    public CommandLin(Canvas canvas) throws InvalidInputException {
        if(canvas!=null){
            this.canvas=canvas;
        }else{
            throw new InvalidInputException("Please create a canvas and draw a line");
        }
    }


    @Override
    public void validateCommand(List<String> input) throws InvalidInputException {
        if(input==null || input.isEmpty()){
            throw new InvalidInputException("Null Arguments Draw Line command is Wrong syntax should be like L x1 y1 x2 y2");
        }
        if(input.size()!=4){
            throw new InvalidInputException("Draw Line command is Wrong syntax should be like  L 6 3 6 4");
        }
        if(!(Integer.parseInt(input.get(0))>0
                && Integer.parseInt(input.get(1))>0
                && Integer.parseInt(input.get(2))>0
                && Integer.parseInt(input.get(3))>0)){
            throw new InvalidInputException("Line command arguments must be positive numbers");
        }
        x1=Integer.parseInt(input.get(0));
        y1=Integer.parseInt(input.get(1));
        x2=Integer.parseInt(input.get(2));
        y2=Integer.parseInt(input.get(3));
        if((x1!=x2)&&(y1!=y2)){
            throw new InvalidInputException("Line command arguments currently supports either horizontal or vertical lines");
        }
        if((x1>x2) || (y1>y2)){
            throw new InvalidInputException("Line command arguments should be like x1>x2 or y1>y2 ");
        }
        if(x1>canvas.width-2 || x2>canvas.width-2 || y1>canvas.height-2 || y2>canvas.height-2 ){
            throw new InvalidInputException("Line command arguments must be in canvas");
        }
    }

    @Override
    public Canvas commandAction() {
        if(x1==x2){
            for(int i=y1;i<=y2;i++){
                canvas.canvasArray[x1][i]=canvas.line_char;
            }
        }else{
            for(int i=x1;i<=x2;i++){
                canvas.canvasArray[i][y1]=canvas.line_char;
            }
        }
        return canvas;
    }
}
