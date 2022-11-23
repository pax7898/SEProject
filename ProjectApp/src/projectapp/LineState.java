/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;

/**
 *
 * @author pasqualecaggiano
 */
public class LineState extends EditorState{
    private final Group group;
    private final ScrollPane pane;
    private final List<SerializableShape> list;
        
    public LineState(Group group, ScrollPane pane, ObservableList<SerializableShape> list) {
        this.group = group;
        this.list = list;
        this.pane = pane;
    }

    @Override
    public void draw(double d, double d1, double d2, double d3, Color strokeColor) {
        SerializableLine line = new SerializableLine(d,d1,d2,d3,strokeColor);
        this.group.getChildren().add(line.getShape());
        this.list.add(line);
        this.pane.setContent(group);
        
    }


    @Override
    public void draw(double d, double d1, double d2, double d3, Color strokeColor, Color fillColor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
