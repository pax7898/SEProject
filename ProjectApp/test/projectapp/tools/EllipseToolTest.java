/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.command.CommandExecutor;

/**
 *
 * @author acoon
 */
public class EllipseToolTest {
    private Pane pane;
    private CommandExecutor executor;
    private Tool ellipseTool;
    private Ellipse ellipse;
    private MouseEvent pressEvent;
    private MouseEvent draggedEvent;
    
    @Before
    public void setUp() {
        
        pane = new Pane();
        executor = new CommandExecutor();
        ellipseTool = new EllipseTool(pane,executor);
        ellipse = new Ellipse(0,0,30,30);
        pressEvent = new MouseEvent(MouseEvent.MOUSE_PRESSED, 30, 30, 30, 30, MouseButton.PRIMARY, 1,  
                                false, false,false,false,false,false,false,false,false,false,null);
        draggedEvent = new MouseEvent(MouseEvent.MOUSE_DRAGGED, 10, 10, 10, 10,MouseButton.PRIMARY, 1,
                                           false, false,false,false,false,false,false,false,false,false,null);
        
    }

    @Test
    public void testGetShape() {
        System.out.println("getShape");
        ellipseTool.onMousePressed(pressEvent, Color.DARKVIOLET, Color.SILVER);        
        assertEquals(ellipse.getClass(), ellipseTool.getShape().getClass());
        assertEquals(ellipse.getRadiusX(), Math.rint(ellipseTool.getShape().getLayoutBounds().getMinX()), 0);  
        assertEquals(ellipse.getRadiusY(), Math.rint(ellipseTool.getShape().getLayoutBounds().getMinY()), 0);  

    }

    @Test
    public void testOnMousePressed() { 
        System.out.println("onMousePressed");
        
        
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        ellipseTool.onMousePressed(pressEvent, strokeColor, fillColor);
        
        assertEquals(1,pane.getChildren().size());
        
        assertEquals(ellipse.getRadiusX(),Math.rint(ellipseTool.getShape().getLayoutBounds().getMinX()),1);
        assertEquals(ellipse.getRadiusY(),Math.rint(ellipseTool.getShape().getLayoutBounds().getMinY()),1);
        
        
    }

    @Test
    public void testOnMouseDragged() {
        System.out.println("onMouseDragged");
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        ellipseTool.onMousePressed(pressEvent, strokeColor, fillColor);
        
        assertEquals(ellipse.getRadiusX(), Math.rint(ellipseTool.getShape().getLayoutBounds().getMinX()),1);
        assertEquals(ellipse.getRadiusY(), Math.rint(ellipseTool.getShape().getLayoutBounds().getMinY()),1);
        ellipseTool.onMouseDragged(draggedEvent);
        assertEquals(ellipse.getRadiusX(),Math.rint(ellipseTool.getShape().getLayoutBounds().getMaxX()),1); //I do +20 given that I'm moving from 10 to 30
        assertEquals(ellipse.getRadiusY(),Math.rint(ellipseTool.getShape().getLayoutBounds().getMaxY()),1);
    }

    @Test
    public void testOnMouseReleased() {
        System.out.println("onMouseReleased");
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        ellipseTool.onMousePressed(pressEvent, strokeColor, fillColor);
        MouseEvent releasedEvent = new MouseEvent(MouseEvent.MOUSE_RELEASED, 30, 30, 30, 30, MouseButton.PRIMARY, 1, //I release at the end of drag
                                           false, false,false,false,false,false,false,false,false,false,null);
        ellipseTool.onMouseDragged(draggedEvent);
        ellipseTool.onMouseReleased(releasedEvent);
        assertEquals(ellipse.getRadiusX(),Math.rint(ellipseTool.getShape().getLayoutBounds().getMaxX()),1);
        assertEquals(ellipse.getRadiusY(),Math.rint(ellipseTool.getShape().getLayoutBounds().getMaxX()),1);   
    }

    @Test
    public void testChangeBorderColor(){}

    @Test
    public void testChangeInteriorColor(){}

    @Test
    public void testDeleteShape(){}

    @Test
    public void testCopyShape(){}

    @Test
    public void testCutShape(){}

    @Test
    public void testPasteShape(){}
    
}
