/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectapp.singletons;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


/**
 *  This class create a pane that allows to zoom in the scroll pane.
 * @author pasqualecaggiano
 */
public class ZoomPane extends Pane{
        public static final double DEFAULT_DELTA = 1.3d; 
        public static final double LOWER_BOUND = 0.2d;
        public static final double UPPER_BOUND = 6d;
        DoubleProperty myScale = new SimpleDoubleProperty(1.0);
        
        private Timeline timeline;
        
        public void zoom(boolean type){
            double scale = this.getScale(); 
            double oldScale = scale;

            if (!type) {
                scale /= DEFAULT_DELTA;
            } else {
                scale *= DEFAULT_DELTA;
            }
            
            if (scale >= LOWER_BOUND && scale <= UPPER_BOUND){
                this.setNewScale(scale);
            } else {
                this.setNewScale(oldScale);
            }
            
            System.out.println(getScale());
        }
        
        
        private static ZoomPane instance = null;
        
        public static ZoomPane getIstance(){  
            if (instance==null)
               instance = new ZoomPane();
            return instance;
        }
        
        /**
         *  Class constructor that bind the scale property of the pane with the current scale 
         *  and create the timeline
         */
        
        public ZoomPane() {
            this.timeline = new Timeline(30);
            scaleXProperty().bind(myScale);
            scaleYProperty().bind(myScale);
        }


        public double getScale() {
            return myScale.get();
        }
        
        public void setScale(double scale){
            myScale.set(scale);
        }
        

        /**
         * This method updates the new scale performing an animation
         * @param scale 
         */
        public void setNewScale(double scale) {
            
            timeline.getKeyFrames().clear();
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.millis(100), new KeyValue(myScale, scale)) 
            );
            timeline.play();

        }
}



