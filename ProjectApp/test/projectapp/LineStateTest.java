/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import java.util.List;
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
    
    public LineStateTest() {
    }
    private LineState line;
    private ObservableList<SerializableShape> list;
    
    @Before
    public void setUp() {
        pane = new Pane();
        list = FXCollections.observableArrayList();
        line = new LineState(pane, list);
        
    }

    @Test
    public void testDraw_5args() {
        line.draw(2.0, 2.0, 2.0, 2.0, Color.BLACK);
        assertEquals(1, list.size());  
        line.draw(2.0, 2.0, 2.0, 2.0, Color.BLACK);
        line.draw(2.0, 2.0, 2.0, 2.0, Color.BLACK);
        assertEquals(3, pane.getChildren().size());
        Node node = pane.getChildren().get(0);
        assertTrue(pane.getChildren().remove(node));
        list.remove(0);
        assertEquals(2, list.size()); 
        assertEquals(2, pane.getChildren().size());
    }

   
    
}
