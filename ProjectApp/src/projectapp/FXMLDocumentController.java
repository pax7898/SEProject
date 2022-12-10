package projectapp;


import projectapp.singletons.DrawingEditor;
import java.io.File;
import projectapp.command.CommandExecutor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import projectapp.singletons.ZoomPane;


/**
* This class is the Controller of the MVC architecture:
* every action executed on the interface will be captured here.
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
    @FXML
    private ToggleButton lineBtn;
    @FXML
    private ToggleButton recBtn;
    @FXML
    private ToggleButton elBtn;
    @FXML
    private ToggleButton selBtn;
    @FXML
    private ContextMenu menu;
    @FXML
    private VBox vboxChangeSize;
    @FXML
    private ScrollPane scrollPane;
    
    private ZoomPane zoomPane;
    @FXML
    private ToggleButton gridBtn;
    
    private ToggleGroup radioGroup;
    @FXML
    private RadioMenuItem radio1x;
    @FXML
    private RadioMenuItem radio2x;
    @FXML
    private RadioMenuItem radio3x;
    
    private ToggleGroup toggles;
    
    private DrawingEditor editor;
    
    private Point2D contextMenuPoint;
    
    private static final double DRAWING_PANE_WIDTH = 12000;
    private static final double DRAWING_PANE_HEIGTH = 12000;
    @FXML
    private Button UndoBtn;
    @FXML
    private Button changeSzBtn;
    Group tmpGroup;
    /**
     * This method executes all the initial operations when the program starts.
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        editor = DrawingEditor.getIstance(pane,new CommandExecutor(),null, menu, vboxChangeSize);
        
        toggles = new ToggleGroup();
        radioGroup = new ToggleGroup();
        
        toggles.getToggles().addAll(lineBtn,recBtn,elBtn,selBtn);
        radioGroup.getToggles().addAll(radio1x, radio2x, radio3x);
        radioGroup.selectToggle(radio1x);
        menu.getItems().forEach(item -> {
            item.setDisable(true);
        });
        
        editor.setLineTool();
        lineBtn.setSelected(true); 
        vboxChangeSize.visibleProperty().set(false);
        
        zoomPane = ZoomPane.getIstance();
        zoomPane.getChildren().add(pane);
        scrollPane.setContent(zoomPane);
        scrollPane.setHmax(DRAWING_PANE_WIDTH);
        scrollPane.setVmax(DRAWING_PANE_HEIGTH);
        scrollPane.setHvalue(DRAWING_PANE_WIDTH/2);
        scrollPane.setVvalue(DRAWING_PANE_HEIGTH/2);
        
    }    
    
    /**
     * This method will be activated when the Selection Button is pressed. There,
     * all the operations to implement the select features will be executed.
     * 
     * @param event 
     */
    @FXML
    private void setSelectionTool(ActionEvent event) {
        editor.setSelectionTool();
        if (toggles.getSelectedToggle()!=null){
        toggles.getSelectedToggle().setSelected(false);
        }
        selBtn.selectedProperty().set(true);
    }
    
    /**
     * This method will be activated when the Line Button is pressed. There,
     * all the operations to draw a line will be executed.
     * 
     * @param event 
     */
    @FXML
    private void setLineTool(ActionEvent event) {
        editor.setLineTool();
        if (toggles.getSelectedToggle()!=null){
        toggles.getSelectedToggle().setSelected(false);
        }
        lineBtn.selectedProperty().set(true);
    }
    
    /**
    * This method will be activated when the Rectangle Button is pressed. There,
    * all the operations to draw a rectangle will be executed.
    * 
    * @param event 
    */
     @FXML
    private void setRectangleTool(ActionEvent event) {
        editor.setRectangleTool();
        if (toggles.getSelectedToggle()!=null){
        toggles.getSelectedToggle().setSelected(false);
        }
        recBtn.selectedProperty().set(true);
         
    }
    
    /**
     * This method will be activated when the Ellipse Button is pressed. There,
     * all the operations to draw a ellipse will be executed.
     * 
     * @param event 
     */
    @FXML
    private void setEllipseTool(ActionEvent event) {
        editor.setEllipseTool();
        if (toggles.getSelectedToggle() != null){
        toggles.getSelectedToggle().setSelected(false);
        }
        elBtn.selectedProperty().set(true);
        
    }

    /**
     * This method will be activated when the user presses the mouse on the pane. 
     * According to the current tool of the drawing editor this action will be executed. 
     * in a different way.
     * 
     * @param event 
     */
     @FXML
    private void onMousePressed(MouseEvent event) {
        editor.onMousePressed(event, borderPicker.getValue(), interiorPicker.getValue());
    }
    
    /**
    * This method will be activated when the user dragges the mouse on the pane. 
    * According to the current tool of the drawing editor this action will be executed. 
    * in a different way.
    * 
    * @param event 
    */
     @FXML
    private void onMouseDragged(MouseEvent event) {
        editor.onMouseDragged(event);
    }
       
    /**
    * This method will be activated when the user releases the mouse on the pane. 
    * According to the current tool of the drawing editor this action will be executed
    * in a different way.
    * 
    * @param event 
    */
    @FXML
    private void onMouseReleased(MouseEvent event) {
       
        editor.onMouseReleased(event);
         
    }
    
    /**
    * This method will be activated when the user chooses a color from the borderPicker. 
    * If a shape is selected, all the operations to changes his border colors will be executed.
    * 
    * @param event 
    */
    @FXML
    private void borderColorChange(ActionEvent event) {
        editor.changeBorderColor(borderPicker.getValue());
    }
    
    /**
    * This method will be activated when the user chooses a color from the interiorPicker. 
    * If a shape is selected, all the operations to changes his interior colors will be executed.
    * 
    * @param event 
    */
    @FXML
    private void changeInteriorColor(ActionEvent event) {
        editor.changeInteriorColor(interiorPicker.getValue());
    }

    /**
    * This method will be activated when the user presses the delete menu item from the context menu. 
    * If a shape is selected, all the operations to changes his interior colors will be executed.
    * 
    * @param event 
    */
    @FXML
    private void deleteShape(ActionEvent event) {
        editor.deleteShape();
    }
    
    
    /**
    * This method will be activated when the user presses the copy menu item from the context menu. 
    * If a shape is selected, all the operations to copy it will be executed.
    * 
    * @param event 
    */
    @FXML
    private void copyShape(ActionEvent event) {
        editor.copyShape();
    }
    
    /**
    * This method will be activated when the user presses the paste menu item from the context menu. 
    * If a shape is selected, all the operations to paste it will be executed.
    * 
    * @param event 
    */
    @FXML
    private void pasteShape(ActionEvent event) {
        editor.pasteShape(contextMenuPoint);
    }
    
    /**
    * This method will be activated when the user presses the cut menu item from the context menu. 
    * If a shape is selected, all the operations to cut it will be executed.
    * 
    * @param event 
    */
    @FXML
    private void cutShape(ActionEvent event) {
        editor.cutShape();
    }
    
    /**
    * This method will be activated when the user selects the save item from the menu. 
    * A save dialog will allows the user to choose a file system location for the file.
    * All the operation to save the current drawing on a XML file in that location will be executed
    * 
    * @param event 
    */
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
    
    /**
    * This method will be activated when the user selects the load item from the menu. 
    * An open dialog will allows the user to choose a file in the user file system.
    * All the operation to load a drawing from a XML file will be executed.
    * 
    * @param event 
    */
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

    /**
    * This method will be activated when the user selects open the context menu.
    * Only if the SelecitonTool is the current tool the menu items will be enabled.
    * 
    * @param event 
    */
    @FXML
    private void onMenuRequested(ContextMenuEvent event) {
        contextMenuPoint = new Point2D(event.getSceneX(),event.getSceneY());
    }

    @FXML
    private void undo(ActionEvent event) {
        editor.undo();
    }
    
    @FXML
    private void setToFrontTool(ActionEvent event) {
        editor.toFront();
    }

    @FXML
    private void setToBackTool(ActionEvent event) {
        editor.toBack();
    }

    @FXML
    private void changeSizeBar(ActionEvent event) {
        editor.changeSizeBar();
    }

    @FXML
    private void changeSize(ActionEvent event) {
        try{
            HBox hboxX = (HBox) vboxChangeSize.getChildren().get(0);
            HBox hboxY = (HBox) vboxChangeSize.getChildren().get(1);
            TextField textX = (TextField) hboxX.getChildren().get(1);
            TextField textY = (TextField) hboxY.getChildren().get(1);
            double x = Double.parseDouble(textX.getText());
            double y = Double.parseDouble(textY.getText());
            editor.changeSize();
        }catch(Exception e){
        }
    }

    /**
     * This method will be called when the user press on the grid button on the UI
     * When the user clicks on the grid button, if this is not active, then it is 
     * shown on the drawingeditor otherwise it is removed. Moreover, through a 
     * menu the user can choose the size of the grid.
     */
    @FXML
    private void setGrid() {
        if(gridBtn.selectedProperty().get()){
            RadioMenuItem toggle = (RadioMenuItem) radioGroup.getSelectedToggle();
            tmpGroup = editor.addGrid(Double.parseDouble(toggle.getText().substring(0, 1)));
        }else{
            tmpGroup = editor.removeGrid();
        }
    }

    @FXML
    private void zoomIn(ActionEvent event) {
        editor.zoom(true);
    }

    @FXML
    private void zoomOut(ActionEvent event) {
        editor.zoom(false);
    }
 
}
