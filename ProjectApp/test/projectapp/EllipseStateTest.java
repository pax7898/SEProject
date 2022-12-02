/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.tools.EllipseState;

/**
 *
 * @author acoon
 */
public class EllipseStateTest {
    
   @FXML
    Pane pane;

    private EllipseState ellipse;
    
    @Before
    public void setUp() {
        pane = new Pane();
        ellipse = new EllipseState(pane);
        
    }

    @Test
    public void testDraw() {
        System.out.println("draw");
        ellipse.draw(2.0, 2.0, 2.0, 2.0, Color.BLACK,Color.BLACK);
        assertEquals(1, pane.getChildren().size());
    }

   
    
}
