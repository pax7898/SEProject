/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectapp.shape.SerializableLine;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import org.junit.Before;
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
        line = new SerializableLine(5,5,20,20,Color.BLACK,Color.WHITE);
    }
    
    /**
     * Test of createView method, of class SerializableLine.
     */
    @Test
    public void testCreateView() {
        assertEquals(line.getLine().getStartX(), line.getX1(), 0);
        assertEquals(line.getLine().getStartY(), line.getY1(), 0);
        assertEquals(line.getLine().getEndX(), line.getX2(), 0);
        assertEquals(line.getLine().getEndY(), line.getY2(), 0);
        assertEquals(line.getLine().getStroke(), line.getColor());
        
        Line lineTest = (Line) line.getShape();
        assertEquals(lineTest.getStartX(), line.getLine().getStartX(), 0);
        assertEquals(lineTest.getStartY(), line.getLine().getStartY(), 0);
        assertEquals(lineTest.getEndX(), line.getLine().getEndX(), 0);
        assertEquals(lineTest.getEndY(), line.getLine().getEndY(), 0);
        assertEquals(lineTest.getStroke(), line.getLine().getStroke());

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
     * Test of getY2 method, of class SerializableLine.
     */
    @Test
    public void testGetY2() {
        System.out.println("getY2");
        double expResult = 20.0;
        double result = line.getY2();

        assertEquals(expResult, result, 0);
    }


    
   @Test
   public void testGetColor(){
       System.out.println("getColor");
       Color expResult = Color.BLACK;
       Color result = line.getColor();
       
       assertEquals(result, expResult);
   }
   
   @Test
   public void testGetLine(){
       //already tested in testCreateView();
       
   }
    
    @Test
    public void testWriteObject(){
        System.out.println("writeObject");
        
        File file = new File("testWriteLine.dat");
        
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))){
            output.writeInt(1);
            output.writeObject(line);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //ReadObject test has been done before this one
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))){
            input.readInt();
            SerializableLine line2 = (SerializableLine) input.readObject();
            assertEquals(line.getColor(),line2.getColor());
            assertEquals(line.getX1(),line2.getX1(), 0);
            assertEquals(line.getX2(),line2.getX2(), 0);
            assertEquals(line.getY1(),line2.getY1(), 0);
            assertEquals(line.getY2(),line2.getY2(), 0);            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializableLineTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        file.delete();
        
    }
    
    @Test
    public void testReadObject(){
       //Already tested in testWriteObject()
    }
    
    @Test
    public void testToString(){
        System.out.println("toString");
        
        String expResult = "Line (" + line.getX1() + "," + line.getY1() + ")";
        String result = line.toString();
        assertEquals(result,expResult);
    }
    
    
}
