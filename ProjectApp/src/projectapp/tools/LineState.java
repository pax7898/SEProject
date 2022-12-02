/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;


import projectapp.shape.SerializableLine;
import projectapp.shape.SerializableShape;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;


/**
 *
 * @author pasqualecaggiano
 */
public class LineState extends DrawingState{
        
    public LineState(Pane pane) {
        super(pane);
    }


    @Override
    public void draw(double startX, double startY, double endX, double endY, Color strokeColor, Color fillColor) {
        //SerializableLine line = new SerializableLine(startX,startY,endX,endY,strokeColor, fillColor);
        Line line = new Line();
        line.setStroke(strokeColor);
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        this.getPane().getChildren().add(line);  
    }
    
}
