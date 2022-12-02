/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

/**
 *
 * @author pasqualecaggiano
 */

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;
import projectapp.command.DeleteCommand;

/**
 *
 * @author pasqualecaggiano
 */
public class SelectionTool extends Tool{
    private Shape selectedShape;
    private Shape savedShape;
   

    public SelectionTool(Pane pane,Shape selectedShape,CommandExecutor executor) {
        super(pane,executor); 
    }
    
    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    public Shape getSavedShape() {
        return savedShape;
    }

    public void setSavedShape(Shape savedShape) {
        this.savedShape = savedShape;
    }
    
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        if (selectedShape != null){
           selectedShape.setStyle("-fx-stroke-dash-array:none");
        }
        
        if (event.getTarget().getClass()!= getPane().getClass()){
            selectedShape = (Shape) event.getTarget();
            selectedShape.setStyle("-fx-stroke-dash-array:5px");
        }
    }
    
    @Override
    public void changeBorderColor(Color strokeColor) {
        getExecutor().execute(new ChangeBorderColorCommand(selectedShape,strokeColor));
    }
    
    @Override
    public void changeInteriorColor(Color fillColor) {
        getExecutor().execute(new ChangeInteriorColorCommand(selectedShape,fillColor));
    }
    
    @Override
    public void deleteShape() {
        getExecutor().execute(new DeleteCommand(selectedShape,getPane()));
    }
    

    @Override
    public void copyShape() {
        setSavedShape(getSelectedShape());
    }

    @Override
    public void cutShape() {
        setSavedShape(getSelectedShape());
        deleteShape();
    }

    @Override
    public void pasteShape() {
        getPane().getChildren().add(savedShape);
        
    }

    @Override
    public void onMouseDragged(MouseEvent event) {}

    @Override
    public void onMouseReleased(MouseEvent event) {}

    @Override
    public Shape getShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
