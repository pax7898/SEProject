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
    
    
    @Before
    public void setUp() {
        lineTool = new LineTool(new Pane(),new CommandExecutor());
    }

    /**
     * Test of getShape method, of class LineTool.
     */
    @Test
    public void testGetShape() {
       
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
        
    }

    /**
     * Test of onMouseDragged method, of class LineTool.
     */
    @Test
    public void testOnMouseDragged() {
        System.out.println("onMouseDragged");
        MouseEvent event = null;
        LineTool instance = null;
        instance.onMouseDragged(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onMouseReleased method, of class LineTool.
     */
    @Test
    public void testOnMouseReleased() {
        System.out.println("onMouseReleased");
        MouseEvent event = null;
        LineTool instance = null;
        instance.onMouseReleased(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeBorderColor method, of class LineTool.
     */
    @Test
    public void testChangeBorderColor() {
        System.out.println("changeBorderColor");
        Color strokeColor = null;
        LineTool instance = null;
        instance.changeBorderColor(strokeColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeInteriorColor method, of class LineTool.
     */
    @Test
    public void testChangeInteriorColor() {
        System.out.println("changeInteriorColor");
        Color strokeColor = null;
        LineTool instance = null;
        instance.changeInteriorColor(strokeColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteShape method, of class LineTool.
     */
    @Test
    public void testDeleteShape() {
        System.out.println("deleteShape");
        LineTool instance = null;
        instance.deleteShape();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyShape method, of class LineTool.
     */
    @Test
    public void testCopyShape() {
        System.out.println("copyShape");
        LineTool instance = null;
        instance.copyShape();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cutShape method, of class LineTool.
     */
    @Test
    public void testCutShape() {
        System.out.println("cutShape");
        LineTool instance = null;
        instance.cutShape();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pasteShape method, of class LineTool.
     */
    @Test
    public void testPasteShape() {
        System.out.println("pasteShape");
        LineTool instance = null;
        instance.pasteShape();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
