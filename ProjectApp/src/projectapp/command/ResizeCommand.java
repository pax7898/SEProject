/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 *
 * @author Sabatino
 */
public class ResizeCommand implements Command{
    
    private Shape shape;
    private MouseEvent event;
    private double undoX;
    private double undoY;
    
    public ResizeCommand(Shape shape, MouseEvent event){
        this.shape = shape;
        this.event = event;
        this.undoX = shape.getScaleX();
        this.undoY = shape.getScaleY();
    }

    @Override
    public void execute() {
        //da cambiare
        shape.setStyle("-fx-stroke-dash-array:5px");
    }

    @Override
    public void undo() {
        this.shape.setScaleX(undoX);
        this.shape.setScaleY(undoY);
    }
    
}
