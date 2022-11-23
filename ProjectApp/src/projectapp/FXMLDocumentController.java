/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private Label shapeLabel;
    @FXML
    private Label actionLable;
    @FXML
    private MenuItem saveBtn;
    @FXML
    private MenuItem loadBtn;
    @FXML
    private Label drawnLabel;
    @FXML
    private Label colorLabel;
    @FXML
    private ColorPicker borderPicker;
    @FXML
    private ColorPicker interiorPicker;
    @FXML
    private Label borderLabel;
    @FXML
    private Label interiorLabel;
    @FXML
    private ListView<SerializableShape> drawnList;
    
    private EditorState currentState;
    
    private Group shapeGroup;
    
    private ObservableList<SerializableShape> listItems;
    
    private CommandExecutor executor;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //drawnList= new ListView<SerializableShape>();
        listItems = FXCollections.observableArrayList();
        drawnList.setItems(listItems);
        executor = new CommandExecutor();
   
    }    

    @FXML
    private void setLineState(ActionEvent event) {
        currentState = new LineState(shapeGroup,scrollPane,listItems);
    }

    @FXML
    private void scrollClick(MouseEvent event) {
        executor.execute(new DrawCommand(currentState,event.getX(),event.getY(),event.getX()+10.0,event.getY()+50.0,borderPicker.getValue(),interiorPicker.getValue()));
    }

}
