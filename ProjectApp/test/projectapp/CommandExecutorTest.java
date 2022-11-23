/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acoon
 */
public class CommandExecutorTest {
    
    private CommandExecutor executor;
    
    @Before
    public void setUp() {
        executor = new CommandExecutor();
    }

    @Test
    public void testExecute() {
        SerializableShape shape = new SerializableLine(20,20,50,50, Color.BLACK);
        Group group = new Group();
        ScrollPane pane = new ScrollPane();
        List<SerializableShape> list = new ArrayList();
        Command comm = new DrawCommand(shape, group, pane, list);
        executor.execute(comm);
        assertEquals(comm, executor.getStack().getLast());
        
        
    }

    
}
