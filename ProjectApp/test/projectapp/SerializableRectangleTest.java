/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sabatino
 */
public class SerializableRectangleTest {
    
    private SerializableRectangle rectangle;
    
    
    public SerializableRectangleTest() {
    }
    
    
    
    @Before
    public void setUp() {
        rectangle = new SerializableRectangle(10,10,10,10,Color.BLACK);
    }
    

    /**
     * Test of createView method, of class SerializableRectangle.
     */
    @Test
    public void testCreateView() {
        System.out.println("createView");
        Rectangle myRectangle = rectangle.getRectangle();
        assertEquals(myRectangle, rectangle.getShape()); 
    }

    /**
     * Test of getX method, of class SerializableRectangle.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        SerializableRectangle instance = null;
        double expResult = 0.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class SerializableRectangle.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        double x1 = 0.0;
        SerializableRectangle instance = null;
        instance.setX(x1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class SerializableRectangle.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        SerializableRectangle instance = null;
        double expResult = 0.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class SerializableRectangle.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        double y1 = 0.0;
        SerializableRectangle instance = null;
        instance.setY(y1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrokeColor method, of class SerializableRectangle.
     */
    @Test
    public void testGetStrokeColor() {
        System.out.println("getStrokeColor");
        SerializableRectangle instance = null;
        Color expResult = null;
        Color result = instance.getStrokeColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStrokeColor method, of class SerializableRectangle.
     */
    @Test
    public void testSetStrokeColor() {
        System.out.println("setStrokeColor");
        Color strokeColor = null;
        SerializableRectangle instance = null;
        instance.setStrokeColor(strokeColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFillColor method, of class SerializableRectangle.
     */
    @Test
    public void testGetFillColor() {
        System.out.println("getFillColor");
        SerializableRectangle instance = null;
        Color expResult = null;
        Color result = instance.getFillColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFillColor method, of class SerializableRectangle.
     */
    @Test
    public void testSetFillColor() {
        System.out.println("setFillColor");
        Color fillColor = null;
        SerializableRectangle instance = null;
        instance.setFillColor(fillColor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRectangle method, of class SerializableRectangle.
     */
    @Test
    public void testGetRectangle() {
        System.out.println("getRectangle");
        SerializableRectangle instance = null;
        Rectangle expResult = null;
        Rectangle result = instance.getRectangle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRectangle method, of class SerializableRectangle.
     */
    @Test
    public void testSetRectangle() {
        System.out.println("setRectangle");
        Rectangle rectangle = null;
        SerializableRectangle instance = null;
        instance.setRectangle(rectangle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class SerializableRectangle.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        SerializableRectangle instance = null;
        double expResult = 0.0;
        double result = instance.getWidth();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class SerializableRectangle.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        double x2 = 0.0;
        SerializableRectangle instance = null;
        instance.setWidth(x2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeigth method, of class SerializableRectangle.
     */
    @Test
    public void testGetHeigth() {
        System.out.println("getHeigth");
        SerializableRectangle instance = null;
        double expResult = 0.0;
        double result = instance.getHeigth();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeigth method, of class SerializableRectangle.
     */
    @Test
    public void testSetHeigth() {
        System.out.println("setHeigth");
        double y2 = 0.0;
        SerializableRectangle instance = null;
        instance.setHeigth(y2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
