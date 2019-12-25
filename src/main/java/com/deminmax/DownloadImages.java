package com.deminmax;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DownloadImages {

    public static void downloadsImages(ListLinks links) {
            links.getListLinks().forEach(link -> {
                try {
                    URL url = new URL(link);
                    ImageIO.write(ImageIO.read(url), "png", new File("/Users/maksimdemin/IdeaProjects/javahw9.4-parsing-html-lentaru/download/" + link.substring(link.lastIndexOf('/') + 1)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
    }
}
