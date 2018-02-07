package com.gildedrose.models;

public class AgedBrieLogic extends QualityLogic {

    @Override
    public void updateItem(Item item) {
        this.increaseQuality(item);
        this.decreaseSellIn(item);
        if (item.sellIn < 0) this.increaseQuality(item);
    }
}
