/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

import java.io.Serializable;
import javafx.scene.shape.Shape;

/**
 *
 * @author Sabatino
 */
public abstract class SerializableShape implements Serializable, IShape{
    transient Shape shape;

    public Shape getShape() {
        return shape;
    }
    public void setShape(Shape s) {
        shape = s;
    } 
}
