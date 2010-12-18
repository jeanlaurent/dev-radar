package com.xebia.devradar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Workspace {
    private static final int max_retain_size = 10;
    private List<Event> eventList;

    public Workspace() {
        eventList = new ArrayList<Event>();
    }

    // Maybe return list should be immutable, so no one mess with it...
    // Demeter if you hear us... :)
    public List<Event> getEvents() {
        Collections.sort(eventList);
        if (eventList.size() < max_retain_size) {
            return eventList;
        }
        return eventList.subList(0, max_retain_size);
    }

    public void add(Event event) {
        eventList.add(event);
    }

}
