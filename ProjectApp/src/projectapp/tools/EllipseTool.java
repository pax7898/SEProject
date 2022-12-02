/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import static java.lang.Math.abs;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.DrawCommand;

/**
 *
 * @author pasqualecaggiano
 */
public class EllipseTool extends Tool{
    private Ellipse ellipse;
    private double x;
    private double y;

   
    
    public EllipseTool(Pane pane,CommandExecutor executor) {
        super(pane,executor);
    }

    
    @Override
    public Shape getShape() {
        return new Ellipse();
    }
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor) {
        ellipse = new Ellipse();
        ellipse.setStroke(strokeColor);
        ellipse.setFill(fillColor);
        ellipse.setCenterX(event.getX());
        ellipse.setCenterY(event.getY());
        
        ellipse.setRadiusX(0);
        ellipse.setRadiusY(0);
        this.setX(event.getX());
        this.setY(event.getY());
        getExecutor().execute(new DrawCommand(ellipse,getPane()));
    }

    @Override
    public void onMouseDragged(MouseEvent event) {
        ellipse.setRadiusX(abs(event.getX()-this.getX()));
        ellipse.setRadiusY(abs(event.getY()-this.getY()));
    }

    @Override
    public void onMouseReleased(MouseEvent event) {
        ellipse.setRadiusX(abs(event.getX()-this.getX()));
        ellipse.setRadiusY(abs(event.getY()-this.getY()));
    }

    
     public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}

    @Override
    public void deleteShape() {}

    @Override
    public void copyShape() {}

    @Override
    public void cutShape() {}

    @Override
    public void pasteShape() {}  
}
