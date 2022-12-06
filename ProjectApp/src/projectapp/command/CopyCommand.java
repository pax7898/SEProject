/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;

import javafx.scene.shape.Shape;
import singletons.Clonator;

/**
 *
 * @author pasqualecaggiano
 */
public class CopyCommand implements Command{
    private Clonator clonator;
    private Shape shape;

    public CopyCommand(Clonator clonator, Shape shape) {
        this.clonator = clonator;
        this.shape = shape;
    }
    
    
    
    @Override
    public void execute() {
        clonator.encodeToXml(shape);
    }

    @Override
    public void undo() {
        clonator.setByteCloned(null);
    }
    
}
