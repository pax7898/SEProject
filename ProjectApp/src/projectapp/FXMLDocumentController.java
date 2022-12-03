package projectapp;


import java.io.File;
import projectapp.command.CommandExecutor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
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
    
    private ToggleGroup toggles;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        editor = new DrawingEditor(pane,new CommandExecutor(),null);  
        toggles = new ToggleGroup();
        toggles.getToggles().addAll(lineBtn,recBtn,elBtn,selBtn,moveBtn);
        
    }    
    
    @FXML
    private void setSelectionTool(ActionEvent event) {
        editor.setSelectionTool();
        toggles.getSelectedToggle().setSelected(false);
        selBtn.selectedProperty().set(true);
    }

    @FXML
    private void setMoveTool(ActionEvent event) {
        editor.setMoveTool();
        toggles.getSelectedToggle().setSelected(false);
        moveBtn.selectedProperty().set(true);
    }
    
    @FXML
    private void setResizeTool(ActionEvent event) {
        editor.setResizeTool();
        toggles.getSelectedToggle().setSelected(false);
        resizeBtn.selectedProperty().set(true);
    }
    @FXML
    private void setLineTool(ActionEvent event) {
        editor.setLineTool();
        toggles.getSelectedToggle().setSelected(false);
        lineBtn.selectedProperty().set(true);
    }
    
     @FXML
    private void setRectangleTool(ActionEvent event) {
        editor.setRectangleTool();
        toggles.getSelectedToggle().setSelected(false);
        recBtn.selectedProperty().set(true);
         
    }

    @FXML
    private void setEllipseTool(ActionEvent event) {
        editor.setEllipseTool();
        toggles.getSelectedToggle().setSelected(false);
        elBtn.selectedProperty().set(true);
        
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
    private void undo(ActionEvent event) {
        editor.undo();
    }

}
