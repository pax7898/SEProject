/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import javafx.scene.control.ScrollPane;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Group;
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
    
    @FXML
    private ScrollPane scrollPane;
    
    public DrawCommandTest() {
    }
    
    @Before
    public void setUp() {
        command = new DrawCommand(new SerializableLine(20,20,40,40,Color.RED),new Group(),scrollPane,new ArrayList<SerializableShape>());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class DrawCommand.
     */
    @Test
    public void testExecute() {
       
      
    }
    
}
