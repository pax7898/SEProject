/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.tools.RectangleTool;

/**
 *
 * @author 39320
 */
public class ChangeBorderColorCommandTest {
    private ChangeBorderColorCommand command;
    private Pane pane;
  
    
    @Before
    public void setUp() {
        Pane pane = new Pane();
        
    }
    
 
    /**
     * Test of execute method, of class ChangeBorderColorCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Rectangle rectangle=new Rectangle(200,200,300,300);
        rectangle.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(rectangle,Color.BLUE);
        command.execute();
        assertEquals(rectangle.getStroke(),Color.BLUE);
        Line line=new Line(200,200,300,300);
        line.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(line,Color.BLUE);
        command.execute();
        assertEquals(line.getStroke(),Color.BLUE);
        Ellipse ellipse=new Ellipse(200,200,300,300);
        ellipse.setStroke(Color.RED);
        command = new ChangeBorderColorCommand(ellipse,Color.BLUE);
        command.execute();
        assertEquals(ellipse.getStroke(),Color.BLUE);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of undo method, of class ChangeBorderColorCommand.
     
    @Test
    /*public void testUndo() {
        System.out.println("undo");
        ChangeBorderColorCommand instance = null;
        instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
