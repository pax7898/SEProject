/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

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
public class CommandExecutorTest {
    
    public CommandExecutorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        CommandExecutor commExec = new CommandExecutor();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testExecute() {
        Command comm = new Command();
        commExec.execute()
    }

    @Test
    public void testUndo() {
        System.out.println("undo");
        CommandExecutor instance = new CommandExecutor();
        instance.undo();
        fail("The test case is a prototype.");
    }
    
}
