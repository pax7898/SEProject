/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

/**
 *
 * @author pasqualecaggiano
 */

import projectapp.singletons.Clonator;
import javafx.geometry.Point2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.singletons.SelectedShape;
import projectapp.command.ChangeBorderColorCommand;
import projectapp.command.ChangeInteriorColorCommand;
import projectapp.command.ChangeSizeCommand;
import projectapp.command.CommandExecutor;
import projectapp.command.CopyCommand;
import projectapp.command.CutCommand;
import projectapp.command.DeleteCommand;
import projectapp.command.PasteCommand;
import projectapp.command.ToBackCommand;
import projectapp.command.ToFrontCommand;


/**
 *
 *This SelectionTool class represents the state that allows me to select a 
 *specific figure on which operations will be performed.
 * @author pancraziocirillo
 */

public class SelectionTool extends Tool{
    private final SelectedShape selectedShape;
    private final Clonator clonator;
    private final ContextMenu menu;
    private final VBox vboxChangeSize;
    private double changeSizeX;
    private double changeSizeY;
    private static final int HBOX_1 = 0;
    private static final int HBOX_2 = 1;
    private static final int TEXT_FIELD_CHANGE_SIZE = 1;
    
    
    /**
     * The costructor calls the costructor of Tool class
     * @param pane
     * @param executor
     * Adds an other param that refers to the selectedShape
     * @param selectedShape 
     * @param menu 
     */
    public SelectionTool(Pane pane,SelectedShape selectedShape,CommandExecutor executor, ContextMenu menu, VBox vboxChangeSize) {
        super(pane,executor); 
        this.selectedShape = selectedShape;
        this.clonator = Clonator.getIstance();
        this.menu = menu;
        this.vboxChangeSize = vboxChangeSize;
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
            menu.getItems().forEach(item -> {
                item.setDisable(false);
            });
        } else {
            vboxChangeSize.visibleProperty().set(false);
            selectedShape.setShape(null);
                menu.getItems().forEach(item -> {
                    item.setDisable(true);
                });
            if(clonator.getByteCloned() != null){ 
                menu.getItems().get(3).setDisable(false);
            }
            
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
    
    
    @Override
    public void copy() {
        if (selectedShape.getShape()!= null)
            getExecutor().execute(new CopyCommand(clonator,selectedShape.getShape()));
        else 
            clonator.setByteCloned(null);
        
    }
    
    @Override
    public void paste(Point2D point) {
        if (clonator.getByteCloned()!=null)
            getExecutor().execute(new PasteCommand(clonator,getPane(),point));
        
    }

    @Override
    public void cut() {
        if (selectedShape.getShape()!= null)
            getExecutor().execute(new CutCommand(clonator,selectedShape.getShape(), getPane(), menu));
        else 
            clonator.setByteCloned(null);    
    }
    
    /**
     * This method allows you to change the z-axis level of a selected shape 
     */
    @Override
    public void toFront() {
        getExecutor().execute(new ToFrontCommand(selectedShape.getShape(), getPane()));
    }
    @Override
    public void toBack() {
        getExecutor().execute(new ToBackCommand(selectedShape.getShape(), getPane()));
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

    /**
     * This method shows a section in the toolbar in order to
     * modify the size of the selected shape
     */
    public void changeSizeBar() {
        vboxChangeSize.visibleProperty().set(true);
    }
    
    /**
     * This method modifies the size of the shape
     */
    @Override
    public void changeSize() {
        
        HBox hboxX = (HBox) vboxChangeSize.getChildren().get(HBOX_1);
        HBox hboxY = (HBox) vboxChangeSize.getChildren().get(HBOX_2);
        System.out.println(hboxX);
        TextField textX = (TextField) hboxX.getChildren().get(TEXT_FIELD_CHANGE_SIZE);
        TextField textY = (TextField) hboxY.getChildren().get(TEXT_FIELD_CHANGE_SIZE);
        changeSizeX = Double.parseDouble(textX.getText());
        changeSizeY = Double.parseDouble(textY.getText());
        getExecutor().execute(new ChangeSizeCommand(selectedShape, changeSizeX, changeSizeY, vboxChangeSize));

    }

    

}
