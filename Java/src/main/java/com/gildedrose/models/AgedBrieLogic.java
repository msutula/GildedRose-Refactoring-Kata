package com.gildedrose.models;

public class AgedBrieLogic extends QualityLogic {

    @Override
    public void updateItem(Item item) {
        this.increaseQuality(item, 1);
        this.decreaseSellIn(item);
        if (item.sellIn < 0) this.increaseQuality(item, 1);
    }
}
