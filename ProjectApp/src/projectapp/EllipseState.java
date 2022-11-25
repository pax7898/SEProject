/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author acoon
 */
public class EllipseState extends EditorState {
    
    private final Pane pane;
    private final ObservableList<SerializableShape> list;

    public EllipseState(Pane pane, ObservableList<SerializableShape> list) {
        this.pane = pane;
        this.list = list;
    }
    
    @Override
    public void draw(double d, double d1, double d2, double d3, Color strokeColor) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(double d, double d1, double d2, double d3, Color strokeColor, Color fillColor) {
        SerializableEllipse ellipse = new SerializableEllipse(d,d1, d2, d3, strokeColor, fillColor);
        this.list.add(ellipse);
        this.pane.getChildren().add(ellipse.getShape());
        
    }
    
}
