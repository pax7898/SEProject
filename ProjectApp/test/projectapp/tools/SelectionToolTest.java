/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.event.EventType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.SelectedShape;
import projectapp.command.ChangeBorderColorCommand;
import projectapp.command.ChangeInteriorColorCommand;
import projectapp.command.Command;
import projectapp.command.CommandExecutor;
import projectapp.command.DeleteCommand;

/**
 *
 * @author pasqualecaggiano
 */
public class SelectionToolTest {
    private SelectionTool tool;
    private SelectedShape selectedShape;
    private Pane pane;
    private CommandExecutor executor;
    private Shape shape;
    
    public SelectionToolTest() {
    }
    
    @Before
    public void setUp() {
        shape = new Rectangle(20,20,30,30);
        shape.setFill(Color.BLUE);
        shape.setStroke(Color.BLUE);
        pane = new Pane();
        pane.getChildren().add(shape);
        selectedShape = new SelectedShape(shape);
        

        executor = new CommandExecutor();
        tool = new SelectionTool(pane,selectedShape,executor);
        
    }

    /**
     * Test of getSelectedShape method, of class SelectionTool.
     */
    @Test
    public void testGetSelectedShape() {
        System.out.println("getSelectedShape");
        
        assertEquals(selectedShape,tool.getSelectedShape());
        
    }

    /**
     * Test of getSavedShape method, of class SelectionTool.
     */
    @Test
    public void testGetSavedShape() {
        
    }

    /**
     * Test of setSavedShape method, of class SelectionTool.
     */
    @Test
    public void testSetSavedShape() {
        
    }

    /**
     * Test of onMousePressed method, of class SelectionTool.
     */
    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        MouseEvent event = new MouseEvent(null, shape, new EventType(), 100, 150, 0, 0, MouseButton.PRIMARY, 0, false, false, false, false, false, false, false, false, false, false, null);
        SelectionTool test = new SelectionTool(pane, selectedShape, executor);
        test.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        assertEquals(shape.getStyle(),"-fx-stroke-dash-array:5px");
    }

    /**
     * Test of changeBorderColor method, of class SelectionTool.
     */
    @Test
    public void testChangeBorderColor() {
        System.out.println("changeBorderColor");
        Command border= new ChangeBorderColorCommand(shape, Color.RED);
        tool.changeBorderColor(Color.RED);
        assertEquals(shape.getStroke(),Color.RED);
        assertEquals(border.getClass(),executor.getStack().getLast().getClass());
        
        
        
    }

    /**
     * Test of changeInteriorColor method, of class SelectionTool.
     */
    @Test
    public void testChangeInteriorColor() {
        System.out.println("changeInteriorColor");
        Command interior= new ChangeInteriorColorCommand(shape, Color.RED);
        tool.changeInteriorColor(Color.RED);
        assertEquals(shape.getFill(),Color.RED);
        assertEquals(interior.getClass(),executor.getStack().getLast().getClass());
        
    }

    /**
     * Test of deleteShape method, of class SelectionTool.
     */
    @Test
    public void testDeleteShape() {
        System.out.println("deleteShape");
        DeleteCommand command = new DeleteCommand(shape,pane);
        tool.deleteShape();
        assertTrue(!pane.getChildren().contains(shape));
        assertEquals(command.getClass(),executor.getStack().getLast().getClass());
    }

    /**
     * Test of copyShape method, of class SelectionTool.
     */
    @Test
    public void testCopyShape() {
        
    }

    /**
     * Test of cutShape method, of class SelectionTool.
     */
    @Test
    public void testCutShape() {
        
    }

    /**
     * Test of pasteShape method, of class SelectionTool.
     */
    @Test
    public void testPasteShape() {
        
    }

    /**
     * Test of onMouseDragged method, of class SelectionTool.
     */
    @Test
    public void testOnMouseDragged() {
        
    }

    /**
     * Test of onMouseReleased method, of class SelectionTool.
     */
    @Test
    public void testOnMouseReleased() {
        
    }

    /**
     * Test of getShape method, of class SelectionTool.
     */
    @Test
    public void testGetShape() {
        
    }
    
}
