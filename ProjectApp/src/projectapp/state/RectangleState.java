/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.state;

import projectapp.shape.SerializableRectangle;
import projectapp.shape.SerializableShape;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author acoon
 */
public class RectangleState extends EditorState{
        
    public RectangleState(Pane pane, ObservableList<SerializableShape> list) {
        super(pane,list);
    }

    @Override
    public void draw(double startX, double startY, double endX, double endY, Color strokeColor, Color fillColor) {
        endX = endX - startX;
        endY = endY - startY;
        if(endX < 0 ){
            startX = endX + startX;
            endX = -endX;
        }
        if(endY < 0){
            startY = endY + startY;
            endY = -endY;
        }
        SerializableRectangle rect = new SerializableRectangle(startX,startY,endX,endY,strokeColor,fillColor);
        this.getList().add(rect);
        this.getPane().getChildren().add(rect.getShape());
    }

  
}
