/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import singletons.SelectedShape;
import singletons.DrawingEditor;
import java.io.File;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.command.CommandExecutor;
import projectapp.tools.LineTool;
import projectapp.tools.MoveTool;
import projectapp.tools.SelectionTool;
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
    private SelectedShape selectedShape;
    private Shape shape;
    private SelectionTool tool;
    private MoveTool moveTool;
    private ContextMenu menu;
    private JFXPanel panel;
    
    @Before
    public void setUp() {
        panel = new JFXPanel();
        drawingPane = new Pane();
        executor = new CommandExecutor();
        currentTool = new LineTool(drawingPane,executor);
        menu = new ContextMenu();
        menu.getItems().add(new MenuItem());
        editor = new DrawingEditor(drawingPane,executor,currentTool,menu);
        shape = new Rectangle(20,20,30,30);
        shape.setFill(Color.BLUE);
        shape.setStroke(Color.BLUE);
        
        selectedShape = SelectedShape.getIstance();
        
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
        System.out.println("setSelectionTool");
        editor.setSelectionTool();
        MouseEvent event = new MouseEvent(null, shape, new EventType("selection"), 100, 150, 0, 0, MouseButton.PRIMARY, 0, false, false, false, false, false, false, false, false, false, false, null);
        tool = new SelectionTool(drawingPane,selectedShape,executor,menu);
        tool.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        assertEquals(shape.getStyle(), "-fx-stroke-dash-array:5px");
    }

    /**
     * Test of setMoveTool method, of class DrawingEditor.
     */
    @Test
    public void testSetMoveTool() {
       System.out.println("setMoveTool"); 
       editor.setMoveTool();
       MouseEvent event = new MouseEvent(null, shape, new EventType("move"), 100, 150, 0, 0, MouseButton.PRIMARY, 0, false, false, false, false, false, false, false, false, false, false, null);
       moveTool=new MoveTool(drawingPane,executor,selectedShape,menu);
       moveTool.onMouseDragged(event);
       assertEquals(moveTool.getNewX(), shape.getTranslateX(), 0);
       assertEquals(moveTool.getNewY(), shape.getTranslateY(), 0);
        
       
       
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
     * Test of toFront method, of class DrawingEditor.
     */
    @Test
    public void testToFront() {
        
    }
    
    /**
     * Test of toFront method, of class DrawingEditor.
     */
    @Test
    public void testCopyshape() {
        
    }
    
    /**
     * Test of toFront method, of class DrawingEditor.
     */
    @Test
    public void testPasteShape() {
        
    }
    
    @Test
    public void testCutShape() {
        System.out.println("setCutTool");
        //(Pane pane,SelectedShape selectedShape,CommandExecutor executor, ContextMenu menu)
        System.out.println(drawingPane.getChildren().contains(shape));
        
    }

    
    /**
     * Test of toFront method, of class DrawingEditor.
     */
    @Test
    public void testUndo() {
        
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
   
}
