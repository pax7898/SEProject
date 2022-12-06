/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 *
 * @author acoon
 */
public class ToFrontCommand implements Command{
    
    private Shape shape;
    private Pane pane;
    private int oldIndex;
    private int newIndex;
    public ToFrontCommand(Shape shape, Pane pane){
        this.shape = shape;
        this.pane = pane;
    }
    @Override
    public void execute() {
        oldIndex =  pane.getChildren().indexOf(shape);
        shape.toFront();
        newIndex = pane.getChildren().indexOf(shape);
        
    }

    @Override
    public void undo() {
        
        pane.getChildren().remove(shape);
        pane.getChildren().add(oldIndex, shape);
        
        //shape.toBack();
    }
    
}
