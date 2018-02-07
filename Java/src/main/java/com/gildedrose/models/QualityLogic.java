package com.gildedrose.models;

public abstract class QualityLogic {

    public abstract void updateItem(Item item);

    protected void increaseQuality(Item item, int quality) {
        item.quality = Math.min(50, item.quality + quality);
    }

    protected void decreaseQuality(Item item, int quality) {
        item.quality = Math.max(0, item.quality - quality);
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }
}
