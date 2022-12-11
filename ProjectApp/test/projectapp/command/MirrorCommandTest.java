/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
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

/**
 *
 * @author acoon
 */
public class MirrorCommandTest {
    private Command command;
    private Pane pane;
    private Line line;
    private Ellipse ellipse;
    private Rectangle rectangle;
    double oldScaleX;
    
    
    @Before
    public void setUp() {
        line = new Line(20,20,30,30);
        ellipse = new Ellipse(20,20,30,30);
        rectangle = new Rectangle(20,20,30,30);
        pane = new Pane();
    }

    @Test
    public void testExecuteLine() {
       System.out.println("executeLine");
       pane.getChildren().add(line);
       command = new MirrorCommand(line);
       oldScaleX = line.getScaleX();
       command.execute();
       assertEquals(-oldScaleX,pane.getChildren().get(0).getScaleX(),0);
    }
    
    @Test
    public void testExecuteRectangle() {
       System.out.println("executeRectagle");
       pane.getChildren().add(line);
       command = new MirrorCommand(line);
       oldScaleX = line.getScaleX();
       command.execute();
       assertEquals(-oldScaleX,pane.getChildren().get(0).getScaleX(),0);
    }
    
    @Test
    public void testExecuteEllipse() {
       System.out.println("executeLine");
       pane.getChildren().add(ellipse);
       command = new MirrorCommand(ellipse);
       oldScaleX = ellipse.getScaleX();
       command.execute();
       assertEquals(-oldScaleX,pane.getChildren().get(0).getScaleX(),0);
    }

    @Test
    public void testUndoRectangle() {
        System.out.println("undoRectangle");
        pane.getChildren().add(rectangle);
        command = new MirrorCommand(rectangle);
        oldScaleX = rectangle.getScaleX();
        command.execute();
        command.undo();
        assertEquals(oldScaleX,pane.getChildren().get(0).getScaleX(),0);
    }
    
    @Test
    public void testUndoLine() {
        System.out.println("undoLine");
        pane.getChildren().add(line);
        command = new MirrorCommand(line);
        oldScaleX = line.getScaleX();
        command.execute();
        command.undo();
        assertEquals(oldScaleX,pane.getChildren().get(0).getScaleX(),0);
    }
    
    @Test
    public void testUndoEllipse() {
        System.out.println("undoEllipse");
        pane.getChildren().add(ellipse);
        command = new MirrorCommand(ellipse);
        oldScaleX = ellipse.getScaleX();
        command.execute();
        command.undo();
        assertEquals(oldScaleX,pane.getChildren().get(0).getScaleX(),0);
    }
    
}
