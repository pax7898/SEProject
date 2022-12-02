/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pasqualecaggiano
 */
public class LineToolTest {
    
    public LineToolTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getShape method, of class LineTool.
     */
    @Test
    public void testGetShape() {
        System.out.println("getShape");
        LineTool instance = null;
        Shape expResult = null;
        Shape result = instance.getShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onMousePressed method, of class LineTool.
     */
    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        MouseEvent event = new MouseEvent(new Pane(), 0, 0, 0, 100, 100, 1, false);
        Color strokeColor = null;
        Color fillColor = null;
        LineTool instance = null;
        instance.onMousePressed(event, strokeColor, fillColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
