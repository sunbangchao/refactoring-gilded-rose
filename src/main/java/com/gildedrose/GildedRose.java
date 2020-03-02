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
        items.stream().forEach(item -> updateItem(item));
    }

    public void updateItem(Item item){
        switch (item.getName()){
            case "Aged Brie":
                updateAgedBrice(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                updateOthers(item);

        }

    }

    private void updateAgedBrice(Item item){
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
        item.setSell_in(item.getSell_in() - 1);
        if (item.getSell_in() < 0 && item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private void updateBackstagePasses(Item item){
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
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
        item.setSell_in(item.getSell_in() - 1);
        if (item.getSell_in() < 0) {
            item.setQuality(item.getQuality() - item.getQuality());
        }
    }

    private void updateOthers(Item item){
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
        item.setSell_in(item.getSell_in() - 1);
        if (item.getSell_in() < 0 && item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }
}
