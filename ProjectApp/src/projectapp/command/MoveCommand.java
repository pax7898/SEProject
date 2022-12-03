/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

/**
 *
 * @author pasqualecaggiano
 */

import javafx.scene.shape.Shape;

/**
 *
 * @author pasqualecaggiano
 */
public class MoveCommand implements Command{
    private Shape shape;
    private double newX;
    private double newY;
    private double oldX;
    private double oldY;

    public MoveCommand(Shape shape, double newX, double newY, double oldX, double oldY) {
        this.shape = shape;
        this.newX = newX;
        this.newY = newY;
        this.oldX = oldX;
        this.oldY = oldY;
    }
 
    @Override
    public void execute() {
        this.shape.setTranslateX(newX);
        this.shape.setTranslateY(newY);
    }

    @Override
    public void undo() {
        this.shape.setTranslateX(oldX);
        this.shape.setTranslateY(oldY);
    }
    
}
