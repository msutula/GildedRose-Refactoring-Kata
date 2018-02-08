package com.gildedrose.models;

// Could use some better naming
public abstract class QualityLogic {

    protected final Item item;

    public QualityLogic(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public abstract void updateItem();

    protected void increaseQuality(int quality) {
        this.item.quality = Math.min(50, this.item.quality + quality);
    }

    protected void decreaseQuality(int quality) {
        this.item.quality = Math.max(0, this.item.quality - quality);
    }

    protected void decreaseSellIn() {
        this.item.sellIn -= 1;
    }
}
