package org.tp.Decorator.ShapeDecorator;

import org.tp.Decorator.Shape;
import javafx.scene.paint.Color;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public javafx.scene.shape.Shape get() {
        setStroke(decoratedShape);
        return decoratedShape.get();
    }

    private void setStroke(Shape decoratedShape) {
        decoratedShape.get().setFill(Color.RED);
    }
}