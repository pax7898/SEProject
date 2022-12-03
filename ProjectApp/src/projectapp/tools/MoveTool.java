/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import static java.lang.Math.abs;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.MoveCommand;

/**
 *
 * @author acoon
 */
public class MoveTool extends SelectionTool{
    
    private double initialPositionX;
    private double initialPositionY;
    private boolean flag;
    private double newX;
    private double newY;
    private double oldX;
    private double oldY;
    
    public MoveTool(Pane pane, Shape selectedShape, CommandExecutor command) {
        super(pane, selectedShape, command);
    }

   
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        if (super.getSelectedShape() != null){
           super.getSelectedShape().setStyle("-fx-stroke-dash-array:none");
        } 
        if (event.getTarget().getClass()!= getPane().getClass()){
            super.setSelectedShape((Shape) event.getTarget());
            super.getSelectedShape().setStyle("-fx-stroke-dash-array:5px");
            flag = true;
            this.initialPositionX = event.getX();
            this.initialPositionY = event.getY();
            newX = oldX = super.getSelectedShape().getTranslateX();
            newY = oldY = super.getSelectedShape().getTranslateY();
        }
        else{
            flag = false;
        }
    }
    
    
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(flag == true){
            super.getSelectedShape().setTranslateX(newX);
            super.getSelectedShape().setTranslateY(newY);
            newX = oldX + event.getX() - initialPositionX;
            newY = oldY + event.getY() - initialPositionY;
        }      
    }

    @Override
    public void onMouseReleased(MouseEvent event) {
        if(flag == true){
            super.getExecutor().execute(new MoveCommand(super.getSelectedShape(),super.getSelectedShape().getTranslateX(), super.getSelectedShape().getTranslateY(), oldX, oldY));
            oldX  = super.getSelectedShape().getTranslateX();
            oldY  = super.getSelectedShape().getTranslateY();
        }
    }
    
     @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}
    
     
}

