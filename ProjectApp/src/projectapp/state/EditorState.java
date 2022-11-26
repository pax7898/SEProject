/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.state;


import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import projectapp.shape.SerializableShape;

/**
 *
 * @author pasqualecaggiano
 */
public abstract class EditorState implements IState{
    private SerializableShape shape;
    private final Pane pane;
    private final ObservableList<SerializableShape> list;

    public EditorState(Pane pane, ObservableList<SerializableShape> list) {
        this.shape = null;
        this.pane = pane;
        this.list = list;
    }
    
    public SerializableShape getShape() {
        return shape;
    }

    public void setShape(SerializableShape shape) {
        this.shape = shape;
    }

    public Pane getPane() {
        return pane;
    }

    public ObservableList<SerializableShape> getList() {
        return list;
    }
    
    
    
}
