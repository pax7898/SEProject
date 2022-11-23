/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projectapp;

import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;

/**
 *
 * @author pasqualecaggiano
 */
public interface IState {
    public void draw(double d, double d1, double d2, double d3, Color strokeColor);
    public void draw( double d, double d1, double d2, double d3, Color strokeColor, Color fillColor);
    public void changeColor();
}