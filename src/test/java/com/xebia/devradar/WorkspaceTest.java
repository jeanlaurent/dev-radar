package com.xebia.devradar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

public class WorkspaceTest {

    @Test
    public void should_have_an_emptyList_at_start() {
        Workspace workspace = new Workspace();
        List<Event> events = workspace.getEvents();
        assertThat(events.size(), is(0));
    }

    @Test
    public void should_add_event() {
        Workspace workspace = new Workspace();
        workspace.add(buildEvent("foobar"));
        List<Event> eventList = workspace.getEvents();
        assertThat(eventList.size(), is(1));
        Event event = eventList.get(0);
        assertThat(event.getMessage(), equalTo("foobar"));
    }

    @Test
    public void events_should_be_sorted_by_date() {
        Workspace workspace = new Workspace();
        workspace.add(buildEvent("foo", 22l));
        workspace.add(buildEvent("bar", 42l));
        List<Event> eventList = workspace.getEvents();
        assertThat(eventList.size(), is(2));
        assertThat(eventList.get(0).getMessage(), equalTo("bar"));
        assertThat(eventList.get(1).getMessage(), equalTo("foo"));
    }

    @Test
    public void events_should_retain_only_10_elements() {
        Workspace workspace = new Workspace();
        for (int i = 0; i < 15; i++) {
            workspace.add(buildEvent("foo" + i, 42l + i));
        }
        List<Event> eventList = workspace.getEvents();
        assertThat(eventList.size(), is(10));
        assertThat(eventList.get(0).getMessage(), equalTo("foo14"));
    }

    // helpers...
    public Event buildEvent(String message, long timestamp) {
        return new Event("bart", null, message, timestamp, "unitTest");
    }

    public Event buildEvent(String message) {
        return new Event("bart", null, message, new Date().getTime(), "unitTest");
    }

}
