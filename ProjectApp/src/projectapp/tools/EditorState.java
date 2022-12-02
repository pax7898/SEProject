/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;


import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.shape.SerializableShape;

/**
 *
 * @author pasqualecaggiano
 */
public abstract class EditorState{
    
    private final Pane pane;

    public EditorState(Pane pane) {
        this.pane = pane;
    }
  
    public Pane getPane() {
        return pane;
    }
    
    public abstract void draw( double d, double d1, double d2, double d3, Color strokeColor, Color fillColor);
   
}
