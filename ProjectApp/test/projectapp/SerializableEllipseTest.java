/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Math.abs;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import org.junit.Before;
import org.junit.Test;
import projectapp.shape.SerializableEllipse;
import static org.junit.Assert.*;

/**
 *
 * @author acoon
 */
public class SerializableEllipseTest {

    SerializableEllipse serializableEllipse;
    @Before
    public void setUp() {
        serializableEllipse = new SerializableEllipse(10,20,30,40, Color.BLACK, Color.TRANSPARENT);
    }

    @Test
    public void testCreateView() { 
        assertEquals(serializableEllipse.getEllipse().getCenterX(), serializableEllipse.getCenterX(), 0);
        assertEquals(serializableEllipse.getEllipse().getCenterY(), serializableEllipse.getCenterY(), 0);
        assertEquals(serializableEllipse.getEllipse().getRadiusX(), abs(serializableEllipse.getRadiusX() - 
                                                                        serializableEllipse.getCenterX()), 0);
        assertEquals(serializableEllipse.getEllipse().getRadiusY(), abs(serializableEllipse.getRadiusY() - 
                                                                        serializableEllipse.getCenterY()), 0);
        assertEquals(serializableEllipse.getEllipse().getStroke(), serializableEllipse.getStrokeColor());
        assertEquals(serializableEllipse.getEllipse().getFill(), serializableEllipse.getFillColor());
        Ellipse ellipseTest = (Ellipse) serializableEllipse.getShape();
        assertEquals(ellipseTest.getCenterX(), serializableEllipse.getEllipse().getCenterX(), 0);
        assertEquals(ellipseTest.getCenterY(), serializableEllipse.getEllipse().getCenterY(), 0);
        assertEquals(ellipseTest.getRadiusX(), serializableEllipse.getEllipse().getRadiusX(), 0);
        assertEquals(ellipseTest.getRadiusY(), serializableEllipse.getEllipse().getRadiusY(), 0);   
    }

    @Test
    public void testGetCenterX() {
        assertEquals(10, serializableEllipse.getCenterX(), 0);
    }

    @Test
    public void testGetCenterY() {
        assertEquals(20, serializableEllipse.getCenterY(), 0);
    }

    @Test
    public void testGetRadiusX() {
        assertEquals(30, serializableEllipse.getRadiusX(), 0);
    }

    @Test
    public void testGetRadiusY() {
        assertEquals(40, serializableEllipse.getRadiusY(), 0);
    }

    @Test
    public void testGetStrokeColor() {
        assertEquals(Color.BLACK, serializableEllipse.getStrokeColor());
    }

    @Test
    public void testGetFillColor() {
        assertEquals(Color.TRANSPARENT, serializableEllipse.getFillColor());
    }


    @Test
    public void testGetEllipse() {
        //already tested in TestCreateView();
    }
    
    @Test 
    public void testReadObject(){
        
        /*try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("testReadEllipse.dat"))){
            int size = in.readInt();
            assertEquals(1,size);
            //FINIRE
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableEllipseTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableEllipseTest.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    @Test
    public void testWriteObject() {
       
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("testWriteEllipse.dat"))){
            o.writeInt(1);
            o.writeObject(serializableEllipse);
        } catch (FileNotFoundException ex) {
          System.out.println("orcodio");
        } catch (IOException ex) {
            Logger.getLogger(SerializableEllipseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("testWriteEllipse.dat"))){
            int size = in.readInt();
            assertEquals(1,size);
            SerializableEllipse ellipseRead = (SerializableEllipse) in.readObject();
            System.out.println(ellipseRead);
            assertEquals(ellipseRead.getCenterX(), serializableEllipse.getCenterX(), 0);
            assertEquals(ellipseRead.getCenterY(), serializableEllipse.getCenterY(), 0);
            assertEquals(ellipseRead.getRadiusX(), serializableEllipse.getRadiusX(), 0);
            assertEquals(ellipseRead.getRadiusY(), serializableEllipse.getRadiusY(), 0);
            assertEquals(ellipseRead.getStrokeColor(), serializableEllipse.getStrokeColor());
            assertEquals(ellipseRead.getFillColor(), serializableEllipse.getFillColor());


        } catch (FileNotFoundException ex) {
           System.out.println("orcodio");
        } catch (IOException ex) {
            Logger.getLogger(SerializableEllipseTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializableEllipseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testToString() {
        String myString = "Ellipse (10.0,20.0)";
        String testString = serializableEllipse.toString();
        assertEquals(myString, testString);
    }
    
}
