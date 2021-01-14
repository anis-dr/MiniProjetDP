package org.tp.Decorator.ShapeDecorator;

import org.tp.Decorator.Shape;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public javafx.scene.shape.Shape get() {
        return decoratedShape.get();
    }
}