package com.deminmax;

import java.util.ArrayList;
import java.util.List;

public class ListLinks {

    private List<String> listLinks;
    private List<String> listFailedLinks;

    public ListLinks(List<String> listLinks, List<String> listNotFoundLinks) {
        this.listLinks = listLinks;
        this.listFailedLinks = listNotFoundLinks;
    }

    public List<String> getListLinks() {
        return new ArrayList<>(listLinks);
    }

    public List<String> getListFailedLinks() {
        return new ArrayList<>(listFailedLinks);
    }

    public boolean isFailedLinks(ListLinks links) {
        return links.getListFailedLinks().isEmpty();
    }
}

