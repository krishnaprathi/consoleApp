package com.model;

public class Canvas {
    private static final char vertical_char='|';
    private static final char horizontal_char='-';
    public final char empty_char=' ';
    public final char line_char='x';
    public int width,height;
    public char[][] canvasArray;

    @Override
    public String toString() {
       StringBuilder stringBuilder=new StringBuilder();
        for(int i=0; i<height;i++) {
            for (int j = 0; j < width; j++) {
                stringBuilder.append(canvasArray[j][i]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Canvas(int wid, int heit){
        width=wid+2;
        height=heit+2;
        canvasArray =new char[width][height];
        for(int i=0; i<height;i++){
            for(int j=0; j<width;j++){
                if(i==0 || i==height-1){
                    canvasArray[j][i]=horizontal_char;
                }
                else if(j==0 || j==width-1){
                    canvasArray[j][i]=vertical_char;
                } else{
                    canvasArray[j][i]=empty_char;
                }
            }
        }
        
    }
    
}
