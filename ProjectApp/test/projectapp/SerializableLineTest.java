/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
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
public class SerializableLineTest {
    
    public SerializableLine line;
    
    public SerializableLineTest() {
    }
    
    
    
    @Before
    public void setUp() {
        line = new SerializableLine(5,5,20,20,Color.BLACK);
    }
    
    

    /**
     * Test of createView method, of class SerializableLine.
     */
    @Test
    public void testCreateView() {
        System.out.println("createView");
        
        
        
        line.createView();
        Shape s = line.getShape();
        assertEquals(line.getShape(), s);
        
        
    }

    
    /**
     * Test of getView method, of class SerializableLine.
     */
    /*@Test
    public void testGetView() {
        System.out.println("getView");
        SerializableLine instance = null;
        Shape expResult = null;
        Shape result = instance.getView();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    
    /**
     * Test of getX1 method, of class SerializableLine.
     */
    @Test
    public void testGetX1() {
        System.out.println("getX1");
        double expResult = 5.0;
        double result = line.getX1();

        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setX1 method, of class SerializableLine.
     */
    @Test
    public void testSetX1() {
        System.out.println("setX1");
        double x1 = 22.0;
        
        line.setX1(x1);
        assertEquals(x1, line.getX1(), 0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getY1 method, of class SerializableLine.
     */
    @Test
    public void testGetY1() {
        System.out.println("getY1");
        double expResult = 5.0;
        double result = line.getY1();

        assertEquals(expResult, result, 0);
    }

    /**
     * Test of setY1 method, of class SerializableLine.
     */
    @Test
    public void testSetY1() {
        System.out.println("setY1");
        double y1 = 22.0;
        
        line.setY1(y1);
        assertEquals(y1, line.getY1(), 0);
    }

    /**
     * Test of getX2 method, of class SerializableLine.
     */
    @Test
    public void testGetX2() {
        System.out.println("getX2");
        double expResult = 20.0;
        double result = line.getX2();

        assertEquals(expResult, result, 0);
    }

    /**
     * Test of setX2 method, of class SerializableLine.
     */
    @Test
    public void testSetX2() {
        System.out.println("setX2");
        double x2 = 22.0;
        
        line.setX2(x2);
        assertEquals(x2, line.getX2(), 0);
    }

    /**
     * Test of getY2 method, of class SerializableLine.
     */
    @Test
    public void testGetY2() {
        System.out.println("getY2");
        double expResult = 20.0;
        double result = line.getY2();

        assertEquals(expResult, result, 0);
    }

    /**
     * Test of setY2 method, of class SerializableLine.
     */
    @Test
    public void testSetY2() {
        System.out.println("setY2");
        double y2 = 22.0;
        
        line.setY2(y2);
        assertEquals(y2, line.getY2(), 0);
    }

    @Test
    public void testWriteObject(){
        System.out.println("writeObject");
        
    }
    
    @Test
    public void testReadObject(){
        System.out.println("readObject");
    }
    
    
}
