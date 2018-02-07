package com.gildedrose.models;

public class ConjuredLogic extends QualityLogic {

    @Override
    public void updateItem(Item item) {
        this.decreaseQuality(item, 2);
        this.decreaseSellIn(item);
        if (item.sellIn < 0) this.decreaseQuality(item, 2);
    }
}
