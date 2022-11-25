/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectapp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

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
    @FXML
    private AnchorPane mainPane;
    
   
  
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

    @FXML
    private void saveAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Bin files (*.dat)", "*.dat");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(mainPane.getScene().getWindow());
        
        try {
            
            ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            objectOut.writeInt(listItems.size());
            //scrivo su file un oggetto
            for (SerializableShape a : listItems) 
                { 
                    System.out.print(a);
                    objectOut.writeObject(a);
                }
            
            //chiudo lo stream
            objectOut.close();
                
        } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void loadAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Bin files (*.dat)", "*.dat");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow());
        
        try {
            
            ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        
            //scrivo su file un oggetto
            int size = objectIn.readInt();
            for (int i=0;i<size;i++){
                SerializableShape a = (SerializableShape) objectIn.readObject();
                listItems.add(a);
                pane.getChildren().add(a.getShape());
                System.out.print(a);
            }
            
            
            //chiudo lo stream
            objectIn.close();
                
        } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        drawnView.setItems(getStringList());
    }
    
}
