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
import projectapp.SelectedShape;
import projectapp.command.ChangeBorderColorCommand;
import projectapp.command.ChangeInteriorColorCommand;
import projectapp.command.CommandExecutor;
import projectapp.command.DeleteCommand;

/**
 *
 * @author pasqualecaggiano
 */
public class SelectionTool extends Tool{
    private SelectedShape selectedShape;
    private Shape savedShape;
   

    public SelectionTool(Pane pane,SelectedShape selectedShape,CommandExecutor executor) {
        super(pane,executor); 
        this.selectedShape = selectedShape;
    }
    
    public SelectedShape getSelectedShape() {
        return selectedShape;
    }

    public Shape getSavedShape() {
        return savedShape;
    }

    public void setSavedShape(Shape savedShape) {
        this.savedShape = savedShape;
    }
    
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        
        if (selectedShape.getShape() != null){
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        }
        
        if (event.getTarget().getClass()!= getPane().getClass()){
            selectedShape.setShape((Shape) event.getTarget()); 
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:5px");
        }
    }
    
    @Override
    public void changeBorderColor(Color strokeColor) {
        getExecutor().execute(new ChangeBorderColorCommand(selectedShape.getShape(),strokeColor));
    }
    
    @Override
    public void changeInteriorColor(Color fillColor) {
        getExecutor().execute(new ChangeInteriorColorCommand(selectedShape.getShape(),fillColor));
    }
    
    @Override
    public void deleteShape() {
        getExecutor().execute(new DeleteCommand(selectedShape.getShape(),getPane()));
    }
    
    
    @Override
    public void copyShape() {
        setSavedShape(getSelectedShape().getShape());
    }

    @Override
    public void cutShape() {
        setSavedShape(getSelectedShape().getShape());
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
    public Shape getShape() {return null;}

}
