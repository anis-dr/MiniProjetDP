package org.tp;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Bounds;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
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
import org.tp.Singleton.SnapshotHandler;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DecoratorViewController {

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

    @FXML
    void exportButtonAction(ActionEvent event) {
        Window owner = ((Node) event.getTarget()).getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Image", "*.png"));
        File file = fileChooser.showSaveDialog(owner);

        if (file != null) {
            try {
                WritableImage writableImage = SnapshotHandler.snap(drawingPane);

                if (writableImage != null) {
                    ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
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