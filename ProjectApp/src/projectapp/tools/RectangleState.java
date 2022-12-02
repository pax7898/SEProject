/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.tools;


import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author acoon
 */
public class RectangleState extends DrawingState{
        
    public RectangleState(Pane pane) {
        super(pane);
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
        Rectangle rectangle = new Rectangle();
        rectangle.setStroke(strokeColor);
        rectangle.setFill(fillColor);
        rectangle.setX(startX);
        rectangle.setY(startY);
        rectangle.setWidth(endX);
        rectangle.setHeight(endY);
        //SerializableRectangle rect = new SerializableRectangle(startX,startY,endX,endY,strokeColor,fillColor);
        this.getPane().getChildren().add(rectangle);
    }
  
}
