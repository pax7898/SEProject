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
public class ChangeBorderColorCommand implements Command{
    private final Shape shape;
    private final Color oldStrokeColor;
    private final Color newStrokeColor;

    public ChangeBorderColorCommand(Shape shape, Color newStrokeColor) {
        this.shape = shape;
        this.oldStrokeColor = (Color) shape.getStroke();
        this.newStrokeColor = newStrokeColor;
    }
    
    @Override
    public void execute() {
        shape.setStroke(newStrokeColor);
    }
}
