package com.deminmax;
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
                    String nameNewImageFile = link.substring(link.lastIndexOf('/') + 1);
                    String pathToNewImageFile = dstPath + "/" + nameNewImageFile;
                    String formatImageName = link.substring(link.lastIndexOf('.') + 1);
                    URL url = new URL(link);
                    ImageIO.write(ImageIO.read(url), formatImageName, new File(pathToNewImageFile));
                    System.out.printf("Copy image %-50s to directory: %s%n", nameNewImageFile, dstPath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
    }

    public static Path pathFromUser() {
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


