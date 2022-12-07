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
import javafx.geometry.Point2D;
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
import projectapp.command.Command;
import projectapp.command.CommandExecutor;
import projectapp.command.DeleteCommand;
import projectapp.command.DrawCommand;
import projectapp.tools.LineTool;
import projectapp.tools.MoveTool;
import projectapp.tools.SelectionTool;
import projectapp.tools.Tool;
import singletons.Clonator;
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
        menu.getItems().add(new MenuItem("delete"));
        menu.getItems().add(new MenuItem("copy"));
        menu.getItems().add(new MenuItem("cut"));
        menu.getItems().add(new MenuItem("paste"));
        menu.getItems().add(new MenuItem("move"));
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
       // Alredy testes in each tools that implements the onMousePressed method
    }

    /**
     * Test of onMouseDragged method, of class DrawingEditor.
     */
    @Test
    public void testOnMouseDragged() {
        // Alredy testes in each tools that implements the onMouseDragged method
    }

    /**
     * Test of onMouseReleased method, of class DrawingEditor.
     */
    @Test
    public void testOnMouseReleased() {
      // Alredy testes in each tools that implements the onMouseReleased method
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
        System.out.println("deleteShape");
        
        drawingPane.getChildren().add(shape);

        editor.setSelectionTool();
        
        selectedShape.setShape(shape);
        
        editor.deleteShape();
        
        assertEquals(0,drawingPane.getChildren().size());
        
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
        System.out.println("copyShape");
        drawingPane.getChildren().add(shape);
        
        editor.setSelectionTool();
        
        selectedShape.setShape(shape);
        
        editor.copyShape();
        
        Rectangle rectangle2 = (Rectangle) Clonator.getIstance().decodeFromXml();
        Rectangle originalRectangle = (Rectangle) shape;
        assertEquals(originalRectangle.getX(), rectangle2.getX(),0);
        assertEquals(originalRectangle.getY(), rectangle2.getY(),0);
        assertEquals(originalRectangle.getWidth(), rectangle2.getWidth(),0);
        assertEquals(originalRectangle.getHeight(), rectangle2.getHeight(),0);
        assertEquals(originalRectangle.getStroke(), rectangle2.getStroke());
        assertEquals(originalRectangle.getFill(), rectangle2.getFill());
    }
    
    /**
     * Test of toFront method, of class DrawingEditor.
     */
    @Test
    public void testPasteShape() {
        System.out.println("pasteShape");
        
        Rectangle originalRectangle = (Rectangle) shape;
        
        drawingPane.getChildren().add(shape);

        editor.setSelectionTool();
        
        selectedShape.setShape(shape);
        
        /*
            COPY + PASTE
        */
        editor.copyShape();
        editor.pasteShape(new Point2D(30,40));
        
        
        Rectangle rectangle2 = (Rectangle) drawingPane.getChildren().get(0);
        
        assertEquals(originalRectangle.getX(), rectangle2.getX(),0);
        assertEquals(originalRectangle.getY(), rectangle2.getY(),0);
        assertEquals(originalRectangle.getWidth(), rectangle2.getWidth(),0);
        assertEquals(originalRectangle.getHeight(), rectangle2.getHeight(),0);
        assertEquals(originalRectangle.getStroke(), rectangle2.getStroke());
        assertEquals(originalRectangle.getFill(), rectangle2.getFill());
        
        /*
            CUT + PASTE
        */
        
       
        editor.cutShape();
        editor.pasteShape(new Point2D(30,40));
        
        
        Rectangle rectangle3 = (Rectangle) drawingPane.getChildren().get(0);
        
        assertEquals(originalRectangle.getX(), rectangle3.getX(),0);
        assertEquals(originalRectangle.getY(), rectangle3.getY(),0);
        assertEquals(originalRectangle.getWidth(), rectangle3.getWidth(),0);
        assertEquals(originalRectangle.getHeight(), rectangle3.getHeight(),0);
        assertEquals(originalRectangle.getStroke(), rectangle3.getStroke());
        assertEquals(originalRectangle.getFill(), rectangle3.getFill());
        
        
    }
    
    @Test
    public void testCutShape() {
        System.out.println("cutShape");

        drawingPane.getChildren().add(shape);
        
        editor.setSelectionTool();
        
        selectedShape.setShape(shape);
        
        editor.cutShape();
        
        assertFalse(drawingPane.getChildren().contains(shape));
        
        Rectangle rectangle2 = (Rectangle) Clonator.getIstance().decodeFromXml();
        Rectangle originalRectangle = (Rectangle) shape;
        assertEquals(originalRectangle.getX(), rectangle2.getX(),0);
        assertEquals(originalRectangle.getY(), rectangle2.getY(),0);
        assertEquals(originalRectangle.getWidth(), rectangle2.getWidth(),0);
        assertEquals(originalRectangle.getHeight(), rectangle2.getHeight(),0);
        assertEquals(originalRectangle.getStroke(), rectangle2.getStroke());
        assertEquals(originalRectangle.getFill(), rectangle2.getFill());
        
        assertFalse(menu.getItems().get(3).isDisable());
        
    }

    
    /**
     * Test of toFront method, of class DrawingEditor.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        
        editor.setRectangleTool();
        MouseEvent press = new MouseEvent(MouseEvent.MOUSE_PRESSED, 20, 20, 20, 20,MouseButton.PRIMARY, 1, false, false,false,false,false,false,false,false,false,false,null);
        editor.onMousePressed(press, Color.DARKVIOLET, Color.SILVER);
        
        assertEquals(1,drawingPane.getChildren().size());
        assertEquals(1,executor.getStack().size());
        
        editor.undo();
        
        assertEquals(0,drawingPane.getChildren().size());
        assertEquals(0,executor.getStack().size());
        
        
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
