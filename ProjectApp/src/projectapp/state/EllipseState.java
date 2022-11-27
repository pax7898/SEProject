/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.state;

import projectapp.shape.SerializableEllipse;
import projectapp.shape.SerializableShape;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author acoon
 */
public class EllipseState extends EditorState {

    public EllipseState(Pane pane, ObservableList<SerializableShape> list) {
        super(pane,list);
    }
    
    @Override
    public void draw(double startX, double startY, double endX, double endY, Color strokeColor, Color fillColor) {
        SerializableEllipse ellipse = new SerializableEllipse(startX, startY, endX, endY, strokeColor, fillColor);
        this.getList().add(ellipse);
        this.getPane().getChildren().add(ellipse.getShape()); 
    }


}
