package com.gildedrose.models;

public class ConjuredLogic extends QualityLogic {

    public ConjuredLogic(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        this.decreaseQuality(2);
        this.decreaseSellIn();
        if (this.item.sellIn < 0) this.decreaseQuality(2);
    }
}
