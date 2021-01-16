package org.tp.Singleton;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class SnapshotHandler {
    private final SnapshotHandler instance = new SnapshotHandler();

    public SnapshotHandler() {
    }

    public SnapshotHandler getInstance() {
        return instance;
    }

    public static WritableImage snap(Node node) {
        try {
            final Bounds bounds = node.getLayoutBounds();
            int imageWidth = (int) Math.round(bounds.getWidth());
            int imageHeight = (int) Math.round(bounds.getHeight());
            final SnapshotParameters snapPara = new SnapshotParameters();
            snapPara.setFill(Color.GRAY);
            WritableImage snapshot = new WritableImage(imageWidth, imageHeight);
            return node.snapshot(snapPara, snapshot);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
