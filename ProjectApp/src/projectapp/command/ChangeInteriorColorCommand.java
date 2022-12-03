/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author 39320
 */
public class ChangeInteriorColorCommand implements Command{
    private final Shape shape;
    private final Color oldFillColor;
    private final Color newFillColor;

    public ChangeInteriorColorCommand(Shape shape, Color newFillColor) {
        this.shape = shape;
        this.oldFillColor = (Color) shape.getFill();
        this.newFillColor = newFillColor;
    }
    
    @Override
    public void execute() {
        shape.setFill(newFillColor);    
    }

    
}
