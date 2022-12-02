/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;

/**
 *
 * @author pasqualecaggiano
 */
public abstract class Tool {
    private Pane pane;
    private CommandExecutor executor;

    public Tool(Pane pane,CommandExecutor executor) {
        this.pane = pane;
        this.executor=executor;
    }

    public Pane getPane() {
        return pane;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }
    
    public abstract Shape getShape();
    public abstract void copyShape();
    public abstract void cutShape();
    public abstract void pasteShape();
    public abstract void deleteShape();
    public abstract void changeBorderColor(Color strokeColor);
    public abstract void changeInteriorColor(Color strokeColor);
    public abstract void onMousePressed(MouseEvent event,Color strokeColor, Color fillColor);
    public abstract void onMouseDragged(MouseEvent event);
    public abstract void onMouseReleased(MouseEvent event);
}

 
