/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import projectapp.shape.SerializableShape;

/**
 *
 * @author Sabatino
 */
public abstract class EditorStateOpen extends EditorState{
    
    public EditorStateOpen(Pane pane) {
        super(pane);
    }
    
}
