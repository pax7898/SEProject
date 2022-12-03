/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.DrawCommand;

/**
 *
 * @author pasqualecaggiano
 */
public class RectangleTool extends Tool{
    private Rectangle rectangle;
    private double initialPositionX;
    private double initialPositionY;

    public RectangleTool(Pane pane,CommandExecutor executor) {
        super(pane,executor);
    }
    
    @Override
    public Shape getShape() {
        return rectangle;
    }

    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor) {
        rectangle = new Rectangle();
        rectangle.setStroke(strokeColor);
        rectangle.setFill(fillColor);
        rectangle.setX(event.getX());
        rectangle.setY(event.getY());
        rectangle.setWidth(0);
        rectangle.setWidth(0);
        this.initialPositionX = event.getX();
        this.initialPositionY = event.getY();
        getExecutor().execute(new DrawCommand(rectangle,getPane()));
    }

    @Override
    public void onMouseDragged(MouseEvent event) {
        double startX = rectangle.getX();
        double startY = rectangle.getY();
        double endX = event.getX() - initialPositionX;
        double endY = event.getY() - initialPositionY;
        
        if(endX < 0 ){
            endX = -endX;
            rectangle.setX(event.getX());
        }
        if(endY < 0){
            endY = -endY;
            rectangle.setY(event.getY());
        }    
        rectangle.setWidth(endX);
        rectangle.setHeight(endY);
    }

    @Override
    public void onMouseReleased(MouseEvent event) {
        double startX = rectangle.getX();
        double startY = rectangle.getY();
        double endX = event.getX() - initialPositionX;
        double endY = event.getY() - initialPositionY;
        if(endX < 0 ){
            endX = -endX;
            rectangle.setX(event.getX());
        }
        if(endY < 0){
            endY = -endY;
            rectangle.setY(event.getY());
        }
        
        rectangle.setWidth(endX);
        rectangle.setHeight(endY);
    }


    @Override
    public void changeBorderColor(Color strokeColor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeInteriorColor(Color strokeColor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void copyShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cutShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pasteShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
