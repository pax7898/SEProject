package projectapp;


import java.io.File;
import projectapp.command.CommandExecutor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;


/**
 *
 * @author pasqualecaggiano
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private ColorPicker borderPicker;
    @FXML
    private ColorPicker interiorPicker;
    @FXML
    private Pane pane;
    @FXML
    private AnchorPane mainPane;
    
    private DrawingEditor editor;
    @FXML
    private ToggleButton lineBtn;
    @FXML
    private ToggleButton recBtn;
    @FXML
    private ToggleButton elBtn;
    @FXML
    private ToggleButton selBtn;
    @FXML
    private ToggleButton moveBtn;
    @FXML
    private ToggleButton resizeBtn;
    @FXML
    private ToggleButton undoBtn;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        editor = new DrawingEditor(pane,new CommandExecutor(),null);  
        
    }    
    
    @FXML
    private void setSelectionTool(ActionEvent event) {
        editor.setSelectionTool();
    }

    @FXML
    private void setMoveTool(ActionEvent event) {
        editor.setMoveTool();
    }
    
     @FXML
    private void setResizeTool(ActionEvent event) {
        editor.setResizeTool();
    }
    @FXML
    private void setLineTool(ActionEvent event) {
        editor.setLineTool();
        recBtn.selectedProperty().set(false);
        elBtn.selectedProperty().set(false);
         
    }
    
     @FXML
    private void setRectangleTool(ActionEvent event) {
         editor.setRectangleTool();
         elBtn.selectedProperty().set(false);
         lineBtn.selectedProperty().set(false);
         
    }

    @FXML
    private void setEllipseTool(ActionEvent event) {
        editor.setEllipseTool();
        recBtn.selectedProperty().set(false);
        lineBtn.selectedProperty().set(false);
        
    }

     @FXML
    private void onMousePressed(MouseEvent event) {
        editor.onMousePressed(event, borderPicker.getValue(), interiorPicker.getValue());
    }
    
     @FXML
    private void onMouseDragged(MouseEvent event) {
        editor.onMouseDragged(event);
    }
       
    @FXML
    private void onMouseReleased(MouseEvent event) {
       
        editor.onMouseReleased(event);
         
    }

    @FXML
    public void saveAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Xml files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        
        //Show save file dialog
        File file = fileChooser.showSaveDialog(mainPane.getScene().getWindow());
        editor.saveDrawing(file);
    }

    @FXML
    public void loadAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Xml files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow());
        
        editor.loadDrawing(file);       
    }

    


    @FXML
    private void borderColorChange(ActionEvent event) {
        editor.changeBorderColor(borderPicker.getValue());
    }

    @FXML
    private void changeInteriorColor(ActionEvent event) {
        editor.changeInteriorColor(interiorPicker.getValue());
    }

    @FXML
    private void deleteShape(ActionEvent event) {
        editor.deleteShape();
    }

    @FXML
    private void copyShape(ActionEvent event) {
        editor.copyShape();
    }

    @FXML
    private void cutShape(ActionEvent event) {
        editor.cutShape();
    }

    @FXML
    private void pasteShape(ActionEvent event) {
        editor.pasteShape();
    }

    @FXML
    private void undo(ActionEvent event) {
        editor.undo();
    }
       
}
