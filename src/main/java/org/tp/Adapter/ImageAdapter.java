package org.tp.Adapter;

import javafx.scene.Node;

import java.io.File;

public class ImageAdapter implements ImageSaver {

    AdvancedImageSaver advancedImageSaver;

    public ImageAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("png")) {
            advancedImageSaver = new PNGImageSaver();

        } else if (audioType.equalsIgnoreCase("jpeg")) {
            advancedImageSaver = new JPGImageSaver();
        }
    }

    @Override
    public void save(String imageType, File file, Node drawingPane) {
        if (imageType.equalsIgnoreCase("png")) {
            advancedImageSaver.savePng(file, drawingPane);
        } else if (imageType.equalsIgnoreCase("jpeg")) {
            advancedImageSaver.saveJpg(file, drawingPane);
        }
    }
}