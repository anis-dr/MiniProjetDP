package org.tp.Adapter;

import javafx.scene.Node;

import java.io.File;

public class FileSaver implements ImageSaver {
    ImageAdapter imageAdapter;

    @Override
    public void save(String imageType, File file, Node drawingNode) {

        //imageAdapter is providing support to save file formats
        if (imageType.equalsIgnoreCase("png") || imageType.equalsIgnoreCase("jpeg")) {
            imageAdapter = new ImageAdapter(imageType);
            imageAdapter.save(imageType, file, drawingNode);
        } else {
            System.out.println("Invalid media. " + imageType + " format not supported");
        }
    }
}