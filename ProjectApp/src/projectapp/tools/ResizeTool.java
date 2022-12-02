/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.Command;
import projectapp.command.CommandExecutor;

/**
 *
 * @author pasqualecaggiano
 */
public class ResizeTool extends SelectionTool{

    public ResizeTool(Pane pane,Shape selectedShape,CommandExecutor executor) {
        super(pane,selectedShape,executor); 
    }

    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        Shape selectedShape = getSelectedShape();
        if (selectedShape != null){
           selectedShape.setStyle("");
        }
        
        if (event.getTarget().getClass()!= getPane().getClass()){
            selectedShape = (Shape) event.getTarget();
            selectedShape.setStyle("-fx-stroke-dash-array:5px");
        }
    }
    
    @Override
    public void onMouseDragged(MouseEvent event) {
       
       System.out.println(getSelectedShape().getLayoutX() + " ---" + getSelectedShape().getLayoutY());
       getSelectedShape().setScaleX(event.getX()/getSelectedShape().getLayoutX());
       getSelectedShape().setScaleY(event.getY()/getSelectedShape().getLayoutY());
    }

    @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}

    @Override
    public void onMouseReleased(MouseEvent event) {}
}

