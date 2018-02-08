package com.gildedrose;

import com.gildedrose.models.Item;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private List<Item> items;
    private GildedRose app;

    @Test
    public void itemCannotBeNegativeQuality() {
        this.items = this.createLogicalisedItemAsArray("Test Item", 1, 0);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(0, 0, app.items.get(0));
    }

    @Test
    public void itemDegradesFasterAfterQualityEnd() {
        this.items = this.createLogicalisedItemAsArray("Test Item", 0, 2);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(-1, 0, app.items.get(0));
    }

    @Test
    public void agedBrieIncreasesInQuality() {
        this.items = this.createLogicalisedItemAsArray("Aged Brie", 1, 2);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(0, 3, app.items.get(0));
    }

    @Test
    public void agedBrieIncreasesInQualityAfterExpiry() {
        this.items = this.createLogicalisedItemAsArray("Aged Brie", 0, 2);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(-1, 4, app.items.get(0));
    }

    @Test
    public void itemQualityCannotExceed50() {
        this.items = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 20, 50);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(19, 50, app.items.get(0));
    }

    @Test
    public void backstageIncreasesBy1() {
        this.items = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 15, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(14, 11, app.items.get(0));
    }

    @Test
    public void backstageIncreasesBy2() {
        this.items = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(9, 12, app.items.get(0));
    }

    @Test
    public void backstageIncreasesBy3() {
        this.items = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(4, 13, app.items.get(0));
    }

    @Test
    public void backstageDropsTo0() {
        this.items = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(-1, 0, app.items.get(0));
    }

    @Test
    public void sulfurasDoesNotDegrade() {
        this.items = this.createLogicalisedItemAsArray("Sulfuras, Hand of Ragnaros", 0, 80);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(0, 80, app.items.get(0));
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFast() {
        this.items = this.createLogicalisedItemAsArray("Conjured item", 10, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(9, 8, app.items.get(0));
    }

    @Test
    public void conjuredItemsDegradeBy4AfterSellIn() {
        this.items = this.createLogicalisedItemAsArray("Conjured item", 0, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        this.assertEqualsItem(-1, 6, app.items.get(0));
    }

    private List<Item> createLogicalisedItemAsArray(String name, int sellIn, int quality) {
        return Arrays.asList(new Item(name, sellIn, quality));
    }

    private void assertEqualsItem(int sellIn, int quality, Item item) {
        assertEquals(sellIn, item.sellIn);
        assertEquals(quality, item.quality);
    }

}
