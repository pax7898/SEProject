/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.singletons.SelectedShape;

/**
 *
 * @author Sabatino
 */
public class ChangeSizeCommandTest {
    
    private ChangeSizeCommand command;
    private SelectedShape selectedShape;
    private VBox vboxChangeSize;
    private Pane pane;
    
    
    public ChangeSizeCommandTest() {
    }

    @Before
    public void setUp() {
        selectedShape = SelectedShape.getIstance();
        vboxChangeSize = new VBox();
        pane = new Pane();
    }
    

    /**
     * Test of execute method, of class ChangeSizeCommand.
     */
    @Test
    public void testExecuteLine() {
        System.out.println("execute Line");
        
        Line line = new Line(10,10,30,30);
        pane.getChildren().add(line);
        selectedShape.setShape(line);
        //(SelectedShape selectedShape,double changeSizeX, double changeSizeY, Double beforeX,
        //* Double beforeY, VBox vboxChangeSize)
        command = new ChangeSizeCommand(selectedShape,2.0,2.0,1.0,1.0,vboxChangeSize);
        command.execute();
        assertEquals(line.getScaleX(), 2.0, 0);
        assertEquals(line.getScaleY(), 2.0, 0);

    }

    /**
     * Test of undo method, of class ChangeSizeCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        
    }
    
}
