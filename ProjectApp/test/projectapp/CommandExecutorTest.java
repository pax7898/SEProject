/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectapp;

import projectapp.command.DrawCommand;
import projectapp.command.CommandExecutor;
import projectapp.command.Command;
import projectapp.state.EditorState;
import projectapp.state.LineState;
import projectapp.shape.SerializableLine;
import projectapp.shape.SerializableShape;
import javafx.fxml.FXML;
import java.util.NoSuchElementException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acoon
 */
public class CommandExecutorTest {
    
    private CommandExecutor executor;
    
    @FXML
    Pane pane;
    
    @Before
    public void setUp() {
        executor = new CommandExecutor();
    }

    @Test(expected=NoSuchElementException.class)
    public void testExecute() {
        SerializableShape shape = new SerializableLine(20,20,50,50,Color.BLACK,Color.WHITE);
        ObservableList<SerializableShape> list = FXCollections.observableArrayList();
        EditorState state = new LineState(pane, list);
        assertEquals(null, executor.getStack().getLast());
        Command comm = new DrawCommand(state,20,20,50,50,Color.BLACK, Color.BLACK);
        executor.execute(comm);
        assertEquals(comm, executor.getStack().getLast());     
    }

    
}
