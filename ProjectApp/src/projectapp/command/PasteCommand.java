/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import singletons.Clonator;

/**
 *
 * @author pasqualecaggiano
 */
public class PasteCommand implements Command{
    private Clonator clonator;
    private Shape shape;
    private Pane pane;
    private Point2D point;

    public PasteCommand(Clonator clonator, Shape shape, Pane pane, Point2D point) {
        this.clonator = clonator;
        this.shape = shape;
        this.pane = pane;
        this.point = point;
    }
    
    @Override
    public void execute() {
        shape = clonator.decodeFromXml();
        if (shape!= null){
            shape.setTranslateX(point.getX());
            shape.setTranslateY(point.getY());
            pane.getChildren().add(shape);
        }
    }

    @Override
    public void undo() {
        if (shape != null){
        pane.getChildren().remove(shape);
        }
    }  
}
