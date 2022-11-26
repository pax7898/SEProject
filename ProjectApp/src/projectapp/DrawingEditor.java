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
import javafx.stage.FileChooser;
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
        this.drawnView.setItems(this.getStringList());
        this.startX = 0;
        this.startY = 0;
    }

    public Pane getMainPane() {
        return mainPane;
    }

    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }

    public Pane getDrawingPane() {
        return drawingPane;
    }

    public void setDrawingPane(Pane drawingPane) {
        this.drawingPane = drawingPane;
    }

    public EditorState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(EditorState currentState) {
        this.currentState = currentState;
    }

    public ObservableList<SerializableShape> getListItems() {
        return listItems;
    }

    public void setListItems(ObservableList<SerializableShape> listItems) {
        this.listItems = listItems;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(CommandExecutor executor) {
        this.executor = executor;
    }

    public ListView getDrawnView() {
        return drawnView;
    }

    public void setDrawnView(ListView drawnView) {
        this.drawnView = drawnView;
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
    
    public void setLineState(){
        currentState = new LineState(drawingPane,listItems);
    }
    
    public void setRectangleState(){
        currentState = new RectangleState(drawingPane, listItems);
    }
    
    public void setEllipseState(){
        currentState = new EllipseState(drawingPane, listItems);
    }
    
    public void executeDrawCommand(double endX, double endY,Color strokeColor, Color fillColor){
        executor.execute(new DrawCommand(currentState,startX,startY,endX,endY,strokeColor,fillColor));
        drawnView.setItems(getStringList());
    }
    
    public void saveDrawing(){
        FileChooser fileChooser = new FileChooser();
 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Bin files (*.dat)", "*.dat");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(mainPane.getScene().getWindow());
        
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
    
    
    public void loadDrawing(){
        FileChooser fileChooser = new FileChooser();
 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Bin files (*.dat)", "*.dat");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(mainPane.getScene().getWindow());
        
        
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
