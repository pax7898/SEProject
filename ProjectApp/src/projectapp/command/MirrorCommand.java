/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.shape.Shape;

/**
 *
 * @author acoon
 */
public class MirrorCommand implements Command {
    
    private Shape shape;
    private double oldScaleX;

    public MirrorCommand(Shape shape) {
        this.shape = shape;
    }
    
    @Override
    public void execute() {
        oldScaleX = shape.getScaleX();
        shape.setScaleX(-oldScaleX);
    }

    @Override
    public void undo() {
        shape.setScaleX(oldScaleX);
    }
    
}
