/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author acoon
 */
public class Grid {
    Group group;
    private static final double DELTA = 300;
    public Grid(){
        
        
    }
    
    public Group create(Pane drawingPane, Double size){
        group = new Group();
        for(int i = 0; i<drawingPane.getLayoutBounds().getWidth(); i += (int) drawingPane.getLayoutBounds().getHeight()/(DELTA/size)){
            Line line = new Line(0, i, drawingPane.getLayoutBounds().getWidth(), i);
            line.setStroke(Color.GREY);
            group.getChildren().add(line);
        }
        
        for(int i = 0; i< drawingPane.getLayoutBounds().getHeight(); i += (int) drawingPane.getLayoutBounds().getWidth()/(DELTA/size)){
            Line line = new Line(i, 0, i, drawingPane.getLayoutBounds().getHeight());
            line.setStroke(Color.GREY);
            group.getChildren().add(line);
        }
        return group;
    }
}
