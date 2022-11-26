/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        Color result = rectangle.getFillColor();
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
        
        assertEquals(rectangle.getRectangle().getX(), rectangle.getX(), 0);
        assertEquals(rectangle.getRectangle().getY(), rectangle.getY(), 0);
        assertEquals(rectangle.getRectangle().getWidth(), rectangle.getWidth(), 0);
        assertEquals(rectangle.getRectangle().getHeight(), rectangle.getHeight(), 0);
        assertEquals(rectangle.getRectangle().getStroke(), rectangle.getStrokeColor());
        assertEquals(rectangle.getRectangle().getFill(), rectangle.getFillColor());
        
    }
    
    
    @Test
    public void testWriteObject(){
        System.out.println("writeObject");
        
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("testWriteRectangle.dat"))){
            output.writeInt(1);
            output.writeObject(rectangle);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableRectangleTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableRectangleTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //ReadObject test has been done before this one
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("testWriteLine.dat"))){
            input.readInt();
            SerializableRectangle rectangle2 = (SerializableRectangle) input.readObject();
            assertEquals(rectangle.getStrokeColor(),rectangle2.getStrokeColor());
            assertEquals(rectangle.getFillColor(),rectangle2.getFillColor());
            assertEquals(rectangle.getX(),rectangle2.getX(), 0);
            assertEquals(rectangle.getY(),rectangle2.getY(), 0);
            assertEquals(rectangle.getWidth(),rectangle2.getWidth(), 0);
            assertEquals(rectangle.getHeight(),rectangle2.getHeight(), 0);            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Test
    public void testReadObject(){
        System.out.println("readObject");
        
        //test file--> testReadRectangle.bin
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("testReadRectangle.dat"))){
            input.readInt();
            SerializableRectangle rectangle2 = (SerializableRectangle) input.readObject();
            if(!rectangle2.getClass().equals(rectangle.getClass())){
                fail("Test Read Object failed");
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Test of toString method, of class SerializableRectangle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "Rectangle (" + rectangle.getX() + "," + rectangle.getY() + ")";
        String result = rectangle.toString();
        assertEquals(result, expResult);
    }
    
}
