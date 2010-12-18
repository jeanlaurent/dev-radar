package com.xebia.devradar;

public class Event implements Comparable<Event> {
    private final String author;
    private final String faceUrl;
    private final String message;
    private final long timestamp;
    private final String source;

    public Event(String author, String faceUrl, String message, long timestamp, String source) {
        this.author = author;
        this.faceUrl = faceUrl;
        this.message = message;
        this.timestamp = timestamp;
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    @Override
    public int compareTo(Event event) {
        return new Long(this.timestamp - event.getTimestamp()).intValue() * -1;
    }

}
