package com.gildedrose.models;

public abstract class QualityLogic {

    public abstract void updateItem(Item item);

    protected void increaseQuality(Item item) {
        if (item.quality < 50) item.quality += 1;
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality -= 1;
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }
}
