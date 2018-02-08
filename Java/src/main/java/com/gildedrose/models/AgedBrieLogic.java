package com.gildedrose.models;

public class AgedBrieLogic extends QualityLogic {

    public AgedBrieLogic(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        this.increaseQuality(1);
        this.decreaseSellIn();
        if (this.item.sellIn < 0) this.increaseQuality(1);
    }
}
