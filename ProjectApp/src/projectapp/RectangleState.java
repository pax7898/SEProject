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
    public void draw(double d, double d1, double d2, double d3, Color strokeColor) {
        d2 = d2 - d;
        d3 = d3 - d1;
        if(d2 < 0 ){
            d = d2 + d;
            d2 = -d2;
        }
        if(d3 < 0){
            double appoggio = d1;
            d1 = d3 + d1;
            d3 = -d3;
        }
        SerializableRectangle rect = new SerializableRectangle(d,d1,d2,d3,strokeColor);
        this.list.add(rect);
        this.pane.getChildren().add(rect.getShape());
    }


    @Override
    public void draw(double d, double d1, double d2, double d3, Color strokeColor, Color fillColor) {
        d2 = d2 - d;
        d3 = d3 - d1;
        if(d2 < 0 ){
            d = d2 + d;
            d2 = -d2;
        }
        if(d3 < 0){
            double appoggio = d1;
            d1 = d3 + d1;
            d3 = -d3;
        }
        SerializableRectangle rect = new SerializableRectangle(d,d1,d2,d3,strokeColor,fillColor);
        this.list.add(rect);
        this.pane.getChildren().add(rect.getShape());
    }

  
}
