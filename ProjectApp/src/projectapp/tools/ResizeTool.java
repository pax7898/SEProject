/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.Command;
import projectapp.command.CommandExecutor;
import projectapp.command.MoveCommand;
import projectapp.command.ResizeCommand;

/**
 *
 * @author pasqualecaggiano
 */
public class ResizeTool extends SelectionTool{
    
    private double x;
    private double y;
    private boolean flag;
    
    public ResizeTool(Pane pane, Shape selectedShape, CommandExecutor executor) {
        super(pane, selectedShape, executor);
        System.out.println("sto facendo riferimento alla shape: " + selectedShape);
    }

    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        if (super.getSelectedShape() != null){
           super.getSelectedShape().setStyle("");
        }
        
        if (event.getTarget().getClass()!= getPane().getClass()){
            super.setSelectedShape((Shape) event.getTarget());
            super.getSelectedShape().setStyle("-fx-stroke-dash-array:5px");
            super.getExecutor().execute(new ResizeCommand(super.getSelectedShape(), event));
            flag = true;
        }
        else{
            flag = false;
        }
    }
    
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(flag == true){
            super.getSelectedShape().setScaleX(event.getX() / super.getSelectedShape().getLayoutBounds().getMaxX());
            super.getSelectedShape().setScaleY(event.getY() / super.getSelectedShape().getLayoutBounds().getMaxY());
        }
    }

    @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}

    @Override
    public void onMouseReleased(MouseEvent event) {
        if(flag == true){
            //super.getSelectedShape().setLayoutX(event.get);
            super.getSelectedShape().setScaleX(event.getX() / super.getSelectedShape().getLayoutBounds().getMaxX());
            super.getSelectedShape().setScaleY(event.getY() / super.getSelectedShape().getLayoutBounds().getMaxY());
            super.getSelectedShape().setStyle("");

        }
    }
}