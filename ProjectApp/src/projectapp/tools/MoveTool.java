/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;

/**
 *
 * @author pasqualecaggiano
 */
public class MoveTool extends SelectionTool{
    
    private boolean flag;
    
    public MoveTool(Pane pane, Shape selectedShape, CommandExecutor executor) {
        super(pane, selectedShape, executor);
    }

    @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}
    
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        if (super.getSelectedShape() != null){
           super.getSelectedShape().setStyle("-fx-stroke-dash-array:none");
        }
        
        if (event.getTarget().getClass()!= getPane().getClass()){
            super.setSelectedShape((Shape) event.getTarget());
            super.getSelectedShape().setStyle("-fx-stroke-dash-array:5px");
            flag = true;
        }
        else{
            flag = false;
        }
    }
    
    
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(flag == true){
            getSelectedShape().relocate(event.getX(),event.getY());
        }
        
    }

    @Override
    public void onMouseReleased(MouseEvent event) {
        
    }
    
    
}

