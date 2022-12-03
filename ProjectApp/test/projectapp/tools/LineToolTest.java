/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.command.CommandExecutor;

/**
 *
 * @author pasqualecaggiano
 */
public class LineToolTest {
    private Tool lineTool;
    private Pane pane;
    private CommandExecutor executor;
    private Line line ;
    
    
    @Before
    public void setUp() {
        pane = new Pane();
        executor = new CommandExecutor();
        lineTool = new LineTool(pane,executor);
        line = new Line(20,20,50,50);
    }

   
    /**
     * Test of onMousePressed method, of class LineTool.
     */
    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        
        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        lineTool.onMousePressed(event, strokeColor, fillColor);
        
        assertEquals(1,pane.getChildren().size());
        
        assertEquals(line.getStartX(),Math.rint(lineTool.getShape().getLayoutBounds().getMinX()),1);
        assertEquals(line.getStartY(),Math.rint(lineTool.getShape().getLayoutBounds().getMinX()),1);
        
    }
    
    @Test
    public void testOnMouseDragged() {
        System.out.println("onMouseDragged");
        MouseEvent event1 = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        lineTool.onMousePressed(event1, strokeColor, fillColor);
        
        MouseEvent event2 = new MouseEvent(MouseEvent.MOUSE_DRAGGED, 30, 30, 30, 30,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        
        lineTool.onMouseDragged(event2);
        assertEquals(line.getEndX(),20 + Math.rint(lineTool.getShape().getLayoutBounds().getMaxX()),1);
        assertEquals(line.getEndY(),20 + Math.rint(lineTool.getShape().getLayoutBounds().getMaxX()),1);
    }
    
    @Test
    public void testOnMouseReleased() {
        System.out.println("onMouseReleased");
        MouseEvent event1 = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        Color strokeColor = Color.RED;
        Color fillColor = Color.BLUE;
        lineTool.onMousePressed(event1, strokeColor, fillColor);
        
        MouseEvent event2 = new MouseEvent(MouseEvent.MOUSE_RELEASED, 30, 30, 30, 30,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        
        lineTool.onMouseReleased(event2);
        assertEquals(line.getEndX(),20 + Math.rint(lineTool.getShape().getLayoutBounds().getMaxX()),1);
        assertEquals(line.getEndY(),20 + Math.rint(lineTool.getShape().getLayoutBounds().getMaxX()),1);   
    }

    /**
     * Test of getShape method, of class LineTool.
     */
    @Test
    public void testGetShape() {
       System.out.println("getShape");
       
       assertEquals(null,lineTool.getShape());
       
       MouseEvent event1 = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
       Color strokeColor = Color.RED;
       Color fillColor = Color.BLUE;
       lineTool.onMousePressed(event1, strokeColor, fillColor);
       
        assertEquals(line.getClass(),lineTool.getShape().getClass());
       
    }

}
