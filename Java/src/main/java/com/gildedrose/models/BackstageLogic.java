package com.gildedrose.models;

public class BackstageLogic extends QualityLogic {

    @Override
    public void updateItem(Item item) {
        this.increaseQuality(item, item.sellIn < 6 ? 3 : item.sellIn < 11 ? 2 : 1);
        this.decreaseSellIn(item);
        if (item.sellIn < 0) this.decreaseQuality(item, item.quality);
    }
}
