/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import projectapp.singletons.SelectedShape;

/**
 * This class allows us to create a command for the Change Size operation
 * 
 * @author Sabatino
 */
public class ChangeSizeCommand implements Command{
    
    private SelectedShape selectedShape;
    private double beforeX;
    private double beforeY;
    private double changeSizeX;
    private double changeSizeY;
    private VBox vboxChangeSize;
    
    
    /**
     * ChangeSizeCommand(SelectedShape selectedShape,double changeSizeX, double changeSizeY, Double beforeX,
     * Double beforeY, VBox vboxChangeSize) is the class constructor
     * 
     * @param selectedShape
     * @param changeSizeX
     * @param changeSizeY
     * @param beforeX
     * @param beforeY
     * @param vboxChangeSize 
     */
    public ChangeSizeCommand(SelectedShape selectedShape,double changeSizeX, double changeSizeY, Double beforeX, Double beforeY, VBox vboxChangeSize){
        this.selectedShape = selectedShape;
        this.changeSizeX = changeSizeX;
        this.changeSizeY = changeSizeY;
        this.beforeX = beforeX;
        this.beforeY = beforeY;
        this.vboxChangeSize = vboxChangeSize;
    }
    
    /**
     * This method change the size of the selected shape
     */
    @Override
    public void execute() {     
        selectedShape.getShape().setScaleX(changeSizeX);
        selectedShape.getShape().setScaleY(changeSizeY);
        vboxChangeSize.visibleProperty().set(false);
    }
    
    /**
     * This method restore the previous size of the selected shape
     */
    @Override
    public void undo() {
        selectedShape.getShape().setScaleX(beforeX);
        selectedShape.getShape().setScaleY(beforeY);
    }
    
}