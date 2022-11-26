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


    @Override
    public void draw(double startX, double startY, double endX, double endY, Color strokeColor, Color fillColor) {
        SerializableLine line = new SerializableLine(startX,startY,endX,endY,strokeColor, fillColor);
        this.getList().add(line);
        this.getPane().getChildren().add(line.getShape());  
    }
    
}
