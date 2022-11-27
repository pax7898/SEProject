/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.shape;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author Sabatino
 */
public class SerializableLine extends SerializableShape{
    
    private transient double x1 ;
    private transient double y1 ;
    private transient double x2 ;
    private transient double y2 ;

    private transient Color color ;
    
    private transient Line line;
    
    public SerializableLine(double x1, double y1, double x2, double y2, Color strokeColor, Color fillColor) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = strokeColor;
        this.createView();
    }

    @Override
    public void createView() {
        line = new Line();
        line.setStroke(color);
        line.setStartX(x1);
        line.setStartY(y1);
        line.setEndX(x2);
        line.setEndY(y2);
        this.setShape(line); 
        
    }

    public final double getX1() {
        return this.x1;
    }


    public final double getY1() {
        return this.y1;
    }


    public final double getX2() {
        return this.x2;
    }


    public final double getY2() {
        return this.y2;
    }


    public Color getColor() {
        return color;
    }

    public Line getLine() {
        return line;
    }
    
    private void writeObject(ObjectOutputStream s) throws IOException {
        //s.defaultWriteObject();
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
    public String toString() {
        return "Line " + "(" + x1 + "," + y1 + ')';
    }
    
    
}
