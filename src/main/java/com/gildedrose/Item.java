package com.gildedrose;

public class Item {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private String name;

    private int sell_in;

    private int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSell_in() {
        return sell_in;
    }

    public int getQuality() {
        return quality;
    }

    public void update(){
        switch (this.getName()){
            case AGED_BRIE:
                updateAgedBrice();
                break;
            case BACKSTAGE_PASSES:
                updateBackstagePasses();
                break;
            case SULFURAS:
                break;
            default:
                updateOthers();
        }

    }

    private void updateAgedBrice(){
        if (this.getQuality() < 50) {
            this.quality ++;
        }
        this.sell_in --;
        if (this.getSell_in() < 0 && this.getQuality() < 50) {
            this.quality ++;
        }
    }

    private void updateBackstagePasses(){
        if (this.getQuality() < 50) {
            this.quality ++;
            if (this.getSell_in() < 11) {
                if (this.getQuality() < 50) {
                    this.quality ++;
                }
            }

            if (this.getSell_in() < 6) {
                if (this.getQuality() < 50) {
                    this.quality ++;
                }
            }
        }
        this.sell_in --;
        if (this.getSell_in() < 0) {
            this.quality = 0;
        }
    }

    private void updateOthers(){
        if (this.getQuality() > 0) {
            this.quality --;
        }
        this.sell_in --;
        if (this.getSell_in() < 0 && this.getQuality() > 0) {
            this.quality --;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
