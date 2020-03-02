package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GildedRoseTest {

    @Test
    public void foo() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("foo", 1, 5));
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("foo", app.items.get(0).name);
        assertThat(app.items.get(0).quality, is(4));
        assertThat(app.items.get(0).sell_in, is(0));
    }

}
