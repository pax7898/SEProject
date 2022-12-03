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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 39320
 */
public class ChangeInteriorColorCommandTest {
    private ChangeInteriorColorCommand command;
    private Pane pane;
    
   
    
    @Before
    public void setUp() {
        Pane pane = new Pane();
    }
    
   
    /**
     * Test of execute method, of class ChangeInteriorColorCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Rectangle rectangle=new Rectangle(200,200,300,300);
        rectangle.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(rectangle,Color.BLUE);
        command.execute();
        assertEquals(rectangle.getFill(),Color.BLUE);
        Line line=new Line(200,200,300,300);
        line.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(line,Color.BLUE);
        command.execute();
        assertEquals(line.getFill(),Color.BLUE);
        Ellipse ellipse=new Ellipse(200,200,300,300);
        ellipse.setFill(Color.RED);
        command = new ChangeInteriorColorCommand(ellipse,Color.BLUE);
        command.execute();
        assertEquals(ellipse.getFill(),Color.BLUE);
    }
    
}
