/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

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

    public CutCommand(Clonator clonator, Shape shape, Pane pane){
        this.clonator = clonator;
        this.shape = shape;
        this.pane = pane;
    }
    
    
    @Override
    public void execute() {
        clonator.encodeToXml(shape);
        pane.getChildren().remove(shape);
    }

    @Override
    public void undo() {
        pane.getChildren().add(shape);
        clonator.setByteCloned(null);

    }
    
}
