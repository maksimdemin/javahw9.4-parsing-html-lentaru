package com.deminmax;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageParser {
    private final String URL_CONTENT;


    public ImageParser(String url) {
        URL_CONTENT = url;
    }

    public  ListLinks parseHTMLFromURL() throws IOException {
        List<String> links = new ArrayList<>();

        Document document = Jsoup.connect(URL_CONTENT).get();
        Elements elements = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
        elements.forEach(element -> {
            links.add(element.attr("src"));
        });
        return new ListLinks(links);
    }
}
