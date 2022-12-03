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
    
    private double salvoX;
    private double salvoY;
    private double initialPositionX;
    private double initialPositionY;
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
            super.getExecutor().execute(new ResizeCommand(super.getSelectedShape(), event));
            flag = true;
            salvoX = super.getSelectedShape().getLayoutBounds().getMaxX();
            salvoY = super.getSelectedShape().getLayoutBounds().getMaxY();
            initialPositionX = event.getX();
            initialPositionY = event.getY();
        }
        else{
            flag = false;
        }
    }
    
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(flag == true){
            
            
            
            double lengthShapeX = super.getSelectedShape().getLayoutBounds().getMaxX() - super.getSelectedShape().getLayoutBounds().getMinX();
            double lengthShapeY = super.getSelectedShape().getLayoutBounds().getMaxY() - super.getSelectedShape().getLayoutBounds().getMinY();
            
            double initialPercX = (initialPositionX - super.getSelectedShape().getLayoutBounds().getMinX()) / lengthShapeX;
            double initialPercY = (initialPositionY - super.getSelectedShape().getLayoutBounds().getMaxY()) / lengthShapeY;
                
            double diffClickX = (event.getX() - initialPositionX) + (initialPositionX - super.getSelectedShape().getLayoutBounds().getMinX());
            double diffClickY = (event.getY() - initialPositionY) + (initialPositionY - super.getSelectedShape().getLayoutBounds().getMaxY());
            
            double provX = diffClickX / initialPercX;
            double provY = diffClickY / initialPercY;
            double risX = provX / lengthShapeX;
            double risY = provY / lengthShapeY;
            System.out.println(risX + " " + risY);
            super.getSelectedShape().setScaleX(risX);
            super.getSelectedShape().setScaleY(risY);
        }
    }
    
    @Override
    public void onMouseReleased(MouseEvent event) {
        if(flag == true){
            //super.getSelectedShape().setLayoutX(event.get);
            
        }
    }
    
    @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}

    
}