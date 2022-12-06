/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.event.EventType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import singletons.SelectedShape;
import projectapp.command.CommandExecutor;

/**
 *
 * @author acoon
 */
public class MoveToolTest {
    
    private MouseEvent pressEvent;
    private MouseEvent dragEvent;
    MoveTool moveTool;
    SelectedShape selectedShape;
    Ellipse ellipse;
    Line line;
    Rectangle rectangle;
    MouseEvent releasedEvent;
    ContextMenu menu;
    
    @Before
    public void setUpEllipse() {
        ellipse = new Ellipse(10,10,10,10);
        selectedShape = SelectedShape.getIstance();
        CommandExecutor executor = new CommandExecutor();
        Pane pane = new Pane();
        menu = new ContextMenu();
        menu.getItems().add(new MenuItem());
        moveTool = new MoveTool(pane, selectedShape, executor,menu);
        dragEvent = new MouseEvent(MouseEvent.MOUSE_DRAGGED, 10, 10, 10, 10, MouseButton.PRIMARY, 1,
                                    false, false,false,false,false,false,false,false,false,false,null);
        releasedEvent = new MouseEvent(MouseEvent.MOUSE_RELEASED, 10, 10, 10, 10, MouseButton.PRIMARY, 1, //I release at the end of drag (60)
                                           false, false,false,false,false,false,false,false,false,false,null);
        
    }
    
    @Before
    public void setUpRectangle() {
        rectangle = new Rectangle(10,10,10,10);
        selectedShape = SelectedShape.getIstance();
        selectedShape.setShape(rectangle);
        CommandExecutor executor = new CommandExecutor();
        Pane pane = new Pane();
        moveTool = new MoveTool(pane, selectedShape, executor,menu);
        dragEvent = new MouseEvent(MouseEvent.MOUSE_DRAGGED, 10, 10, 10, 10, MouseButton.PRIMARY, 1,
                                    false, false,false,false,false,false,false,false,false,false,null);
        releasedEvent = new MouseEvent(MouseEvent.MOUSE_RELEASED, 10, 10, 10, 10, MouseButton.PRIMARY, 1, //I release at the end of drag (60)
                                           false, false,false,false,false,false,false,false,false,false,null);
        
    }
    
    @Before
    public void setUpLine() {
        line = new Line(10,10,10,10);
        selectedShape = SelectedShape.getIstance();
        selectedShape.setShape(line);
        CommandExecutor executor = new CommandExecutor();
        Pane pane = new Pane();
        moveTool = new MoveTool(pane, selectedShape, executor,menu);
        dragEvent = new MouseEvent(MouseEvent.MOUSE_DRAGGED, 10, 10, 10, 10, MouseButton.PRIMARY, 1,
                                    false, false,false,false,false,false,false,false,false,false,null);
        releasedEvent = new MouseEvent(MouseEvent.MOUSE_RELEASED, 10, 10, 10, 10, MouseButton.PRIMARY, 1, //I release at the end of drag (60)
                                           false, false,false,false,false,false,false,false,false,false,null);
        
    }

    @Test
    public void testOnMousePressedEllipse() {
        MouseEvent event = new MouseEvent(null, line, new EventType("evento1Ellipse"), 0, 0, 0, 0, MouseButton.PRIMARY, 0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        assertEquals(0, ellipse.getTranslateX(), 0);
        assertEquals(0, ellipse.getTranslateY(), 0);
        
    }

    @Test
    public void testOnMouseDraggedEllipse() {
        MouseEvent event1 = new MouseEvent(null, ellipse, new EventType("evento2Ellipse"), 0, 0, 0, 0, MouseButton.PRIMARY, 
                                           0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event1, Color.DARKVIOLET, Color.SILVER);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseDragged(dragEvent);
        assertEquals(moveTool.getNewX(), ellipse.getTranslateX(), 0);
        assertEquals(moveTool.getNewY(), ellipse.getTranslateY(), 0);
        
    }

    @Test
    public void testOnMouseReleasedEllipse() {
        MouseEvent event1 = new MouseEvent(null, ellipse, new EventType("evento3Ellipse"), 0, 0, 0, 0, MouseButton.PRIMARY, 
                                           0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event1, Color.DARKVIOLET, Color.SILVER);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseReleased(releasedEvent);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseReleased(releasedEvent);
        assertEquals(moveTool.getOldX(), ellipse.getTranslateX(), 0);
        assertEquals(moveTool.getOldY(), ellipse.getTranslateY(), 0);
    }
    
    @Test
    public void testOnMousePressedRectangle() {
        MouseEvent event = new MouseEvent(null, rectangle, new EventType("evento1Rectangle"), 0, 0, 0, 0, MouseButton.PRIMARY, 0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        assertEquals(0, rectangle.getTranslateX(), 0);
        assertEquals(0, rectangle.getTranslateY(), 0);
        
    }

    @Test
    public void testOnMouseDraggedRectangle() {
        MouseEvent event1 = new MouseEvent(null, rectangle, new EventType("evento2Rectangle"), 0, 0, 0, 0, MouseButton.PRIMARY, 
                                           0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event1, Color.DARKVIOLET, Color.SILVER);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseDragged(dragEvent);
        assertEquals(moveTool.getNewX(), rectangle.getTranslateX(), 0);
        assertEquals(moveTool.getNewY(), rectangle.getTranslateY(), 0);
        
    }

    @Test
    public void testOnMouseReleasedRectangle() {
        MouseEvent event1 = new MouseEvent(null, rectangle, new EventType("evento3Rectangle"), 0, 0, 0, 0, MouseButton.PRIMARY, 
                                           0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event1, Color.DARKVIOLET, Color.SILVER);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseReleased(releasedEvent);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseReleased(releasedEvent);
        assertEquals(moveTool.getOldX(), rectangle.getTranslateX(), 0);
        assertEquals(moveTool.getOldY(), rectangle.getTranslateY(), 0);
    }

    @Test
    public void testOnMousePressedLine() {
        MouseEvent event = new MouseEvent(null, line, new EventType("evento1Line"), 0, 0, 0, 0, MouseButton.PRIMARY, 0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        assertEquals(0, line.getTranslateX(), 0);
        assertEquals(0, line.getTranslateY(), 0);
        
    }

    @Test
    public void testOnMouseDraggedLine() {
        MouseEvent event1 = new MouseEvent(null, line, new EventType("evento2Line"), 0, 0, 0, 0, MouseButton.PRIMARY, 
                                           0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event1, Color.DARKVIOLET, Color.SILVER);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseDragged(dragEvent);
        assertEquals(moveTool.getNewX(), line.getTranslateX(), 0);
        assertEquals(moveTool.getNewY(), line.getTranslateY(), 0);
        
    }

    @Test
    public void testOnMouseReleasedLine() {
        MouseEvent event1 = new MouseEvent(null, line, new EventType("evento3Line"), 0, 0, 0, 0, MouseButton.PRIMARY, 
                                           0, false, false, false, false, false, false, false, false, false, false, null);
        moveTool.onMousePressed(event1, Color.DARKVIOLET, Color.SILVER);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseReleased(releasedEvent);
        moveTool.onMouseDragged(dragEvent);
        moveTool.onMouseReleased(releasedEvent);
        assertEquals(moveTool.getOldX(), line.getTranslateX(), 0);
        assertEquals(moveTool.getOldY(), line.getTranslateY(), 0);
    }

}
