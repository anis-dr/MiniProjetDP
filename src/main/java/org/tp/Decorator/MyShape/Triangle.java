package org.tp.Decorator.MyShape;

import org.tp.DragController;
import org.tp.Decorator.Shape;
import javafx.scene.shape.Polygon;

import static javafx.scene.paint.Color.BLACK;

public class Triangle implements Shape {
    private final Polygon polygon;

    // Size should be 1, 2 or 3
    // Indicating Small, Medium, and Big
    // If we have a size we create JavaFX rectangle and we make it draggable
    // default color is black
    public Triangle(int size) {
        if (size > 3 || size < 1) {
            throw new IllegalArgumentException("Not a valid Size.");
        }
        if (size == 1) {
            this.polygon = new Polygon();
            polygon.getPoints().addAll(100.0, 0.0,
                    140.0, 60.0,
                    60.0, 60.0);
            this.polygon.setFill(BLACK);
            new DragController(this.polygon, true);
        } else if (size == 2) {
            this.polygon = new Polygon();
            polygon.getPoints().addAll(100.0, 0.0,
                    160.0, 80.0,
                    40.0, 80.0);
            this.polygon.setFill(BLACK);
            new DragController(this.polygon, true);
        } else {
            this.polygon = new Polygon();
            polygon.getPoints().addAll(100.0, 0.0,
                    180.0, 100.0,
                    20.0, 100.0);
            this.polygon.setFill(BLACK);
            new DragController(this.polygon, true);
        }
    }


    @Override
    public javafx.scene.shape.Shape get() {
        return polygon;
    }

}
