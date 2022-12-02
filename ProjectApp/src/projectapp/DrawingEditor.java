/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp;

import java.beans.DefaultPersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.Command;
import projectapp.command.CommandExecutor;
import projectapp.command.DrawCommand;
import projectapp.shape.SerializableShape;
import projectapp.tools.EditorState;
import projectapp.tools.EllipseState;
import projectapp.tools.LineState;
import projectapp.tools.RectangleState;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawingEditor {
    
    
    private final Pane drawingPane;
    
    private EditorState currentState;
    
    private final CommandExecutor executor;
    
    private Command currentCommand;
    
    private double startX;
    private double startY;

    public DrawingEditor(Pane pane, EditorState currentState, CommandExecutor executor) {
        
        this.drawingPane = pane;
        this.currentState = currentState;
        this.executor = executor;
        this.startX = 0;
        this.startY = 0;
    }

   
    public EditorState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(EditorState currentState) {
        this.currentState = currentState;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }
    
    
    public EditorState setLineState(){
        currentState = new LineState(drawingPane);
        currentCommand = new DrawCommand(currentState);
        return currentState;
    }
    
    public EditorState setRectangleState(){
        currentState = new RectangleState(drawingPane);
        return currentState;
    }
    
    public EditorState setEllipseState(){
        currentState = new EllipseState(drawingPane);
        return currentState;
    }
    
    public void executeDrawCommand(double endX, double endY,Color strokeColor, Color fillColor){
        executor.execute(new DrawCommand(currentState,startX,startY,endX,endY,strokeColor,fillColor));  
    }
    
    public void saveDrawing(File file){
        /*
        try {
            
            ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            objectOut.writeInt(listItems.size());
            
            for (Shape a : listItems) 
                { 
                    
                    System.out.print(a);
                    objectOut.writeObject(a);
                }
            
            //close stream
            objectOut.close();
                
        } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file))){
                    
                    encoder.setPersistenceDelegate(Color.class, new DefaultPersistenceDelegate(new String[]{"red","green","blue","opacity"}));
                    
                    encoder.writeObject(drawingPane.getChildren().toArray(new Node[0]));
                   
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    
                } 
        
    }
    
    
    public void loadDrawing(File file){
        /*
        try {
            
            listItems.clear();
            this.drawingPane.getChildren().clear();
            ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        
            
            int size = objectIn.readInt();
            for (int i=0;i<size;i++){
                Shape a = (Shape) objectIn.readObject();
                listItems.add(a);
                this.drawingPane.getChildren().add(a);
            }
            
            
            //close stream
            objectIn.close();
                
        } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        drawnView.setItems(getStringList());
    }*/
        drawingPane.getChildren().clear();
                
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(file))){
            drawingPane.getChildren().addAll((Node[]) decoder.readObject());  

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
