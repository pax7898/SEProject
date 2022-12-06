/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singletons;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import projectapp.FXMLDocumentController;
import projectapp.command.CommandExecutor;
import projectapp.tools.EllipseTool;
import projectapp.tools.LineTool;
import projectapp.tools.MoveTool;
import projectapp.tools.RectangleTool;
import projectapp.tools.SelectionTool;
import projectapp.tools.Tool;


/**
 * This method is the only entry point for the communication between the controller (FXMLDocumentController) and 
 * the Model.
 * @author pasqualecaggiano
 */
public class DrawingEditor {
    
    
    private final Pane drawingPane;
    
    private final CommandExecutor executor;

    private Tool currentTool;
    
    private final SelectedShape selectedShape;
    
    private final ContextMenu menu;
    
    static private DrawingEditor instance = null;
    
    
    /**
     * 
     * DrawingEditor(Pane pane, CommandExecutor executor,Tool currentTool) is the class costructor
     * 
     * @param pane is the reference to the drawing pane
     * @param executor is the reference to the commands' invoker
     * @param currentTool is the current state of the draing editor
     */

    public DrawingEditor(Pane pane, CommandExecutor executor,Tool currentTool, ContextMenu menu) {
        this.drawingPane = pane;
        this.executor = executor;
        this.currentTool = currentTool;
        this.selectedShape = SelectedShape.getIstance();
        this.menu = menu;
    }
    
    public static DrawingEditor getIstance(Pane pane, CommandExecutor executor,Tool currentTool, ContextMenu menu){
        if (instance==null)
         instance = new DrawingEditor(pane,executor,currentTool, menu);
      return instance;
    }
    
    //create only for test
    public Tool getCurrentTool() {
        return currentTool;
    }

    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the line button in the application. This condition is necessary for draw a line.
     */
    public void setLineTool(){
        if (selectedShape.getShape() != null){
           selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new LineTool(drawingPane,executor);
    }
    
    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the rectangle button in the application. This condition is necessary for draw a rectangle.
     */
    public void setRectangleTool(){
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new RectangleTool(drawingPane,executor);
    }
    
    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the ellipse button in the application. This condition is necessary for draw an ellipse.
     */
    public void setEllipseTool(){
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new EllipseTool(drawingPane,executor);
    }
    
    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the selection button in the application. This condition is necessary for select a shape.
     */
    public void setSelectionTool(){
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none"); 
        }
        currentTool = new SelectionTool(drawingPane,selectedShape,executor, menu);
    }  
    
    /**
     * This method updates the currentTool (which corresponds to the state in tha pattern state)
     * when the user press the move button in the application. This condition is necessary for move a shape.
     */
    public void setMoveTool(){
        
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        currentTool = new MoveTool(drawingPane,selectedShape,executor, menu);
    }
    
    /**
     * {@link projectapp.FXMLDocumentController#onMousePressed(javafx.scene.input.MouseEvent)}
     * @param event is the mouse event detected from the FXMLController
     * @param strokeColor is the border color of the borderPicker
     * @param fillColor is the interior color of the interioPicker
     */
    public void onMousePressed(MouseEvent event,Color strokeColor, Color fillColor){
        currentTool.onMousePressed(event, strokeColor, fillColor);
    }
    
    /**
     * {@link projectapp.FXMLDocumentController#onMouseDragged(javafx.scene.input.MouseEvent)}
     * @param event is the mouse event detected from the FXMLController
     * 
     */
    public void onMouseDragged(MouseEvent event){
        currentTool.onMouseDragged(event);
    }
    
    /**
     * {@link projectapp.FXMLDocumentController#onMouseReleased(javafx.scene.input.MouseEvent)}
     * @param event is the mouse event detected from the FXMLController
     * 
     */
    public void onMouseReleased(MouseEvent event){
        currentTool.onMouseReleased(event);
        
    }
    
    /***
     * This method allows the user to change the border color of a given figure. 
     * @param strokeColor is the color set inside the color border picker.
     */
    public void changeBorderColor(Color strokeColor){
        currentTool.changeBorderColor(strokeColor);
    }
    /***
     * This method allows the user to change the interior color of a given figure.
     * @param fillColor is the color set inside the color interior picker.
     */
    public void changeInteriorColor(Color fillColor){
        currentTool.changeInteriorColor(fillColor);
    }
    
    /***
     * This method allows the user to delete the selected figure.
     */
    public void deleteShape(){
        currentTool.deleteShape();
    }
    
    /***
     * This method allows the user to copy the selected figure.
     */
    public void copyShape(){
        currentTool.copy();
    }
    
    /***
     * This method allows the user to copy the selected figure.
     */
    public void pasteShape(Point2D point){
        currentTool.paste(point);
    }
    
    
    public void undo(){
        executor.undo();
    }
    /**
     * This method llow you to save the current drawing on an XML file.
     * @param file is the location chosen by the user on his file system
     */
    public void saveDrawing(File file){
        
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file))){
                    
                    encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red","green","blue","opacity"}));
                    
                    encoder.writeObject(drawingPane.getChildren().toArray(new Node[0]));
                   
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);    
                } 
    }
    
    /**
     * This method llow you to load a previous saved drawing from an XML file.
     * @param file is the xml file chosen by the user to load
     */
    public void loadDrawing(File file){
        
        drawingPane.getChildren().clear();
                
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(file))){
            drawingPane.getChildren().addAll((Node[]) decoder.readObject());  

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
