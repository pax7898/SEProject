/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.tools;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.DrawCommand;
/**
 *
 * @author acoon
 */
public class LineTool extends Tool{
    private Line line;

    public LineTool(Pane pane,CommandExecutor executor) {
        super(pane,executor);
    }
     @Override
    public Shape getShape() {
        return line;
    }
    
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor) {
        line = new Line();
        line.setStroke(strokeColor);
        line.setStartX(event.getX());
        line.setStartY(event.getY());
        line.setEndX(event.getX());
        line.setEndY(event.getY());
        getExecutor().execute(new DrawCommand(line,getPane()));
    }

    @Override
    public void onMouseDragged(MouseEvent event) {
        line.setEndX(event.getX());
        line.setEndY(event.getY());
    }

    @Override
    public void onMouseReleased(MouseEvent event) {
        line.setEndX(event.getX());
        line.setEndY(event.getY());
    } 
    

    @Override
    public void changeBorderColor(Color strokeColor){}

    @Override
    public void changeInteriorColor(Color strokeColor){}

    @Override
    public void deleteShape(){}

    @Override
    public void copyShape(){}

    @Override
    public void cutShape(){}

    @Override
    public void pasteShape(){}

}
