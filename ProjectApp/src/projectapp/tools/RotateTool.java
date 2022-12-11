/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.RotateCommand;
import projectapp.singletons.SelectedShape;

/**
 * 
 * @author Sabatino
 */
public class RotateTool extends SelectionTool{
    
    private double startY;
    private double initialRotate;
    private VBox vboxChangeSize;
    private ContextMenu menu;
    
    
    public RotateTool(Pane pane, SelectedShape selectedShape, CommandExecutor executor, ContextMenu menu, VBox vboxChangeSize, Group gridContainer) {
        super(pane, selectedShape, executor, menu, vboxChangeSize, gridContainer);
        this.vboxChangeSize = vboxChangeSize;
        this.menu = menu;
    }
    
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        
        vboxChangeSize.visibleProperty().set(false);
        menu.getItems().forEach(item -> {
            item.setDisable(true);
        });
        
        initialRotate = getSelectedShape().getShape().getRotate();
        startY = event.getY();
        
        
    }
    
    @Override
    public void onMouseDragged(MouseEvent event){
        getSelectedShape().getShape().setRotate((event.getY()-startY+initialRotate));
    }
    
    @Override
    public void onMouseReleased(MouseEvent event){
        getExecutor().execute(new RotateCommand(getSelectedShape(), initialRotate,(event.getY()-startY+initialRotate)));
    }
    
}
