/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acoon
 */
public class ToFrontCommandTest {
    
    private Pane pane;
    private ToFrontCommand toFrontCommand;
    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Rectangle rectangle3;
    
    @Before
    public void setUp() {
        rectangle1 = new Rectangle(10,10,10,10);
        rectangle2 = new Rectangle(30,30,30,30);
        rectangle3 = new Rectangle(40,40,40,40);
        pane = new Pane();
        pane.getChildren().addAll(rectangle1, rectangle2, rectangle3);
        toFrontCommand = new ToFrontCommand(rectangle2, pane);
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        toFrontCommand.execute();
        assertEquals(pane.getChildren().indexOf(rectangle2), pane.getChildren().size()-1);

        
    }

    @Test
    public void testUndo() {
        System.out.println("execute");
        int oldPosition = pane.getChildren().indexOf(rectangle2);
        toFrontCommand.execute();
        assertEquals(pane.getChildren().indexOf(rectangle2), pane.getChildren().size()-1);
        toFrontCommand.undo();
        assertEquals(oldPosition, pane.getChildren().indexOf(rectangle2));


    }
    
}
