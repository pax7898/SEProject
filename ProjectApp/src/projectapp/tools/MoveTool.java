/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.tools;

import static java.lang.Math.abs;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import projectapp.command.CommandExecutor;

/**
 *
 * @author pasqualecaggiano
 */
public class MoveTool extends SelectionTool{
    
    private double initialPositionX;
    private double initialPositionY;
    private boolean flag;
    private double newX;
    private double newY;
    private double salvoX;
    private double salvoY;
    
    public MoveTool(Pane pane, Shape selectedShape, CommandExecutor command) {
        super(pane, selectedShape, command);
        this.newX = 0;
        this.newY = 0;
        this.salvoX = 0;
        this.salvoY = 0;
    }

   
    @Override
    public void onMousePressed(MouseEvent event, Color strokeColor, Color fillColor){
        if (super.getSelectedShape() != null){
           super.getSelectedShape().setStyle("-fx-stroke-dash-array:none");
        }
        
        if (event.getTarget().getClass()!= getPane().getClass()){
            super.setSelectedShape((Shape) event.getTarget());
            super.getSelectedShape().setStyle("-fx-stroke-dash-array:5px");
            flag = true;
            this.initialPositionX = event.getX();
            this.initialPositionY = event.getY();
        }
        else{
            flag = false;
        }
    }
    
    
    @Override
    public void onMouseDragged(MouseEvent event) {
        if(flag == true){
            System.out.println("sono newX" + newX);
            super.getSelectedShape().setTranslateX(this.newX);
            super.getSelectedShape().setTranslateY(this.newY);
            newX = salvoX + event.getX()-initialPositionX;
            newY = salvoY + event.getY()-initialPositionY;
            
        }
        
    }

    @Override
    public void onMouseReleased(MouseEvent event) {
        if(flag == true){
            //super.getSelectedShape().setTranslateX(event.getX() - initialPositionX);
            //super.getSelectedShape().setTranslateY(event.getY() - initialPositionY);
            //this.initialPositionX = event.getX();
            //this.initialPositionY = event.getY();
            
            salvoX  += event.getX()-initialPositionX;
            salvoY  += event.getY()-initialPositionY;
            System.out.println("Sono qui! " + newX);
        }
    }
    
     @Override
    public void changeBorderColor(Color strokeColor) {}

    @Override
    public void changeInteriorColor(Color strokeColor) {}
    
     
}

