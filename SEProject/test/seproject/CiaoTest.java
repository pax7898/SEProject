/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seproject;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acoon
 */
public class CiaoTest {
    
    public CiaoTest() {
    }
    
    @Test
    public void testAdd() {
        Ciao ciao = new Ciao();
        assertEquals(5, ciao.add(3, 2));
    }
    
    @Test
    public void testSub() {
        Ciao ciao = new Ciao();
        assertEquals(1, ciao.sub(3, 2));
    }
      public void testMol2() {
        Ciao ciao = new Ciao();
        assertEquals(1, ciao.sub(3, 2));
    }
    
}
