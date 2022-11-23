/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawCommand extends Command{
    private Group group;
    private ScrollPane pane ;
    private List<SerializableShape> list;
    

    public DrawCommand(SerializableShape shape,Group group, ScrollPane pane, List<SerializableShape> list) {
        this.setShape(shape);
        this.group = group;
        this.pane = pane;
        this.list = list;
    }

    @Override
    public void execute(Group group, ScrollPane pane, List<SerializableShape> list) {
        this.getShape().draw(group,pane,list);
    }
    
}
