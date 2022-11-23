/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author pasqualecaggiano
 */
public abstract class Command {
    private SerializableShape shape;
    
    public SerializableShape getShape(){
        return shape;
    }
    
    public void setShape(SerializableShape shape){
        this.shape=shape;
    }
    
    public abstract void execute();
}
