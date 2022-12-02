/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;


import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import projectapp.tools.EditorState;
import javafx.scene.paint.Color;
import projectapp.tools.DrawingState;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawCommand extends Command{
    private final EditorState state;
    private final double startX;
    private final double startY;
    private final double endX;
    private final double endY;
    private final Color strokeColor;
    private final Color fillColor;
    private Event event;

    public DrawCommand(EditorState currentState) {
        this.state = currentState;
        this.startX = 0.0;
        this.startY = 0.0;
        this.endX = 0.0;
        this.endY = 0.0;
        this.strokeColor = null;
        this.fillColor = null;
    }
   
   
    public DrawCommand(DrawingState state,double startX, double startY, double endX, double endY, Color strokeColor, Color fillColor) {
        this.state = state;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }
    
    
    
    

    @Override
    public void execute() {
        try{
            state.draw(startX,startY,endX,endY,strokeColor, fillColor);
        }catch(NullPointerException e){
            Alert alert = new Alert(AlertType.WARNING,"You must select a shape!");
            alert.show();
        }
    }
    
}
