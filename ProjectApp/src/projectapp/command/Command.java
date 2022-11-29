/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.shape.Shape;
import projectapp.shape.SerializableShape;


/**
 *
 * @author pasqualecaggiano
 */
public abstract class Command {
    private Shape shape;
    
    public Shape getShape(){
        return shape;
    }
    
    public void setShape(Shape shape){
        this.shape=shape;
    }
    
    public abstract void execute();
}
