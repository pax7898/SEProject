/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

/**
 *
 * @author pasqualecaggiano
 */
public abstract class EditorState implements IState{
    private SerializableShape shape;

    public SerializableShape getShape() {
        return shape;
    }

    public void setShape(SerializableShape shape) {
        this.shape = shape;
    }
    
}
