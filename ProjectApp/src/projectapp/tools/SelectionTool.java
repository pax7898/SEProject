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
 *This SelectionTool class represents the state that allows me to select a 
 *specific figure on which operations will be performed.
 * @author pancraziocirillo
 */

public class SelectionTool extends Tool{
    private final SelectedShape selectedShape;
   
    /**
     * The costructor calls the costructor of Tool class
     * @param pane
     * @param executor
     * Adds an other param that refers to the selectedShape
     * @param selectedShape 
     */
    public SelectionTool(Pane pane,SelectedShape selectedShape,CommandExecutor executor) {
        super(pane,executor); 
        this.selectedShape = selectedShape;
    }
    
    public SelectedShape getSelectedShape() {
        return selectedShape;
    }

    /***
     * This method ensures that when a figure is selected inside the work window, this shape is selected and illuminated.
     * When you then select another figure, the new figure is highlighted and the old figure deselected.
     * @param event this event rappresent the pressed mouse event
     * @param strokeColor is the color that is setted in border picker color
     * @param fillColor is the color that is setted in interior picker color
     */
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
    /***
     * This method allows you to change the border color of a given figure
     * after having selected it
     * @param strokeColor is the color set inside the color border picker.
     */
    @Override
    public void changeBorderColor(Color strokeColor) {
        getExecutor().execute(new ChangeBorderColorCommand(selectedShape.getShape(),strokeColor));
    }
    /***
     * This method allows you to change the interior color of a given figure 
     * after having selected it
     * @param fillColor is the color set inside the color interior picker.
     */
    @Override
    public void changeInteriorColor(Color fillColor) {
        getExecutor().execute(new ChangeInteriorColorCommand(selectedShape.getShape(),fillColor));
    }
    
    @Override
    public void deleteShape() {
        getExecutor().execute(new DeleteCommand(selectedShape.getShape(),getPane()));
    }
    
    /*
     * Unimplemented methods of the abstract class Tool
     */
    
    @Override
    public void onMouseDragged(MouseEvent event) {}

    @Override
    public void onMouseReleased(MouseEvent event) {}

    @Override
    public Shape getShape() {return null;}

}
