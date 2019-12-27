package com.deminmax;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DownloadImages {

    public static void downloadsImages(ListLinks links, Path dstPath) {
            links.getListLinks().forEach(link -> {
                try {
                    URL url = new URL(link);
                    ImageIO.write(ImageIO.read(url), "png", new File("/Users/maksimdemin/IdeaProjects/javahw9.4-parsing-html-lentaru/download/" + link.substring(link.lastIndexOf('/') + 1)));
//                    Path dstFilePath = getPathToNewImageFile(url.toString(), dstPath);
//                    FileUtils.copyURLToFile(url, dstFilePath.toFile());
//                    System.out.println("Copy image to: " + dstFilePath);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
    }

    public static Path getPathToNewImageFile(String url, Path dstPath) {
        return dstPath.resolve(FilenameUtils.getName(url));
    }

    public static Path pathFomUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter destination path: ");
            Path path = Path.of(scanner.nextLine());
            if (path.getParent() != null && Files.isWritable(path.getParent()) || Files.isWritable(path))
                return path;
            System.out.println("Destination is inaccessible");
            System.out.println();
        }
    }
}


