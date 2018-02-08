package com.gildedrose.models;

public class ItemLogic extends QualityLogic {

    public ItemLogic(Item item) {
        super(item);
    }

    @Override
    public void updateItem() {
        this.decreaseQuality(1);
        this.decreaseSellIn();
        if (this.item.sellIn < 0) this.decreaseQuality(1);
    }
}
