/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import singletons.Clonator;

/**
 *
 * @author Sabatino
 */
public class CutCommand implements Command{
    
    private Clonator clonator;
    private Shape shape;
    private Pane pane;
    private ContextMenu menu;

    public CutCommand(Clonator clonator, Shape shape, Pane pane, ContextMenu menu){
        this.clonator = clonator;
        this.shape = shape;
        this.pane = pane;
        this.menu = menu;
    }
    
    
    @Override
    public void execute() {
        clonator.encodeToXml(shape);
        pane.getChildren().remove(shape);
        menu.getItems().get(3).setDisable(false);
    }

    @Override
    public void undo() {
        pane.getChildren().add(shape);
        clonator.setByteCloned(null);

    }
    
}
