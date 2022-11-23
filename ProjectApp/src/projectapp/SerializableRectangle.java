/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author 39320
 */
public class SerializableRectangle extends SerializableShape{
    private transient double x1 ;
    private transient double y1 ;
    private transient double x2 ;
    private transient double y2 ;

    private transient Color color ;

    public SerializableRectangle(double x1, double y1, double x2, double y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.createView();
    }
    
    
    

    @Override
    public void createView() {
        Rectangle rectangle= new Rectangle();
        rectangle.setStroke(color);
        rectangle.setX(x1);
        rectangle.setY(y1);
        rectangle.setWidth(x2);
        rectangle.setHeight(y2);
        this.setShape(rectangle);
    }
    public Shape getView() {
        return this.getShape() ;
    }


    public final double getX1() {
        return this.x1;
    }


    public final void setX1(final double x1) {
        this.x1 = x1;
    }


    public final double getY1() {
        return this.y1;
    }


    public final void setY1(final double y1) {
        this.y1 = y1;
    }


    public final double getX2() {
        return this.x2;
    }


    public final void setX2(final double x2) {
        this.x2 = x2;
    }


    public final double getY2() {
        return this.y2;
    }


    public final void setY2(final double y2) {
        this.y2 = y2;
    }
        
    
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeDouble(getX1());
        s.writeDouble(getY1());
        s.writeDouble(getX2());
        s.writeDouble(getY2());
        s.writeDouble(color.getRed());
        s.writeDouble(color.getGreen());
        s.writeDouble(color.getBlue());
        s.writeDouble(color.getOpacity());
    }

    
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        x1 = s.readDouble();
        y1 = s.readDouble();
        x2 = s.readDouble();
        y2 = s.readDouble();
        double red = s.readDouble() ;
        double green = s.readDouble() ;
        double blue = s.readDouble() ;
        double opacity = s.readDouble() ;
        color = Color.color(red, green, blue, opacity) ;
        createView();
    }

    @Override
    public void draw(Group group, ScrollPane pane, List<SerializableShape> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
