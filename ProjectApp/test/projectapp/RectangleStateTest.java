package projectapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.shape.SerializableShape;
import projectapp.state.RectangleState;

/**
 *
 * @author acoon
 */
public class RectangleStateTest {
    
    @FXML
    Pane pane;

    private RectangleState rectangle;
    
    @Before
    public void setUp() {
        pane = new Pane();
        rectangle = new RectangleState(pane);
        
    }

    @Test
    public void testDraw() {
        System.out.println("draw");
        rectangle.draw(2.0, 2.0, 2.0, 2.0, Color.BLACK,Color.BLACK);
        assertEquals(1, pane.getChildren().size());
    }

    
}
