/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package singletons;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pasqualecaggiano
 */
public class ClonatorTest {
    private Clonator clonator;
    private byte[] byteArray;
    private Shape shape;
    
    @Before
    public void setUp() {
        clonator = Clonator.getIstance();
        shape = new Rectangle(100,100,30,30);
        
    }

    /**
     * Test of getIstance method, of class Clonator.
     */
    @Test
    public void testGetIstance() {
        System.out.println("getIstance");
        
        assertEquals(Clonator.getIstance(),clonator);
        
    }
    
    /**
     * Test of getByteCloned method, of class Clonator.
     */
    @Test
    public void testGetByteCloned() {
        System.out.println("getByteCloned");
        
        
    }

    /**
     * Test of setByteCloned method, of class Clonator.
     */
    @Test
    public void testSetByteCloned() {
        System.out.println("setByteCloned");
        
        assertEquals(clonator.getByteCloned(),null);
        
        clonator.encodeToXml(shape);
        
        
        
    }

  
    /**
     * Test of encodeToXml method, of class Clonator.
     */
    @Test
    public void testEncodeToXml() {
        System.out.println("encodeToXml");
        
    }

    /**
     * Test of decodeFromXml method, of class Clonator.
     */
    @Test
    public void testDecodeFromXml() {
        System.out.println("decodeFromXml");
        
    }
    
}
