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
public class SelectionToolTest {
    
    public SelectionToolTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getSelectedShape method, of class SelectionTool.
     */
    @Test
    public void testGetSelectedShape() {
        System.out.println("getSelectedShape");
        SelectionTool instance = null;
        Shape expResult = null;
        Shape result = instance.getSelectedShape();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelectedShape method, of class SelectionTool.
     */
    @Test
    public void testSetSelectedShape() {
        System.out.println("setSelectedShape");
        Shape selectedShape = null;
        SelectionTool instance = null;
        instance.setSelectedShape(selectedShape);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        MouseEvent event = null;
        Color strokeColor = null;
        Color fillColor = null;
        SelectionTool instance = null;
        instance.onMousePressed(event, strokeColor, fillColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeBorderColor method, of class SelectionTool.
     */
    @Test
    public void testChangeBorderColor() {
        System.out.println("changeBorderColor");
        Color strokeColor = null;
        SelectionTool instance = null;
        instance.changeBorderColor(strokeColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeInteriorColor method, of class SelectionTool.
     */
    @Test
    public void testChangeInteriorColor() {
        System.out.println("changeInteriorColor");
        Color fillColor = null;
        SelectionTool instance = null;
        instance.changeInteriorColor(fillColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteShape method, of class SelectionTool.
     */
    @Test
    public void testDeleteShape() {
        System.out.println("deleteShape");
        SelectionTool instance = null;
        instance.deleteShape();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
