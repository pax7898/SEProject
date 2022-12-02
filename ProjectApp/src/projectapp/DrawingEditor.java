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
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import tools.EllipseTool;
import tools.LineTool;
import tools.MoveTool;
import tools.ResizeTool;
import tools.RectangleTool;
import tools.SelectionTool;
import tools.Tool;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawingEditor {
    
    
    private final Pane drawingPane;
    
    private final CommandExecutor executor;
   
    private Tool currentTool;
    private Shape selectedShape;
    private Shape savedShape;
    
    public DrawingEditor(Pane pane, CommandExecutor executor,Tool currentTool) {
        this.drawingPane = pane;
        this.executor = executor;
        this.currentTool=currentTool;
    }

   
    public void setLineTool(){
        
        if (selectedShape != null){
           selectedShape.getStrokeDashArray().clear();
        }
        currentTool = new LineTool(drawingPane,executor);
    }
    
    public void setRectangleState(){
        System.out.print(selectedShape);
        if (selectedShape != null){
            selectedShape.getStrokeDashArray().clear();
        }
        currentTool = new RectangleTool(drawingPane,executor);
    }
    
    public void setEllipseTool(){
        if (selectedShape != null){
            selectedShape.getStrokeDashArray().clear();
        }
        currentTool = new EllipseTool(drawingPane,executor);
    }
    public void setSelectionTool(){
        if (selectedShape != null){
            selectedShape.getStrokeDashArray().clear();
        }
        currentTool = new SelectionTool(drawingPane,selectedShape,executor);
    }  
    
    public void setMoveTool(){
        if (selectedShape != null){
            selectedShape.getStrokeDashArray().clear();
        }
        currentTool = new MoveTool(drawingPane,selectedShape,executor);
    }
    
    public void setResizeTool(){
        if (selectedShape != null){
            selectedShape.getStrokeDashArray().clear();
        }
        currentTool = new ResizeTool(drawingPane,selectedShape,executor);
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
    
    public void changeBorderColor(Color strokeColor){
        currentTool.changeBorderColor(strokeColor);
    }
    
    public void changeInteriorColor(Color fillColor){
        currentTool.changeInteriorColor(fillColor);
    }
    
    public void deleteShape(){
        currentTool.deleteShape();
    }
    
    public void copyShape(){
        currentTool.copyShape();
    }
    
    public void cutShape(){
        currentTool.cutShape();
    }
    
    public void pasteShape(){
        currentTool.pasteShape();
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
    
    public void undo(){
        executor.undo();
    }
}
