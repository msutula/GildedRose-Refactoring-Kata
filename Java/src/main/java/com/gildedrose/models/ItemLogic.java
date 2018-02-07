package com.gildedrose.models;

public class ItemLogic extends QualityLogic {

    @Override
    public void updateItem(Item item) {
        this.decreaseQuality(item, 1);
        this.decreaseSellIn(item);
        if (item.sellIn < 0) this.decreaseQuality(item, 1);
    }
}
