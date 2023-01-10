package com.example.javadesktop.core.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Header {
    private Map<String, String> headers;

    public Header() {
        this.headers = new HashMap<>();
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String[] getHeadersList() {
        ArrayList<String> result = new ArrayList<>();
        for (var entry : headers.entrySet()) {
            result.add(entry.getKey());
            result.add(entry.getValue());
        }
        return result.toArray(String[]::new);
    }
}
