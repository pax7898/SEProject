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
 * @author acoon
 */
public class EllipseTool extends Tool{
    private Ellipse ellipse;

    public EllipseTool(Pane pane,CommandExecutor executor) {
        super(pane,executor);
    }
 
    @Override
    public Shape getShape() {
        return ellipse;
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
        getExecutor().execute(new DrawCommand(ellipse,getPane()));
    }

    @Override
    public void onMouseDragged(MouseEvent event) {
        ellipse.setRadiusX(abs(event.getX()-ellipse.getCenterX()));
        ellipse.setRadiusY(abs(event.getY()-ellipse.getCenterY()));
    }

    @Override
    public void onMouseReleased(MouseEvent event) {
        ellipse.setRadiusX(abs(event.getX()-ellipse.getCenterX()));
        ellipse.setRadiusY(abs(event.getY()-ellipse.getCenterY()));
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
