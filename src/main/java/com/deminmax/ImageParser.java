package com.deminmax;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ImageParser {
    private final String URL_CONTENT;
    private int statusCodeHTTP;

    public ImageParser(String url) {
        URL_CONTENT = url;
    }

    public  ListLinks parseHTMLFromURL() throws IOException {
        List<String> links = new ArrayList<>();
        List<String> linksFailedLinks = new ArrayList<>();

        Document document = Jsoup.connect(URL_CONTENT).get();
        Elements elements = document.select("img[src~=(?i)\\.(png|jpe?g)]");
        for (Element element : elements) {
            if (!isCorrectURL(element.attr("src"))) {
                linksFailedLinks.add("Invalid link: " + element.attr("src"));
            }
            else if (isExistURL(new URL(element.attr("src")))) {
                linksFailedLinks.add("HTTP Status-Code "+ statusCodeHTTP + ": " + element.attr("src"));
            }
            else links.add(element.attr("abs:src"));
        }
        return new ListLinks(links, linksFailedLinks);
    }


    public boolean isCorrectURL(String url) {
        try {
             URL u = new URL(url);
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    public boolean isExistURL(URL url) throws IOException {
        HttpURLConnection.setFollowRedirects(false);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("GET"); // or HEAD
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 400) {
            statusCodeHTTP = 400;
            return true;
        }
        if (responseCode == 404) {
            statusCodeHTTP = 404;
            return true;
        }
        return false;
    }
}