/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
    private Label actionLable;
    @FXML
    private MenuItem saveBtn;
    @FXML
    private MenuItem loadBtn;
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
    private ListView drawnView;
    @FXML
    private Pane pane;
    
    private EditorState currentState;
    
    private ObservableList<SerializableShape> listItems;
    
    private CommandExecutor executor;
    
    
    
    
    double startX;
    double startY;
    
   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        listItems = FXCollections.observableArrayList();
        
        drawnView.setItems(getStringList());
       
 
        executor = new CommandExecutor();
  
        
    }    
    
    public ObservableList<String> getStringList(){
        ObservableList<String> l = FXCollections.observableArrayList();
        for(int i=0;i<listItems.size();i++){
            String temp = listItems.get(i).getShape().toString();
            l.add(temp);
        }
        return l;
    }
    
    @FXML
    private void setLineState(ActionEvent event) {
        currentState = new LineState(pane,listItems);
    }

    @FXML
    private void scrollClick(MouseEvent event) {
        //executor.execute(new DrawCommand(currentState,event.getX(),event.getY(),event.getX()+10.0,event.getY()+50.0,borderPicker.getValue(),interiorPicker.getValue()));
    }

    @FXML
    private void releasedPane(MouseEvent event) {
        executor.execute(new DrawCommand(currentState,startX,startY,event.getX(),event.getY(),borderPicker.getValue(),interiorPicker.getValue()));
        drawnView.setItems(getStringList());
    }

    @FXML
    private void clickPene(MouseEvent event) {
        startX = event.getX();
        startY = event.getY();
    }

    @FXML
    private void setRectangleState(ActionEvent event) {
        currentState = new RectangleState(pane, listItems);
    }

    @FXML
    private void setEllipseState(ActionEvent event) {
        currentState = new EllipseState(pane, listItems);
    }

}
