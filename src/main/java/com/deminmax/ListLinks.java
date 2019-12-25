package com.deminmax;

import java.util.ArrayList;
import java.util.List;

public class ListLinks {

    private List<String> listLinks;


    public ListLinks(List<String> listLinks) {
        this.listLinks = listLinks;
    }

    public List<String> getListLinks() {
        return new ArrayList<>(listLinks);
    }

}

