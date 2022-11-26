/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import projectapp.command.CommandExecutor;
import projectapp.command.DrawCommand;
import projectapp.shape.SerializableShape;
import projectapp.state.EditorState;
import projectapp.state.EllipseState;
import projectapp.state.LineState;
import projectapp.state.RectangleState;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawingEditor {
    
    private Pane mainPane;
    
    private Pane drawingPane;
    
    private EditorState currentState;
    
    private ObservableList<SerializableShape> listItems;
    
    private CommandExecutor executor;
    
    private ListView drawnView;
    
    private double startX;
    private double startY;

    public DrawingEditor(Pane mainPane,Pane pane, EditorState currentState, ObservableList<SerializableShape> listItems, CommandExecutor executor, ListView drawnView) {
        this.mainPane = mainPane;
        this.drawingPane = pane;
        this.currentState = currentState;
        this.listItems = listItems;
        this.executor = executor;
        this.drawnView = drawnView;
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
    
    
    public ObservableList<String> getStringList(){
        ObservableList<String> l = FXCollections.observableArrayList();
        for(int i=0;i<listItems.size();i++){
            String temp = listItems.get(i).toString();
            l.add(temp);
        }
        return l;
    }
    
    public EditorState setLineState(){
        currentState = new LineState(drawingPane,listItems);
        return currentState;
    }
    
    public EditorState setRectangleState(){
        currentState = new RectangleState(drawingPane, listItems);
        return currentState;
    }
    
    public EditorState setEllipseState(){
        currentState = new EllipseState(drawingPane, listItems);
        return currentState;
    }
    
    public void executeDrawCommand(double endX, double endY,Color strokeColor, Color fillColor){
        executor.execute(new DrawCommand(currentState,startX,startY,endX,endY,strokeColor,fillColor));
        drawnView.setItems(getStringList());
        
    }
    
    public void saveDrawing(File file){
        try {
            
            ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            objectOut.writeInt(listItems.size());
            
            for (SerializableShape a : listItems) 
                { 
                    
                    System.out.print(a);
                    objectOut.writeObject(a);
                }
            
            //close stream
            objectOut.close();
                
        } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void loadDrawing(File file){
        try {
            
            listItems.clear();
            this.drawingPane.getChildren().clear();
            ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        
            
            int size = objectIn.readInt();
            for (int i=0;i<size;i++){
                SerializableShape a = (SerializableShape) objectIn.readObject();
                listItems.add(a);
                this.drawingPane.getChildren().add(a.getShape());
            }
            
            
            //close stream
            objectIn.close();
                
        } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        drawnView.setItems(getStringList());
    }
}
