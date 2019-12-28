package com.deminmax;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DownloadImages {

    public static void downloadsImages(ListLinks links, Path dstPath) {
            links.getListLinks().forEach(link -> {
                try {
                    Path dstFilePath = getPathToNewImageFile(link, dstPath);
                    FileUtils.copyURLToFile(new URL(link), dstFilePath.toFile());
                    System.out.printf("Copy image %-45s to directory: %s%n", FilenameUtils.getName(link), dstPath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        System.out.printf("Copied %s image(s)", links.getListLinks().size());
    }

    public static Path getPathToNewImageFile(String link, Path dstPath) {
        return dstPath.resolve(FilenameUtils.getName(link));
    }

    public static Path pathFromUser() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter destination path: ");
            Path path = Path.of(scanner.nextLine());
            if (path.getParent() != null && Files.isWritable(path.getParent()) || Files.isWritable(path))
                return path;
            System.out.println("The path not exist");
        }
    }
}


