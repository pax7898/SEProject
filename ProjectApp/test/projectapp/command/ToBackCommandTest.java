/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp.command;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 39320
 */
public class ToBackCommandTest {
    
    private Pane pane;
    private ToBackCommand toBackCommand;
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
        toBackCommand = new ToBackCommand(rectangle1, pane);
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        toBackCommand.execute();
        assertEquals(pane.getChildren().indexOf(rectangle1), pane.getChildren().size()-3);

        
    }

    @Test
    public void testUndo() {
        System.out.println("execute");
        int oldPosition = pane.getChildren().indexOf(rectangle1);
        toBackCommand.execute();
        assertEquals(pane.getChildren().indexOf(rectangle1), pane.getChildren().size()-3);
        toBackCommand.undo();
        assertEquals(oldPosition, pane.getChildren().indexOf(rectangle1));


    }
    }
    

