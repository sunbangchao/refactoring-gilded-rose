package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseTest {

    @Test
    public void foo() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("foo", 1, 5));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.getItemByIndex(0).getName());
        assertThat(app.getItemByIndex(0).getQuality(), is(4));
        assertThat(app.getItemByIndex(0).getSell_in(), is(0));
    }

}
