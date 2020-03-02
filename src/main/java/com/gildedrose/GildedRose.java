package com.gildedrose;

import java.util.List;

class GildedRose {
    private List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public Item getItemByIndex(int i){
        return this.items.get(i);
    }

    public void updateQuality() {
        items.stream().forEach(Item::update);
    }


}
