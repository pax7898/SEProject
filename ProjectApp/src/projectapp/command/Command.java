/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.event.Event;
import javafx.scene.shape.Shape;
import projectapp.shape.SerializableShape;


/**
 *
 * @author pasqualecaggiano
 */
public abstract class Command {
    private Shape shape;
    private Event event;
    

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    public Shape getShape(){
        return shape;
    }
    
    public void setShape(Shape shape){
        this.shape=shape;
    }
    
    public void onMousePressed(Event event){
        
    }
    public void onMouseDrag(Event event){
        
    }
    public void onMouseReleased(Event event){
        
    }
    
    
    
    public abstract void execute();
}
