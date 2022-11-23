/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projectapp;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author acoon
 */
public interface IShape {
    public void createView();
    public void draw(Group group, ScrollPane pane, List<SerializableShape> list);
}
