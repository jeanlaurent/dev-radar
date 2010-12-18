package com.xebia.devradar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class EventTest {

    @Test
    public void should_retain_all_fields_from_constructor() throws Exception {
        Event event = new Event("foo", "bar", "commiting to /dev/null", 42l, "qix");
        assertThat(event.getAuthor(), equalTo("foo"));
        assertThat(event.getFaceUrl(), equalTo("bar"));
        assertThat(event.getMessage(), equalTo("commiting to /dev/null"));
        assertThat(event.getTimestamp(), is(42l));
        assertThat(event.getSource(), equalTo("qix"));
    }

    @Test
    public void should_compare_on_date() throws Exception {
        Event eventLow = new Event("foo", "bar", "commiting to /dev/null", 42l, "qix");
        Event eventHigh = new Event("foo", "bar", "commiting to /dev/null", 43l, "qix");
        assertThat(eventLow.compareTo(eventHigh) > 0, is(true));
        assertThat(eventHigh.compareTo(eventLow) < 0, is(true));
    }
}
