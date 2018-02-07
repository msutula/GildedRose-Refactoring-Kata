package com.gildedrose.models;

public class ConjuredLogic extends QualityLogic {

    @Override
    public void updateItem(Item item) {
        this.decreaseQuality(item);
        this.decreaseQuality(item);

        this.decreaseSellIn(item);

        if (item.sellIn < 0) {
            this.decreaseQuality(item);
            this.decreaseQuality(item);
        }
    }
}
