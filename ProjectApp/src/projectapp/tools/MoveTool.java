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
public class MoveTool {
    
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.MoveCommand;

/**
 *
 * @author pasqualecaggiano
 */
public class MoveTool extends SelectionTool{
    
       
    public MoveTool(Pane pane,Shape selectedShape,CommandExecutor executor) {
        super(pane,selectedShape,executor); 
    }
    
    @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}

    @Override
    public void onMouseDragged(MouseEvent event) {
        getSelectedShape().relocate(event.getX(),event.getY());
    }

    @Override
    public void onMouseReleased(MouseEvent event){
        getExecutor().execute(new MoveCommand(getSelectedShape(),event.getX(),event.getY()));
    }
    
    
}
}
