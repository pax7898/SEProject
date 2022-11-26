/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.shape;

import projectapp.shape.SerializableShape;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Math.abs;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author acoon
 */
public class SerializableEllipse extends SerializableShape{
    
    private transient double centerX;
    private transient double centerY;
    private transient double radiusX;
    private transient double radiusY;
    
    private transient Color strokeColor;
    private transient Color fillColor;
    
    private transient Ellipse ellipse;
    
    public SerializableEllipse(double centerX, double centerY, double radiusX, double radiusY, Color strokeColor, Color fillColor){
        this.centerX = centerX;
        this.centerY = centerY;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.createView();
    }

    @Override
    public void createView() {
        ellipse = new Ellipse();
        ellipse.setCenterX(centerX);
        ellipse.setCenterY(centerY);
        ellipse.setRadiusX(abs(radiusX-centerX));
        ellipse.setRadiusY(abs(radiusY-centerY));
        ellipse.setStroke(strokeColor);
        ellipse.setFill(fillColor);
        this.setShape(ellipse);
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadiusX() {
        return radiusX;
    }


    public double getRadiusY() {
        return radiusY;
    }


    public Color getStrokeColor() {
        return strokeColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeDouble(getCenterX());
        s.writeDouble(getCenterY());
        s.writeDouble(getRadiusX());
        s.writeDouble(getRadiusY());
        s.writeDouble(strokeColor.getRed());
        s.writeDouble(strokeColor.getGreen());
        s.writeDouble(strokeColor.getBlue());
        s.writeDouble(strokeColor.getOpacity());
        s.writeDouble(fillColor.getRed());
        s.writeDouble(fillColor.getGreen());
        s.writeDouble(fillColor.getBlue());
        s.writeDouble(fillColor.getOpacity());
    }

    
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        centerX = s.readDouble();
        centerY = s.readDouble();
        radiusX = s.readDouble();
        radiusY = s.readDouble();
        double strokeRed = s.readDouble() ;
        double strokeGreen = s.readDouble() ;
        double strokeBlue = s.readDouble() ;
        double strokeOpacity = s.readDouble() ;
        double fillRed = s.readDouble() ;
        double fillGreen = s.readDouble() ;
        double fillBlue = s.readDouble() ;
        double fillOpacity = s.readDouble() ;
        strokeColor = Color.color(strokeRed, strokeGreen, strokeBlue, strokeOpacity) ;
        fillColor = Color.color(fillRed, fillGreen, fillBlue, fillOpacity) ;
        createView();
    }

    @Override
    public String toString() {
        return "Ellipse " + "(" + centerX + "," + centerY + ")";
    }
    
}
