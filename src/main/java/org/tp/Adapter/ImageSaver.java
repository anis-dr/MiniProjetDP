package org.tp.Adapter;

import javafx.scene.Node;

import java.io.File;

public interface ImageSaver {
    public void save(String imageType, File file, Node drawingNode);
}