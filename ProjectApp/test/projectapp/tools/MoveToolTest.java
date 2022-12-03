/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acoon
 */
public class MoveToolTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        MouseEvent event = null;
        Color strokeColor = null;
        Color fillColor = null;
        MoveTool instance = null;
        instance.onMousePressed(event, strokeColor, fillColor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOnMouseDragged() {
        System.out.println("onMouseDragged");
        MouseEvent event = null;
        MoveTool instance = null;
        instance.onMouseDragged(event);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOnMouseReleased() {
        System.out.println("onMouseReleased");
        MouseEvent event = null;
        MoveTool instance = null;
        instance.onMouseReleased(event);
        fail("The test case is a prototype.");
    }

    @Test
    public void testChangeBorderColor() {
        System.out.println("changeBorderColor");
        Color strokeColor = null;
        MoveTool instance = null;
        instance.changeBorderColor(strokeColor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testChangeInteriorColor() {
        System.out.println("changeInteriorColor");
        Color strokeColor = null;
        MoveTool instance = null;
        instance.changeInteriorColor(strokeColor);
        fail("The test case is a prototype.");
    }
    
}
