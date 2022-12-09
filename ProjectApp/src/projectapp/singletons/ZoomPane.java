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
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


/**
 *  This class create a pane that allows to zoom in the scroll pane.
 * @author pasqualecaggiano
 */
public class ZoomPane extends Pane{
        public static final double DEFAULT_DELTA = 1.5d; //1.3d
        DoubleProperty myScale = new SimpleDoubleProperty(1.0);
        public DoubleProperty deltaY = new SimpleDoubleProperty(0.0);
        private Timeline timeline;
        
        /**
         * The event handler for any scroll events on the scroll pane
         */
        /*
        private EventHandler<ScrollEvent> onScrollEventHandler = (ScrollEvent event) -> {
            double delta = this.DEFAULT_DELTA;
            
            double scale = this.getScale(); 
            double oldScale = scale;

            this.setDeltaY(event.getDeltaY());
            if (this.deltaY.get() < 0) {
                scale /= delta;
            } else {
                scale *= delta;
            }

            double f = (scale / oldScale)-1;
            
            double dx = (event.getX() - (this.getBoundsInParent().getWidth()/2 + this.getBoundsInParent().getMinX()));
            double dy = (event.getY() - (this.getBoundsInParent().getHeight()/2 + this.getBoundsInParent().getMinY()));
            
            this.setPivot(f*dx, f*dy, scale);
            
            event.consume();
        };*/
        
        public void zoom(double x, double y, boolean type){
            double delta = this.DEFAULT_DELTA;
            double scale = this.getScale(); 
            double oldScale = scale;

            if (!type) {
                scale /= delta;
            } else {
                scale *= delta;
            }

            double f = (scale / oldScale)-1;
            
            double dx = (x - (this.getBoundsInParent().getWidth()/2 + this.getBoundsInParent().getMinX()));
            double dy = (x - (this.getBoundsInParent().getHeight()/2 + this.getBoundsInParent().getMinY()));
            
            this.setPivot(f*dx, f*dy, scale);
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
         * This method updates the new scale and perform a traslation of the zoom pane 
         * according to the point of the pane where the scroll event is triggered.
         * @param x
         * @param y
         * @param scale 
         */
        public void setPivot( double x, double y, double scale) {
            // note: pivot value must be untransformed, i. e. without scaling
            // timeline that scales and moves the node
            
            timeline.getKeyFrames().clear();
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.millis(100), new KeyValue(translateXProperty(), getTranslateX() - x)), 
                    new KeyFrame(Duration.millis(100), new KeyValue(translateYProperty(), getTranslateY() - y)), 
                    new KeyFrame(Duration.millis(100), new KeyValue(myScale, scale)) 
            );
            timeline.play();

        }
        /*
        public double getDeltaY() {
            return deltaY.get();
        }
        public void setDeltaY( double dY) {
            deltaY.set(dY);
        }
        
        public EventHandler<ScrollEvent> getOnScrollEventHandler() {
            return onScrollEventHandler;
        }*/
}



