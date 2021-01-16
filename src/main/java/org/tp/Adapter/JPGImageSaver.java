package org.tp.Adapter;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.image.WritableImage;
import org.tp.Singleton.SnapshotHandler;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class JPGImageSaver implements AdvancedImageSaver {
    @Override
    public void savePng(File file, Node drawingPane) {

    }

    @Override
    public void saveJpg(File file, Node drawingPane) {
        if (file != null) {
            try {
                WritableImage writableImage = SnapshotHandler.snap(drawingPane);
                if (writableImage != null) {
                    ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "jpg", file);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
