/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import projectapp.command.DrawCommand;
import projectapp.state.LineState;
import projectapp.shape.SerializableShape;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.state.EllipseState;
import projectapp.state.RectangleState;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawCommandTest {
    private DrawCommand command;
    private Pane pane;
    private ObservableList<SerializableShape> list;
   
 
    
    @Before
    public void setUp() {
        pane = new Pane();
        list = FXCollections.observableArrayList();
    }
    
    /**
     * Test of execute method, of class DrawCommand.
     */
    @Test
    public void testExecute() {
       System.out.println("execute");
       command = new DrawCommand(new LineState(pane,list),200,200,300,300,Color.RED,Color.RED);
       command.execute();
       assertEquals(1,list.size());
       assertEquals(1,pane.getChildren().size());
       assertTrue(pane.getChildren().contains((Node)list.get(0).getShape()));
       command = new DrawCommand(new EllipseState(pane,list),200,200,300,300,Color.RED,Color.RED);
       command.execute();
       assertEquals(2,list.size());
       assertEquals(2,pane.getChildren().size());
       assertTrue(pane.getChildren().contains((Node)list.get(1).getShape()));
       command = new DrawCommand(new RectangleState(pane,list),200,200,300,300,Color.RED,Color.RED);
       command.execute();
       assertEquals(3,list.size());
       assertEquals(3,pane.getChildren().size());
       assertTrue(pane.getChildren().contains((Node)list.get(2).getShape()));
       
       
    }
    
}
