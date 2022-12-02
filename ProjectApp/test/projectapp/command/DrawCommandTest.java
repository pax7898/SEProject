/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.command;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawCommandTest {
    private Command command;
    private Pane pane;
    
    
    @Before
    public void setUp() {
        pane = new Pane();
    }

    /**
     * Test of execute method, of class DrawCommand.
     */
    @Test
    public void testExecute() {
       System.out.println("execute");
      
       Line line = new Line(200,200,300,300);
       line.setStroke(Color.RED);
       command = new DrawCommand(line,pane);
       command.execute();
       assertEquals(1,pane.getChildren().size());
       assertEquals(pane.getChildren().get(0),line);
       
       Ellipse ellipse = new Ellipse(200,200,300,300);
       ellipse.setStroke(Color.RED);
       ellipse.setStroke(Color.YELLOW);
       command = new DrawCommand(ellipse,pane);
       command.execute();
       assertEquals(2,pane.getChildren().size());
       assertEquals(pane.getChildren().get(1),ellipse);
       
       
       Rectangle rectangle = new Rectangle(200,200,300,300);
       ellipse.setStroke(Color.RED);
       ellipse.setStroke(Color.YELLOW);
       command = new DrawCommand(rectangle,pane);
       command.execute();
       assertEquals(3,pane.getChildren().size());
       assertEquals(pane.getChildren().get(2),rectangle);
       
    }

    /**
     * Test of undo method, of class DrawCommand.
     */
   
    /*
    @Test
    public void testUndo() {
        System.out.println("undo");
        CommandExecutor instance = new CommandExecutor();
        instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
