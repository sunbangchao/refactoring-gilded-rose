package com.gildedrose;

public class Item {

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

    public void setSell_in(int sell_in) {
        this.sell_in = sell_in;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void update(){
        switch (this.getName()){
            case "Aged Brie":
                updateAgedBrice();
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePasses();
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                updateOthers();
        }

    }

    private void updateAgedBrice(){
        if (this.getQuality() < 50) {
            this.setQuality(this.getQuality() + 1);
        }
        this.setSell_in(this.getSell_in() - 1);
        if (this.getSell_in() < 0 && this.getQuality() < 50) {
            this.setQuality(this.getQuality() + 1);
        }
    }

    private void updateBackstagePasses(){
        if (this.getQuality() < 50) {
            this.setQuality(this.getQuality() + 1);
            if (this.getSell_in() < 11) {
                if (this.getQuality() < 50) {
                    this.setQuality(this.getQuality() + 1);
                }
            }

            if (this.getSell_in() < 6) {
                if (this.getQuality() < 50) {
                    this.setQuality(this.getQuality() + 1);
                }
            }
        }
        this.setSell_in(this.getSell_in() - 1);
        if (this.getSell_in() < 0) {
            this.setQuality(this.getQuality() - this.getQuality());
        }
    }

    private void updateOthers(){
        if (this.getQuality() > 0) {
            this.setQuality(this.getQuality() - 1);
        }
        this.setSell_in(this.getSell_in() - 1);
        if (this.getSell_in() < 0 && this.getQuality() > 0) {
            this.setQuality(this.getQuality() - 1);
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }
}
