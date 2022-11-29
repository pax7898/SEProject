/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.state;


import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import projectapp.shape.SerializableShape;

/**
 *
 * @author pasqualecaggiano
 */
public abstract class EditorState implements IState{
    private Shape shape;
    private final Pane pane;
    private final ObservableList<Shape> list;

    public EditorState(Pane pane, ObservableList<Shape> list) {
        this.shape = null;
        this.pane = pane;
        this.list = list;
    }
    
    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Pane getPane() {
        return pane;
    }

    public ObservableList<Shape> getList() {
        return list;
    }
    
    
    
}
