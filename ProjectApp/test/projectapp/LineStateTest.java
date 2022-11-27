/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import projectapp.state.LineState;
import projectapp.shape.SerializableShape;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acoon
 */
public class LineStateTest {
    
    @FXML
    Pane pane;

    private LineState line;
    private ObservableList<SerializableShape> list;
    
    @Before
    public void setUp() {
        pane = new Pane();
        list = FXCollections.observableArrayList();
        line = new LineState(pane, list);
        
    }

    @Test
    public void testDraw() {
        System.out.println("draw");
        line.draw(2.0, 2.0, 2.0, 2.0, Color.BLACK,Color.BLACK);
        assertEquals(1, list.size());  
        assertEquals(1, pane.getChildren().size());
        Node node = (Node) list.remove(0).getShape();
        assertTrue(pane.getChildren().contains(node));        
    }

   
    
}
