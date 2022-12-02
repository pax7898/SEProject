/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.command.CommandExecutor;
import projectapp.shape.SerializableEllipse;
import projectapp.shape.SerializableLine;
import projectapp.shape.SerializableRectangle;
import projectapp.shape.SerializableShape;
import projectapp.tools.EditorState;
import projectapp.tools.LineState;
import projectapp.tools.RectangleState;


/**
 *
 * @author pasqualecaggiano
 */
public class DrawingEditorTest {
    
    private DrawingEditor editor;
    
    private Pane mainPane;
    
    private Pane drawingPane;
    
    private EditorState currentState;
    
    private ObservableList<SerializableShape> listItems;
    
    private CommandExecutor executor;
    
    
    private ListView drawnView;
    
    private double startX;
    private double startY; 
   
    @Before
    public void setUp() {
        JFXPanel pn = new JFXPanel();
        
        drawnView = new ListView();
        mainPane = new Pane();
        drawingPane = new Pane();
        listItems = FXCollections.observableArrayList();
        currentState = new LineState(drawingPane,listItems);
        executor = new CommandExecutor();
       
        
        editor = new DrawingEditor(drawingPane,currentState,listItems,executor,drawnView);
        
    }
    
     
    /**
     * Test of getCurrentState method, of class DrawingEditor.
     */
   
    @Test
    public void testGetCurrentState() {
        System.out.println("getCurrentState");
        EditorState expResult = currentState;
        EditorState result = editor.getCurrentState();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of setCurrentState method, of class DrawingEditor.
     */
    
    
    @Test
    public void testSetCurrentState() {
        System.out.println("setCurrentState");
        EditorState currentState = new RectangleState(drawingPane,listItems);
        editor.setCurrentState(currentState);
        assertEquals(currentState,editor.getCurrentState());
    }
    

    /**
     * Test of getStartX method, of class DrawingEditor.
     */
    @Test
    public void testGetStartX() {
        System.out.println("getStartX");
        double expResult = 0.0;
        double result = editor.getStartX();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of setStartX method, of class DrawingEditor.
     */
    @Test
    public void testSetStartX() {
        System.out.println("setStartX");
        double startX = 5.0;
        editor.setStartX(startX);
        assertEquals(startX,editor.getStartX(),0.0);
    }

    /**
     * Test of getStartY method, of class DrawingEditor.
     */
    @Test
    public void testGetStartY() {
        System.out.println("getStartY");
        DrawingEditor instance = null;
        double expResult = 0.0;
        double result = editor.getStartY();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of setStartY method, of class DrawingEditor.
     */
    @Test
    public void testSetStartY() {
        System.out.println("setStartY");
        double startY = 5.0;
        editor.setStartY(startY);
        assertEquals(startY,editor.getStartY(),0.0);
    }

    /**
     * Test of getStringList method, of class DrawingEditor.
     */
    @Test
    public void testGetStringList() {
        System.out.println("getStringList");
        SerializableLine line = new SerializableLine(1,1,2,2,Color.BLACK,Color.WHITE);
        SerializableRectangle rectangle = new SerializableRectangle(1,1,2,2,Color.BLACK,Color.WHITE);
        SerializableEllipse ellipse = new SerializableEllipse(1,1,2,2,Color.BLACK,Color.WHITE);
        
        listItems.addAll(line,rectangle,ellipse);
        
        ObservableList<String> expResult = FXCollections.observableArrayList(line.toString(),rectangle.toString(),ellipse.toString());
        
        ObservableList<String> result = editor.getStringList();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setLineState method, of class DrawingEditor.
     */
    @Test
    public void testSetLineState() {
        System.out.println("setLineState");
        editor.setCurrentState(new RectangleState(drawingPane,listItems));
        EditorState setState = editor.setLineState();
        assertEquals(setState,editor.getCurrentState());
        
    }

    /**
     * Test of setRectangleState method, of class DrawingEditor.
     */
    @Test
    public void testSetRectangleState() {
        System.out.println("setRectangleState");
        EditorState setState = editor.setRectangleState();
        assertEquals(setState,editor.getCurrentState());
    }

    /**
     * Test of setEllipseState method, of class DrawingEditor.
     */
    @Test
    public void testSetEllipseState() {
        System.out.println("setEllipseState");
        
        EditorState setState = editor.setEllipseState();
        assertEquals(setState,editor.getCurrentState());
    }

    /**
     * Test of executeDrawCommand method, of class DrawingEditor.
     */
    
    @Test
    public void testExecuteDrawCommand() {
        System.out.println("executeDrawCommand");

        ObservableList<String> list = FXCollections.observableArrayList();
       
        double endX = 5.0;
        double endY = 5.0;
        Color strokeColor = Color.RED;
        Color fillColor = Color.WHITE;
        SerializableLine line = new SerializableLine(startX,startY,endX,endY,strokeColor,fillColor);
        list.add(line.toString());
        
        editor.executeDrawCommand(endX, endY, strokeColor, fillColor);
        
        assertEquals(list,drawnView.getItems());
        
    }
    
    /**
     * Test of executeDrawCommand method, of class DrawingEditor.
     */
    
    
    @Test
    public void testSaveDrawing() {
         System.out.println("saveDrawing");
         
         editor.executeDrawCommand(30, 30, Color.DARKVIOLET, Color.SILVER);
         editor.executeDrawCommand(50, 50, Color.DARKVIOLET, Color.SILVER);
         editor.executeDrawCommand(90, 90, Color.DARKVIOLET, Color.SILVER);
         
         File file = new File("test.dat");
         editor.saveDrawing(file);
         
         ObservableList<SerializableShape> listSaved = FXCollections.observableArrayList(listItems);
         
         editor.loadDrawing(file);

         assertEquals(listSaved.toString(),listItems.toString());
         file.delete();
     
    }
    
    @Test 
    public void testLoadDrawing(){
        //Already tested in testLoadDrawing
    }
}
