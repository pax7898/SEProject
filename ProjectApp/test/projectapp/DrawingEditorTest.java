/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import java.io.File;
import javafx.collections.ObservableList;
import javafx.scene.Node;
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
import projectapp.command.CommandExecutor;
import projectapp.tools.LineTool;
import projectapp.tools.Tool;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawingEditorTest {
    private Pane drawingPane; 
    private Tool currentTool;
    private CommandExecutor executor;
    private DrawingEditor editor;
    
    
    @Before
    public void setUp() {
        drawingPane = new Pane();
        executor = new CommandExecutor();
        currentTool = new LineTool(drawingPane,executor);
        editor = new DrawingEditor(drawingPane,executor,currentTool);
    }

    /**
     * Test of setLineTool method, of class DrawingEditor.
     */
    @Test
    public void testSetLineTool() {
        System.out.println("setLineTool");
        
        editor.setLineTool();
        
        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        editor.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        
        Line line = new Line(0,0,0,0);
        assertEquals(line.getClass(),drawingPane.getChildren().get(0).getClass()); 
    }

    /**
     * Test of setRectangleTool method, of class DrawingEditor.
     */
    @Test
    public void testSetRectangleTool() {
        System.out.println("setRectangleTool");
        
        editor.setRectangleTool();
        
        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        editor.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        
        Rectangle rectangle = new Rectangle(0,0,0,0);
        assertEquals(rectangle.getClass(),drawingPane.getChildren().get(0).getClass()); 
    }

    /**
     * Test of setEllipseTool method, of class DrawingEditor.
     */
    @Test
    public void testSetEllipseTool() {
        System.out.println("setRectangleTool");
        
        editor.setEllipseTool();
        
        MouseEvent event = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        editor.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        
        Ellipse ellipse = new Ellipse(0,0,0,0);
        assertEquals(ellipse.getClass(),drawingPane.getChildren().get(0).getClass()); 
        
    }

    /**
     * Test of setSelectionTool method, of class DrawingEditor.
     */
    @Test
    public void testSetSelectionTool() {
        
    }

    /**
     * Test of setMoveTool method, of class DrawingEditor.
     */
    @Test
    public void testSetMoveTool() {
       
    }

    /**
     * Test of setResizeTool method, of class DrawingEditor.
     */
    @Test
    public void testSetResizeTool() {
        
    }

    /**
     * Test of onMousePressed method, of class DrawingEditor.
     */
    @Test
    public void testOnMousePressed() {
       
    }

    /**
     * Test of onMouseDragged method, of class DrawingEditor.
     */
    @Test
    public void testOnMouseDragged() {
        
    }

    /**
     * Test of onMouseReleased method, of class DrawingEditor.
     */
    @Test
    public void testOnMouseReleased() {
      
    }

    /**
     * Test of changeBorderColor method, of class DrawingEditor.
     */
    @Test
    public void testChangeBorderColor() {
        
    }

    /**
     * Test of changeInteriorColor method, of class DrawingEditor.
     */
    @Test
    public void testChangeInteriorColor() {
       
    }

    /**
     * Test of deleteShape method, of class DrawingEditor.
     */
    @Test
    public void testDeleteShape() {
        
    }

    /**
     * Test of copyShape method, of class DrawingEditor.
     */
    @Test
    public void testCopyShape() {
    }

    /**
     * Test of cutShape method, of class DrawingEditor.
     */
    @Test
    public void testCutShape() {
    }

    /**
     * Test of pasteShape method, of class DrawingEditor.
     */
    @Test
    public void testPasteShape() {
    }
    
    
    /**
     * Test of saveDrawing method, of class DrawingEditor.
     */
    @Test
    public void testSaveDrawing() {
        System.out.println("saveDrawing");
        
        Line line = new Line(10,10,20,20);
        line.setStroke(Color.RED);
        Rectangle rectangle = new Rectangle(10,10,20,20);
        rectangle.setStroke(Color.RED);
        rectangle.setFill(Color.BLUE);
        Ellipse ellipse = new Ellipse(10,10,20,20);
        ellipse.setStroke(Color.RED);
        ellipse.setFill(Color.BLUE);
        drawingPane.getChildren().addAll(line,rectangle,ellipse);
        
        ObservableList<Node> savedList = drawingPane.getChildren();
        
        File file = new File("test.xml");
        editor.saveDrawing(file);

        editor.loadDrawing(file);
        
        assertArrayEquals(savedList.toArray(), drawingPane.getChildren().toArray());

        file.delete();
    }

    /**
     * Test of loadDrawing method, of class DrawingEditor.
     */
    @Test
    public void testLoadDrawing() {
        //Alredy tested in testSaveDrawing
    }

    /**
     * Test of undo method, of class DrawingEditor.
     */
    @Test
    public void testUndo() {
    }
    
}
