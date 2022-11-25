/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author acoon
 */
public class RectangleState extends EditorState{
    private final Pane pane;
    private final ObservableList<SerializableShape> list;
        
    public RectangleState(Pane pane, ObservableList<SerializableShape> list) {
        this.list = list;
        this.pane = pane;
    }
    
    @Override
    public void draw(double x1, double y1, double x2, double y2, Color strokeColor) {
        double width;
        double height;
        width = x2 - x1;    
        height = y2 - y1;
        if(width < 0 ){
            x1 = width + x1;
            width = -width;
        }
        if(height < 0){
            y1 = height + y1;
            height = -height;
        }
        SerializableRectangle rect = new SerializableRectangle(x1,y1,width,height,strokeColor);
        this.list.add(rect);
        this.pane.getChildren().add(rect.getShape());
    }


    @Override
    public void draw(double x1, double y1, double x2, double y2, Color strokeColor, Color fillColor) {
        double width;
        double height;
        width = x2 - x1;    
        height = y2 - y1;
        if(width < 0 ){
            x1 = width + x1;
            width = -width;
        }
        if(height < 0){
            y1 = height + y1;
            height = -height;
        }

        SerializableRectangle rect = new SerializableRectangle(x1,y1,width,height,strokeColor,fillColor);
        this.list.add(rect);
        this.pane.getChildren().add(rect.getShape());
    }

  
}
