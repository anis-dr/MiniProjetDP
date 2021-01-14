package org.tp;

import org.tp.Decorator.*;
import org.tp.Decorator.MyShape.Circle;
import org.tp.Decorator.MyShape.Rectangle;
import org.tp.Decorator.MyShape.Triangle;
import org.tp.Decorator.ShapeDecorator.GreenShapeDecorator;
import org.tp.Decorator.ShapeDecorator.RedShapeDecorator;
import org.tp.Decorator.ShapeDecorator.WhiteShapeDecorator;
import org.tp.Decorator.ShapeDecorator.YellowShapeDecorator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

public class DecoratorController {

    @FXML
    private Pane drawingPane;

    @FXML
    private ComboBox<String> colorComboBox;

    @FXML
    private ComboBox<Integer> shapeSizeComboBox;


    ObservableList<String> colorsList =
            FXCollections.observableArrayList(
                    "Black",
                    "White",
                    "Red",
                    "Yellow",
                    "Green"
            );

    ObservableList<Integer> shapeSizeList =
            FXCollections.observableArrayList(
                    1,
                    2,
                    3
            );

    @FXML
    void initialize() {
        assert drawingPane != null : "fx:id=\"drawingPane\" was not injected: check your FXML file 'DecoratorUI.fxml'.";
        drawingPane.setBackground(Background.EMPTY);
        colorComboBox.getItems().addAll(colorsList);
        shapeSizeComboBox.getItems().addAll(shapeSizeList);
    }

    @FXML
    void circleButtonAction(ActionEvent event) {
        // Create default circle
        String color = colorComboBox.getValue();
        Integer size = shapeSizeComboBox.getValue();
        if (color == null || size == null) {
            showError(event);
            return;
        }
        Shape shape = getColorDecorator(color, new Circle(size));

        // Add children to the pane
        drawingPane.getChildren().add(shape.get());
    }

    @FXML
    void rectButtonAction(ActionEvent event) {
        // Create decorated rectangles
        String color = colorComboBox.getValue();
        Integer size = shapeSizeComboBox.getValue();
        if (color == null || size == null) {
            showError(event);
            return;
        }
        Shape shape = getColorDecorator(color, new Rectangle(size));

        // Add children to the pane
        drawingPane.getChildren().add(shape.get());
    }

    @FXML
    void triangleButtonAction(ActionEvent event) {
        // Create decorated rectangles
        String color = colorComboBox.getValue();
        Integer size = shapeSizeComboBox.getValue();
        if (color == null || size == null) {
            showError(event);
            return;
        }
        Shape shape = getColorDecorator(color, new Triangle(size));

        // Add children to the pane
        drawingPane.getChildren().add(shape.get());
    }

    Shape getColorDecorator(String colorName, Shape shape) {
        switch (colorName) {
            case "Red":
                return new RedShapeDecorator(shape);
            case "Yellow":
                return new YellowShapeDecorator(shape);
            case "White":
                return new WhiteShapeDecorator(shape);
            case "Green":
                return new GreenShapeDecorator(shape);
            default:
                return shape;
        }
    }

    private void showError(ActionEvent event) {
        Window owner = ((Node) event.getTarget()).getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Color");
        alert.setContentText("Please choose a color");
        alert.initOwner(owner);
        alert.show();
    }
}