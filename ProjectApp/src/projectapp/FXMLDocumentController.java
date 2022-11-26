/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectapp;


import projectapp.command.CommandExecutor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author pasqualecaggiano
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ToggleButton lineBtn;
    @FXML
    private ToggleButton ellipseBtn;
    @FXML
    private ToggleButton rectangleBtn;
    @FXML
    private MenuItem saveBtn;
    @FXML
    private MenuItem loadBtn;
    @FXML
    private ColorPicker borderPicker;
    @FXML
    private ColorPicker interiorPicker;
    @FXML
    private ListView drawnView;
    @FXML
    private Pane pane;
    @FXML
    private AnchorPane mainPane;
    
    private DrawingEditor editor;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        editor = new DrawingEditor(mainPane,pane,null,FXCollections.observableArrayList(),new CommandExecutor(),drawnView);  
    }    
    
    @FXML
    private void setLineState(ActionEvent event) {
        editor.setLineState();
    }
    
     @FXML
    private void setRectangleState(ActionEvent event) {
        editor.setRectangleState();
    }

    @FXML
    private void setEllipseState(ActionEvent event) {
        editor.setEllipseState();
    }

     @FXML
    private void pressPane(MouseEvent event) {
        editor.setStartX(event.getX());
        editor.setStartY(event.getY());
    }
    
    @FXML
    private void releasedPane(MouseEvent event) {
        editor.executeDrawCommand(event.getX(), event.getY(),borderPicker.getValue(), interiorPicker.getValue());
    }

    @FXML
    public void saveAction(ActionEvent event) {
       editor.saveDrawing();
    }

    @FXML
    public void loadAction(ActionEvent event) {
        editor.loadDrawing();
    }
   
}
