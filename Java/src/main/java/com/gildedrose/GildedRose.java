package com.gildedrose;

import com.gildedrose.models.*;

import java.util.List;

class GildedRose {

    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        this.items.stream()
                .map(this::itemToQualityItemMapper)
                .forEach(QualityLogic::updateItem);
    }

    private QualityLogic itemToQualityItemMapper(Item item) {
        String name = item.name;

        if (name.equals("Aged Brie")) return new AgedBrieLogic(item);
        else if (name.equals("Sulfuras, Hand of Ragnaros")) return new SulfurasLogic(item);
        else if (name.contains("Backstage")) return new BackstageLogic(item);
        else if (name.contains("Conjured")) return new ConjuredLogic(item);
        else return new ItemLogic(item);
    }
}
