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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author acoon
 */
public class SerializableRectangle extends SerializableShape{
    private transient double x;
    private transient double y;
    private transient double width;
    private transient double height;

    private transient Color strokeColor ;
    private transient Color fillColor;
    
    private transient Rectangle rectangle;
    
  
    public SerializableRectangle(double x, double y, double width, double height, Color strokeColor, Color fillColor) {
        this.x =x;
        this.y =y;
        this.width = width;
        this.height = height;
        this.strokeColor = strokeColor ;
        this.fillColor = fillColor;
        createView();
    }

    @Override
    public void createView() {
        rectangle = new Rectangle();
        rectangle.setStroke(strokeColor);
        rectangle.setFill(fillColor);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        this.setShape(rectangle); 
    }


    public final double getX() {
        return this.x;
    }


    public final double getY() {
        return this.y;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }


    public Color getFillColor() {
        return fillColor;
    }
  

    public final double getWidth() {
        return this.width;
    }



    public double getHeight() {
        return height;
    }

    
    

    public Rectangle getRectangle() {
        return rectangle;
    }

    

    private void writeObject(ObjectOutputStream s) throws IOException {
        //s.defaultWriteObject();
        s.writeDouble(getX());
        s.writeDouble(getY());
        s.writeDouble(getWidth());
        s.writeDouble(getHeight());
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
        x = s.readDouble();
        y = s.readDouble();
        width = s.readDouble();
        height = s.readDouble();
        double red = s.readDouble() ;
        double green = s.readDouble() ;
        double blue = s.readDouble() ;
        double opacity = s.readDouble() ;
        strokeColor = Color.color(red, green, blue, opacity);
        red = s.readDouble() ;
        green = s.readDouble() ;
        blue = s.readDouble() ;
        opacity = s.readDouble();
        fillColor = Color.color(red, green, blue, opacity);
        createView();
    }

    @Override
    public String toString() {
        return "Rectangle " + "(" + x + "," + y + ')';
    }
    

}
