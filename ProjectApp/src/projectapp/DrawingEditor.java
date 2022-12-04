/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import projectapp.command.CommandExecutor;
import projectapp.tools.EllipseTool;
import projectapp.tools.LineTool;
import projectapp.tools.MoveTool;
import projectapp.tools.RectangleTool;
import projectapp.tools.SelectionTool;
import projectapp.tools.Tool;


/**
 *
 * @author pasqualecaggiano
 */
public class DrawingEditor {
    
    
    private final Pane drawingPane;
    
    private final CommandExecutor executor;
   
    private Tool currentTool;
    private final SelectedShape selectedShape;
    
    public DrawingEditor(Pane pane, CommandExecutor executor,Tool currentTool) {
        this.drawingPane = pane;
        this.executor = executor;
        this.currentTool = currentTool;
        this.selectedShape = new SelectedShape(null);   
    }
//create only for test
    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setLineTool(){
        System.out.println(selectedShape.getShape());
        if (selectedShape.getShape() != null){
           selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new LineTool(drawingPane,executor);
    }
    
    public void setRectangleTool(){
        System.out.println(selectedShape.getShape());
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new RectangleTool(drawingPane,executor);
    }
    
    public void setEllipseTool(){
        System.out.println(selectedShape.getShape());
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new EllipseTool(drawingPane,executor);
    }
    /***
     * This method allows me to change the current state of the application 
     * based on which button is pressed, where each button represents a state.
     * After pressing the button the controller will be updated.
     */
    public void setSelectionTool(){
        System.out.println(selectedShape.getShape());
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new SelectionTool(drawingPane,selectedShape,executor);
    }  
    
    public void setMoveTool(){
        System.out.println(selectedShape.getShape());
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new MoveTool(drawingPane,selectedShape,executor);
    }
    
    
    public void onMousePressed(MouseEvent event,Color strokeColor, Color fillColor){
        currentTool.onMousePressed(event, strokeColor, fillColor);
    }
    public void onMouseDragged(MouseEvent event){
        currentTool.onMouseDragged(event);
    }
    public void onMouseReleased(MouseEvent event){
        currentTool.onMouseReleased(event);
    }
    /***
     * This method allows you to change the border color of a given figure. 
     * After that the controller will be updated.
     * @param strokeColor is the color set inside the color border picker.
     */
    public void changeBorderColor(Color strokeColor){
        currentTool.changeBorderColor(strokeColor);
    }
    /***
     * This method allows you to change the interior color of a given figure. 
     * After that the controller will be updated.
     * @param fillColor is the color set inside the color interior picker.
     */
    public void changeInteriorColor(Color fillColor){
        currentTool.changeInteriorColor(fillColor);
    }
    
    public void deleteShape(){
        currentTool.deleteShape();
    }
    
    
    public void saveDrawing(File file){
        
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file))){
                    
                    encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red","green","blue","opacity"}));
                    
                    encoder.writeObject(drawingPane.getChildren().toArray(new Node[0]));
                   
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);    
                } 
    }
    
    
    public void loadDrawing(File file){
        
        drawingPane.getChildren().clear();
                
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(file))){
            drawingPane.getChildren().addAll((Node[]) decoder.readObject());  

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
