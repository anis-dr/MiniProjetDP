package org.tp.Adapter;

import javafx.scene.Node;

import java.io.File;

public interface AdvancedImageSaver {
    public void savePng(File file, Node drawingPane);

    public void saveJpg(File file, Node drawingPane);
}