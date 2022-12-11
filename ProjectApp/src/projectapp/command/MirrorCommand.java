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
    private double oldRotate;

    public MirrorCommand(Shape shape) {
        this.shape = shape;
        this.oldRotate = 1;
    }
    
    @Override
    public void execute() {
        oldScaleX = shape.getScaleX();
        System.out.println("ci sono");
        shape.setScaleX(-oldScaleX);
        if(shape.getRotate() != 0){
            shape.setRotate(-shape.getRotate());
            oldRotate = -1;
        }
    }

    @Override
    public void undo() {
        shape.setScaleX(oldScaleX);
        shape.setRotate(shape.getRotate()*oldRotate);
    }
    
}
