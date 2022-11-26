/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import projectapp.shape.SerializableRectangle;
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
        rectangle = new SerializableRectangle(10,10,10,10,Color.BLACK,Color.TRANSPARENT);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createView method, of class SerializableRectangle.
     */
    @Test
    public void testCreateView() {
        System.out.println("createView");
        
        assertEquals(rectangle.getRectangle().getX(), rectangle.getX(), 0);
        assertEquals(rectangle.getRectangle().getY(), rectangle.getY(), 0);
        assertEquals(rectangle.getRectangle().getWidth(), rectangle.getWidth(), 0);
        assertEquals(rectangle.getRectangle().getHeight(), rectangle.getHeight(), 0);
        assertEquals(rectangle.getRectangle().getStroke(), rectangle.getStrokeColor());
        assertEquals(rectangle.getRectangle().getFill(), rectangle.getFillColor());
        
        Rectangle rectangleTest = (Rectangle) rectangle.getShape();
        assertEquals(rectangleTest.getX(), rectangle.getRectangle().getX(),0);
        assertEquals(rectangleTest.getY(), rectangle.getRectangle().getY(),0);
        assertEquals(rectangleTest.getWidth(), rectangle.getRectangle().getWidth(),0);
        assertEquals(rectangleTest.getHeight(), rectangle.getRectangle().getHeight(),0);
        assertEquals(rectangleTest.getStroke(), rectangle.getRectangle().getStroke());        
        assertEquals(rectangleTest.getFill(), rectangle.getRectangle().getFill());
    }

    

    /**
     * Test of getX method, of class SerializableRectangle.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        
        double result = rectangle.getX();
        double expResult = 10;
        
        assertEquals(result, expResult, 0);
    }

    /**
     * Test of getY method, of class SerializableRectangle.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        
        double result = rectangle.getX();
        double expResult = 10;
        
        assertEquals(result, expResult, 0);
    }
    

    /**
     * Test of getStrokeColor method, of class SerializableRectangle.
     */
    @Test
    public void testGetStrokeColor() {
        System.out.println("getStrokeColor");
        
        Color result = rectangle.getStrokeColor();
        Color expResult = Color.BLACK;
        
        assertEquals(result, expResult);
    }


    /**
     * Test of getFillColor method, of class SerializableRectangle.
     */
    @Test
    public void testGetFillColor() {
        System.out.println("getFillColor");
        
        Color result = rectangle.getStrokeColor();
        Color expResult = Color.TRANSPARENT;
        
        assertEquals(result, expResult);
    }


    /**
     * Test of getWidth method, of class SerializableRectangle.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        
        double result = rectangle.getWidth();
        double expResult = 10;
        
        assertEquals(result, expResult, 0);
    }

    

    /**
     * Test of getHeight method, of class SerializableRectangle.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        
        double result = rectangle.getHeight();
        double expResult = 10;
        
        assertEquals(result, expResult, 0);
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
    
    
    @Test
    public void testWriteObject(){
        System.out.println("writeObject");
    }
    
    @Test
    public void testReadObject(){
        System.out.println("readObject");
    }

    /**
     * Test of toString method, of class SerializableRectangle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SerializableRectangle instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
