/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp.tools;

import javafx.embed.swing.JFXPanel;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapp.singletons.SelectedShape;
import projectapp.command.ChangeBorderColorCommand;
import projectapp.command.ChangeInteriorColorCommand;
import projectapp.command.Command;
import projectapp.command.CommandExecutor;
import projectapp.command.DeleteCommand;
import projectapp.command.ToFrontCommand;
import projectapp.singletons.Clonator;

/**
 *
 * @author pasqualecaggiano
 */
public class SelectionToolTest {
    private SelectionTool tool;
    private SelectedShape selectedShape;
    private Pane pane;
    private CommandExecutor executor;
    private Shape shape;
    private Shape shape1;
    private ContextMenu menu;
    private VBox vboxChangeSize;
    private JFXPanel panel;
    
    public SelectionToolTest() {
    }
    
    @Before
    public void setUp() {
        panel = new JFXPanel();
        shape = new Rectangle(20,20,30,30);
        shape1 = new Rectangle(40,40,40,40);
        shape.setFill(Color.BLUE);
        shape.setStroke(Color.BLUE);
        pane = new Pane();
        pane.getChildren().addAll(shape,shape1);
        selectedShape = SelectedShape.getIstance();
        selectedShape.setShape(shape); 
        menu = new ContextMenu();
        menu.getItems().add(new MenuItem("delete"));
        menu.getItems().add(new MenuItem("copy"));
        menu.getItems().add(new MenuItem("cut"));
        menu.getItems().add(new MenuItem("paste"));
        menu.getItems().add(new MenuItem("move"));
        vboxChangeSize = new VBox();
        HBox hboxX = new HBox();
        hboxX.getChildren().add(new Label());
        hboxX.getChildren().add(new TextField("2.0"));
        HBox hboxY = new HBox();
        hboxY.getChildren().add(new Label());
        hboxY.getChildren().add(new TextField("2.0"));
        vboxChangeSize.getChildren().add(hboxX);
        vboxChangeSize.getChildren().add(hboxY);

        executor = new CommandExecutor();
        tool = new SelectionTool(pane,selectedShape,executor,menu,vboxChangeSize);
        
    }

    /**
     * Test of getSelectedShape method, of class SelectionTool.
     */
    @Test
    public void testGetSelectedShape() {
        System.out.println("getSelectedShape");
        
        assertEquals(selectedShape,tool.getSelectedShape());
        
    }

    /**
     * Test of onMousePressed method, of class SelectionTool.
     */
    @Test
    public void testOnMousePressed() {
        System.out.println("onMousePressed");
        MouseEvent event = new MouseEvent(null, shape, new EventType(), 100, 150, 0, 0, MouseButton.PRIMARY, 0, false, false, false, false, false, false, false, false, false, false, null);
        SelectionTool test = new SelectionTool(pane, selectedShape, executor, menu, vboxChangeSize);
        test.onMousePressed(event, Color.DARKVIOLET, Color.SILVER);
        assertEquals(shape.getStyle(),"-fx-stroke-dash-array:5px");
    }

    /**
     * Test of changeBorderColor method, of class SelectionTool.
     */
    @Test
    public void testChangeBorderColor() {
        System.out.println("changeBorderColor");
        Command border= new ChangeBorderColorCommand(shape, Color.RED);
        tool.changeBorderColor(Color.RED);
        assertEquals(shape.getStroke(),Color.RED);
        assertEquals(border.getClass(),executor.getStack().getLast().getClass());   
    }

    /**
     * Test of changeInteriorColor method, of class SelectionTool.
     */
    @Test
    public void testChangeInteriorColor() {
        System.out.println("changeInteriorColor");
        Command interior= new ChangeInteriorColorCommand(shape, Color.RED);
        tool.changeInteriorColor(Color.RED);
        assertEquals(shape.getFill(),Color.RED);
        assertEquals(interior.getClass(),executor.getStack().getLast().getClass());
        
    }

    /**
     * Test of deleteShape method, of class SelectionTool.
     */
    @Test
    public void testDeleteShape() {
        System.out.println("deleteShape");
        DeleteCommand command = new DeleteCommand(shape,pane);
        tool.deleteShape();
        assertTrue(!pane.getChildren().contains(shape));
        assertEquals(command.getClass(),executor.getStack().getLast().getClass());
    }
    
    /**
     * Test of cut method, of class SelectionTool.
     */
    @Test
    public void testCut() {
        System.out.println("cut");  
        selectedShape.setShape(null);
        tool.cut();
        assertEquals(Clonator.getIstance().getByteCloned(), null);       
        selectedShape.setShape(shape);
        tool.cut();
        assertFalse(executor.getStack().isEmpty());
        assertFalse(pane.getChildren().contains(shape));
        Shape shape2 = (Shape)Clonator.getIstance().decodeFromXml();
        assertEquals(shape2.toString(), shape.toString());
    }
    
    /**
     * Test of copy method, of class SelectionTool.
     */
    @Test
    public void testCopy() {
        System.out.println("copy");
        selectedShape.setShape(null);
        tool.copy();
        assertEquals(Clonator.getIstance().getByteCloned(), null);
        selectedShape.setShape(shape);
        tool.copy();
        assertFalse(executor.getStack().isEmpty());
        Shape shape2 = (Shape)Clonator.getIstance().decodeFromXml();
        assertEquals(shape2.toString(), shape.toString());
    }
    
    /**
     * Test of cut method, of class SelectionTool.
     */
    @Test
    public void testPaste() {
        System.out.println("paste");
        tool.copy();
        int initialLength = pane.getChildren().size();
        Point2D point = new Point2D(0.0,0.0);
        tool.paste(point);
        assertEquals(initialLength+1, pane.getChildren().size());
        assertEquals(shape.toString(), pane.getChildren().get(0).toString());
    }
    
    /**
     * Test of toFront method, of class SelectionTool.
     */
    @Test
    public void testToFront() {
        System.out.println("toFront");
        ToFrontCommand toFrontCommand = new ToFrontCommand(shape, pane);
        tool.toFront();
        assertEquals(pane.getChildren().indexOf(shape), pane.getChildren().size()-1);
 
    }
    
    /**
     * Test of changeSizeBar method, of class SelectionTool.
     */
    @Test
    public void testChangeSizeBar() {
        System.out.println("changeSizeBar");
        
        tool.changeSizeBar();
        assertTrue(vboxChangeSize.isVisible());
        
    }
    
    /**
     * Test of changeSize method, of class SelectionTool.
     */
    @Test
    public void testChangeSize() {
        System.out.println("changeSize");
        
        double changeX = selectedShape.getShape().getScaleX();
        double changeY = selectedShape.getShape().getScaleY();
        tool.changeSize();
        assertEquals(selectedShape.getShape().getScaleX(),changeX+1.0,0);
        assertEquals(selectedShape.getShape().getScaleY(),changeX+1.0,0);

        
    }
   
}
