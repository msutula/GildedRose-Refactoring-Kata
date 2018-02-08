package com.gildedrose.models;

public class BackstageLogic extends QualityLogic {

    public BackstageLogic(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        this.increaseQuality(this.item.sellIn < 6 ? 3 : this.item.sellIn < 11 ? 2 : 1);
        this.decreaseSellIn();
        if (this.item.sellIn < 0) this.decreaseQuality(this.item.quality);
    }
}
