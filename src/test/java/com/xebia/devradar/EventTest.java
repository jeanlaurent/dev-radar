package com.xebia.devradar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class EventTest {

    @Test
    public void should_retain_all_fields_from_constructor() {
        Event event = new Event("foo", "bar", "commiting to /dev/null", 42l, "qix");
        assertThat(event.getAuthor(), equalTo("foo"));
        assertThat(event.getFaceUrl(), equalTo("bar"));
        assertThat(event.getMessage(), equalTo("commiting to /dev/null"));
        assertThat(event.getTimestamp(), is(42l));
        assertThat(event.getSource(), equalTo("qix"));
    }

    @Test
    public void should_compare_on_date() {
        Event eventLow = new Event("foo", "bar", "commiting to /dev/null", 42l, "qix");
        Event eventHigh = new Event("foo", "bar", "commiting to /dev/null", 43l, "qix");
        assertThat(eventLow.compareTo(eventHigh) > 0, is(true));
        assertThat(eventHigh.compareTo(eventLow) < 0, is(true));
    }

    @Test
    public void should_have_same_rank_if_timestamp_are_equal() {
        Event event = new Event("foo", "bar", "commiting to /dev/null", 42l, "qix");
        Event anotherEvent = new Event("foo2", "bar2", "commiting twice to /dev/null", 42l, "qix2");
        assertThat(event.compareTo(anotherEvent), is(0));
        assertThat(anotherEvent.compareTo(event), is(0));
    }
}
