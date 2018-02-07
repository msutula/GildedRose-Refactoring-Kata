package com.gildedrose;

import com.gildedrose.models.Item;

import java.util.List;

class GildedRose {

    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.stream().forEach(item -> {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }

            if (item.name.equals("Aged Brie")) {
                this.improveQuality(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                this.improveQuality(item);
                if (item.sellIn < 11) {
                    this.improveQuality(item);
                }
                if (item.sellIn < 6) {
                    this.improveQuality(item);
                }
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    this.improveQuality(item);
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }
        });
    }

    private void improveQuality(Item item) {
        if (item.quality < 50) item.quality++;
    }
}