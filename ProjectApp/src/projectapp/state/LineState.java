/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.state;


import projectapp.shape.SerializableLine;
import projectapp.shape.SerializableShape;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 *
 * @author pasqualecaggiano
 */
public class LineState extends EditorState{
        
    public LineState(Pane pane, ObservableList<SerializableShape> list) {
        super(pane,list);
    }

    /*@Override
    public void draw(double d, double d1, double d2, double d3, Color strokeColor) {
        /*SerializableLine line = new SerializableLine(d,d1,d2,d3,strokeColor);
        this.list.add(line);
        this.pane.getChildren().add(line.getShape());*/
    

    @Override
    public void draw(double d, double d1, double d2, double d3, Color strokeColor, Color fillColor) {
        SerializableLine line = new SerializableLine(d,d1,d2,d3,strokeColor, fillColor);
        this.getList().add(line);
        this.getPane().getChildren().add(line.getShape());  
    }
    
}
