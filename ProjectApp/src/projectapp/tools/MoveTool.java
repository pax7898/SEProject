/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;


import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.singletons.SelectedShape;
import projectapp.command.CommandExecutor;
import projectapp.command.MoveCommand;

/**
 * This class is a state in the pattern state and
 * allow us to move the shape on the pane
 * 
 * @author acoon
 */
public class MoveTool extends Tool{
    
    private double initialPositionX;
    private double initialPositionY;
    private boolean flag;
    private double newX;
    private double newY;
    private double oldX;
    private double oldY;
    private SelectedShape selectedShape;
    private ContextMenu menu;
    
    public MoveTool(Pane pane, CommandExecutor command, SelectedShape selectedShape, ContextMenu menu) {
        super(pane,command);
        this.selectedShape = selectedShape;
        this.menu = menu;
        menu.getItems().forEach(item -> {
            item.setDisable(true);
        });
        if(selectedShape.getShape() != null)
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:5px");
    }
    
       /*I need getter method only for tests*/
    public double getNewX() {
        return newX;
    }

    public double getNewY() {
        
        return newY;
    }


    public double getOldX() {
        return oldX;
    }


    public double getOldY() {
        return oldY;
    }


   /**
    * This method is called when the user select a shape on the pane. 
    * When a shape is selected its style will be changed.
    * In this method the parameters that allow us to move the figure correctly and linearly are set.   
    * 
    * @param event is the mouse click event on the pane
    * @param strokeColor is unusued 
    * @param fillColor is unusued 
    */
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        if (selectedShape.getShape() != null){
           selectedShape.getShape().setStyle("-fx-stroke-dash-array:none");
        } 
        if (event.getTarget().getClass()!= getPane().getClass()){
            selectedShape.setShape((Shape) event.getTarget());
            selectedShape.getShape().setStyle("-fx-stroke-dash-array:5px");
            flag = true;
            this.initialPositionX = event.getX();
            this.initialPositionY = event.getY();
            newX = oldX = selectedShape.getShape().getTranslateX();
            newY = oldY = selectedShape.getShape().getTranslateY();
        }
        else{
            flag = false;
        }
    }

    /**
     * This method allow us to translate the shape simultaneously with the drag of the mouse.
     * At the first iteraction the shape will be translated in place and in 
     * At each iteration the variables newX and newY will be updated taking into account the old position in which the figure was.
     * The operations (oldX + event.getX() - initialPositionX) and (oldY + event.getY() - initialPositionY) allow us to move the figure in linear way 
     * following the mouse drag.
     * 
     * @param event is the mouse drag event on the pane
     */
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(flag == true){
            selectedShape.getShape().setTranslateX(newX);
            selectedShape.getShape().setTranslateY(newY);
            newX = oldX + event.getX() - initialPositionX;
            newY = oldY + event.getY() - initialPositionY;

        }      
    }
    
    /**
     * This method execute a MoveCommand that set the last position of the shape in the pane 
     * indicated by the user with the mouse. Moreover,  we are going to save of what the figure has been translated. 
     * 
     * 
     * @param event is the mouse release event on the pane
     */
    @Override
    public void onMouseReleased(MouseEvent event) {
        if(flag == true){
            super.getExecutor().execute(new MoveCommand(selectedShape.getShape(),selectedShape.getShape().getTranslateX(), 
                                        selectedShape.getShape().getTranslateY(), oldX, oldY));
            oldX  = selectedShape.getShape().getTranslateX();
            oldY  = selectedShape.getShape().getTranslateY();
            
        }
    }
    
    /*
     * Unimplemented methods of the abstract class Tool
     */
     @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}

    @Override
    public Shape getShape() {
        return selectedShape.getShape();
    }

    @Override
    public void deleteShape() {}

    @Override
    public void copy() {}

    @Override
    public void paste(Point2D point) {}

    @Override
    public void cut() {}

    @Override
    public void toFront() {}

    @Override
    public void toBack() {}
    
}

