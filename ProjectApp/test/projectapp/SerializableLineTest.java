/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sabatino
 */
public class SerializableLineTest {
    
    private SerializableLine line;
    
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
        Line myLine = line.getLine();
        assertEquals(myLine, line.getShape()); 
    }
    
    
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
        File file = new File("prova.dat");

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))){
            output.writeObject(line);
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))){
            
            SerializableLine line2 = (SerializableLine) input.readObject();
            System.out.println(line2.getX1());
            
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
    }
    
    
}
