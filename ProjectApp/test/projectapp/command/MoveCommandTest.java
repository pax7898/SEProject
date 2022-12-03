/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.tools.EllipseTool;

/**
 *
 * @author acoon
 */
public class MoveCommandTest {
    private Pane pane;
    private CommandExecutor executor;
    private EllipseTool ellipse;
    private MoveCommand moveCommand;
    private MouseEvent pressEvent;
    
    
    @Before
    public void setUp() {
        pane = new Pane();
        executor = new CommandExecutor();
        pressEvent = new MouseEvent(MouseEvent.MOUSE_RELEASED, 0, 0, 0, 0,MouseButton.PRIMARY, 1,  
                                false, false,false,false,false,false,false,false,false,false,null);
        ellipse = new EllipseTool(pane, executor);
        ellipse.onMousePressed(pressEvent, Color.DARKVIOLET, Color.SILVER); //creo la figura e le mie vecchie coordinate sono centerX = 0,centerY = 0, radiusX = 0, radiusY = 0
        
        
        
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        MoveCommand instance = null;
        instance.execute();
        fail("The test case is a prototype.");
    }

    @Test
    public void testUndo() {
        System.out.println("undo");
        MoveCommand instance = null;
        instance.undo();
        fail("The test case is a prototype.");
    }
    
}
