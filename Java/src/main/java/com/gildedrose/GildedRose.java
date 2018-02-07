package com.gildedrose;

import com.gildedrose.models.LogicalisedItem;

import java.util.List;

class GildedRose {

    List<LogicalisedItem> logicalisedItems;

    public GildedRose(List<LogicalisedItem> logicalisedItems) {
        this.logicalisedItems = logicalisedItems;
    }

    public void updateQuality() {
        this.logicalisedItems.stream().forEach(localisedItem -> {
            localisedItem.getQualityLogic().updateItem(localisedItem.getItem());
        });
    }
}
