/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;



import javafx.scene.layout.Pane;

import javafx.scene.shape.Shape;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawCommand implements Command{
    private Shape shape;
    private Pane pane;
    
    public DrawCommand(Shape shape,Pane pane) {
        this.pane = pane;
        this.shape = shape;
    }

 
    @Override
    public void execute() {
        pane.getChildren().add(shape);
    }

    @Override
    public void undo() {
        pane.getChildren().remove(shape);
    }
     
}
