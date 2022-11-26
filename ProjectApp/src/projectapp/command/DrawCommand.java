/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.command;


import projectapp.command.Command;
import projectapp.state.EditorState;
import javafx.scene.paint.Color;

/**
 *
 * @author pasqualecaggiano
 */
public class DrawCommand extends Command{
    private final EditorState state;
    private final double d;
    private final double d1;
    private final double d2;
    private final double d3;
    private final Color strokeColor;
    private final Color fillColor;
 
    public DrawCommand(EditorState state,double d, double d1,double d2, double d3, Color strokeColor, Color fillColor) {
        this.state = state;
        this.d = d;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }

    @Override
    public void execute() {
        try{
            state.draw(d,d1,d2,d3,strokeColor, fillColor);
        }catch(NullPointerException e){
            System.out.println("Devi selezionare una figura");
        }
    }
    
}
