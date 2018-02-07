package com.gildedrose.models;

public class BackstageLogic extends QualityLogic {

    @Override
    public void updateItem(Item item) {
        this.increaseQuality(item);
        if (item.sellIn < 11) this.increaseQuality(item);
        if (item.sellIn < 6) this.increaseQuality(item);
        this.decreaseSellIn(item);
        if (item.sellIn < 0) item.quality = 0;
    }
}
