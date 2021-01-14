package org.tp.Decorator.MyShape;


import org.tp.DragController;
import org.tp.Decorator.Shape;

import static javafx.scene.paint.Color.BLACK;

public class Circle implements Shape {
    private final javafx.scene.shape.Circle circle;

    // Size should be 1, 2 or 3
    // Indicating Small, Medium, and Big
    // If we have a size we create JavaFX draggableCircle and we make it draggable
    // default color is black
    public Circle(int size) {
        if (size > 3 || size < 1) {
            throw new IllegalArgumentException("Not a valid Size.");
        }
        if (size == 1) {
            this.circle = new javafx.scene.shape.Circle(25);
            this.circle.setFill(BLACK);
            new DragController(circle, true);
//            DragResizeMod.makeResizable(draggableCircle);
        } else if (size == 2) {
            this.circle = new javafx.scene.shape.Circle(50);
            this.circle.setFill(BLACK);
            new DragController(circle, true);
        } else {
            this.circle = new javafx.scene.shape.Circle(100);
            this.circle.setFill(BLACK);
            new DragController(circle, true);
        }
    }

    @Override
    public javafx.scene.shape.Shape get() {
        return this.circle;
    }
}