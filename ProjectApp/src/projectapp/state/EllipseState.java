/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.state;

import static java.lang.Math.abs;
import projectapp.shape.SerializableEllipse;
import projectapp.shape.SerializableShape;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 *
 * @author acoon
 */
public class EllipseState extends EditorStateClosed {

    public EllipseState(Pane pane, ObservableList<Shape> list) {
        super(pane,list);
    }
    
    @Override
    public void draw(double startX, double startY, double endX, double endY, Color strokeColor, Color fillColor) {
        //SerializableEllipse ellipse = new SerializableEllipse(startX, startY, endX, endY, strokeColor, fillColor);
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(startX);
        ellipse.setCenterY(startY);
        ellipse.setRadiusX(abs(endX-startX));
        ellipse.setRadiusY(abs(endY-startY));
        ellipse.setStroke(strokeColor);
        ellipse.setFill(fillColor);
        this.getList().add(ellipse);
        this.getPane().getChildren().add(ellipse); 
    }

    @Override
    public void changeFillColor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
