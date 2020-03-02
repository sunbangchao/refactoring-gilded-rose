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

    public void update_quality() {
        items.stream().forEach(item -> updateItem(item));
    }

    public void updateItem(Item item){
        if (!item.getName().equals("Aged Brie") && !item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.getQuality() > 0) {
                if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        } else {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);

                if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.getSell_in() < 11) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }

                    if (item.getSell_in() < 6) {
                        if (item.getQuality() < 50) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
            item.setSell_in(item.getSell_in() - 1);
        }

        if (item.getSell_in() < 0) {
            if (!item.getName().equals("Aged Brie")) {
                if (!item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.getQuality() > 0) {
                        if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                } else {
                    item.setQuality(item.getQuality() - item.getQuality());
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }
}
