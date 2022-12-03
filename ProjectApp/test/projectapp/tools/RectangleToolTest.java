/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.command.CommandExecutor;

/**
 *
 * @author Sabatino
 */
public class RectangleToolTest {
    
    private Pane pane;
    private CommandExecutor executor;
    private Tool rectangleTool;
    private Rectangle rectangle;
    
    
    
    public RectangleToolTest() {
    }
    
    
    @Before
    public void setUp() {
        pane = new Pane();
        executor = new CommandExecutor();
        rectangleTool = new RectangleTool(pane,executor);
        rectangle = new Rectangle(10,10,30,30);
    }

    /**
     * Test of getShape method, of class RectangleTool.
     */
    @Test
    public void testGetShape() {
        System.out.println("getShape");
        RectangleTool instance = null;
        Shape expResult = null;
        Shape result = instance.getShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onMousePressed method, of class RectangleTool.
     */
    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        
        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_PRESSED, 10, 10, 10, 10,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        rectangleTool.onMousePressed(event, strokeColor, fillColor);
        
        assertEquals(1,pane.getChildren().size());
        
        assertEquals(rectangle.getX(),Math.rint(rectangleTool.getShape().getLayoutBounds().getMinX()),1);
        assertEquals(rectangle.getY(),Math.rint(rectangleTool.getShape().getLayoutBounds().getMinY()),1);
    }

    /**
     * Test of onMouseDragged method, of class RectangleTool.
     */
    @Test
    public void testOnMouseDragged() {
        System.out.println("onMouseDragged");
       
        
        MouseEvent event1 = new MouseEvent(MouseEvent.MOUSE_PRESSED, 10, 10, 10, 10,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        rectangleTool.onMousePressed(event1, strokeColor, fillColor);
        
        MouseEvent event2 = new MouseEvent(MouseEvent.MOUSE_DRAGGED, 30, 30, 30, 30,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        
        rectangleTool.onMouseDragged(event2);
        assertEquals(rectangle.getX() + rectangle.getWidth(),30 + Math.rint(rectangleTool.getShape().getLayoutBounds().getMaxX()),1);
        assertEquals(rectangle.getY() + rectangle.getHeight(),30 + Math.rint(rectangleTool.getShape().getLayoutBounds().getMaxY()),1);
    }

    /**
     * Test of onMouseReleased method, of class RectangleTool.
     */
    @Test
    public void testOnMouseReleased() {
        System.out.println("onMouseReleased");
        MouseEvent event = null;
        RectangleTool instance = null;
        instance.onMouseReleased(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
      
    
}
