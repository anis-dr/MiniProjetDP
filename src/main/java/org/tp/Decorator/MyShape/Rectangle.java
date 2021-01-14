package org.tp.Decorator.MyShape;

import org.tp.DragController;
import org.tp.Decorator.Shape;

import static javafx.scene.paint.Color.BLACK;

public class Rectangle implements Shape {

    private final javafx.scene.shape.Rectangle rectangle;

    // Size should be 1, 2 or 3
    // Indicating Small, Medium, and Big
    // If we have a size we create JavaFX rectangle and we make it draggable
    // default color is black
    public Rectangle(int size) {
        if (size > 3 || size < 1) {
            throw new IllegalArgumentException("Not a valid Size.");
        }
        if (size == 1) {
            this.rectangle = new javafx.scene.shape.Rectangle(50, 50);
            this.rectangle.setFill(BLACK);
            new DragController(this.rectangle, true);
        } else if (size == 2) {
            this.rectangle = new javafx.scene.shape.Rectangle(100, 100);
            this.rectangle.setFill(BLACK);
            new DragController(this.rectangle, true);
        } else {
            this.rectangle = new javafx.scene.shape.Rectangle(200, 200);
            this.rectangle.setFill(BLACK);
            new DragController(this.rectangle, true);
        }
    }


    @Override
    public javafx.scene.shape.Shape get() {
        return rectangle;
    }
}