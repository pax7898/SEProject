/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;

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
        
    public SerializableRectangle(double x1, double y1, double x2, double y2, Color strokeColor) {
        this.x =x1;
        this.y =y1;
        this.width = x2;
        this.height = y2;
        this.strokeColor = strokeColor ;
        this.fillColor = Color.TRANSPARENT;
        rectangle = new Rectangle();
        createView();
    }

    public SerializableRectangle(double x1, double y1, double x2, double y2, Color strokeColor, Color fillColor) {
        this.x =x1;
        this.y =y1;
        this.width = x2;
        this.height = y2;
        this.strokeColor = strokeColor ;
        this.fillColor = fillColor;
        createView();
    }

    @Override
    public void createView() {

        rectangle.setStroke(strokeColor);
        rectangle.setFill(fillColor);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        this.setShape(rectangle); 
    }

    public Shape getView() {
        return this.getShape() ;
    }

    public final double getX() {
        return this.x;
    }

    public final void setX(final double x1) {
        this.x = x1;
    }


    public final double getY() {
        return this.y;
    }


    public final void setY(final double y1) {
       this.y=y1;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
        

    public final double getWidth() {
        return this.width;
    }


    public final void setWidth(final double x2) {
        this.width = x2;
    }


    public final double getHeigth() {
        return this.height;
    }


    public final void getHeigth(final double y2) {
        this.height = y2;
    }


    private void writeObject(ObjectOutputStream s) throws IOException {
        //s.defaultWriteObject();
        s.writeDouble(getX());
        s.writeDouble(getY());
        s.writeDouble(getWidth());
        s.writeDouble(getHeigth());
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

}
