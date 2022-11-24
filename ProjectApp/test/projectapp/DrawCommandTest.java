/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import javafx.scene.control.ScrollPane;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        command = new DrawCommand(new LineState(pane,list),200,200,300,300,Color.RED,Color.RED);
        
    }
    
    /**
     * Test of execute method, of class DrawCommand.
     */
    @Test
    public void testExecute() {
       command.execute();
       assertEquals(1,list.size());
       assertEquals(1,pane.getChildren().size());
      
    }
    
}
