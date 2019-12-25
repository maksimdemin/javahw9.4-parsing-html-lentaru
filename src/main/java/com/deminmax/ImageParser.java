package com.deminmax;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImageParser {

    public  ListLinks parseHTMLFromURL(String url) throws IOException {
        List<String> links = new ArrayList<>();

        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("img.g-picture");
        elements.forEach(element -> {
            links.add(element.attr("abs:src"));
        });
        return new ListLinks(links);
    }


    // метод для работы с кодом HTML (локальный файл)
    public static String parseHTMLFile(String path) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get("data/code.html"));
            lines.forEach(line -> stringBuilder.append(line + "\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
