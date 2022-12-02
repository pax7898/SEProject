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
    private double x;
    private double y;
    
  
    
    public MoveCommand(Shape shape, double x, double y) {
        this.shape = shape;
        this.x=x;
        this.y=y;
               
    }

    @Override
    public void execute() {
        shape.relocate(x, y);
    }

    @Override
    public void undo() {
        shape.relocate(-x, -y);
    }
    
}
