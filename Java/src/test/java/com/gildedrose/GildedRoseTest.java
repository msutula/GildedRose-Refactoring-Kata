package com.gildedrose;

import com.gildedrose.models.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private List<LogicalisedItem> logicalisedItems;
    private GildedRose app;

    @Test
    public void itemCannotBeNegativeQuality() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Test Item", 1, 0, new ItemLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(0, 0, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void itemDegradesFasterAfterQualityEnd() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Test Item", 0, 2, new ItemLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(-1, 0, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void agedBrieIncreasesInQuality() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Aged Brie", 1, 2, new AgedBrieLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(0, 3, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void agedBrieIncreasesInQualityAfterExpiry() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Aged Brie", 0, 2, new AgedBrieLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(-1, 4, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void itemQualityCannotExceed50() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 20, 50, new BackstageLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(19, 50, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void backstageIncreasesBy1() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 15, 10, new BackstageLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(14, 11, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void backstageIncreasesBy2() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 10, 10, new BackstageLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(9, 12, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void backstageIncreasesBy3() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 5, 10, new BackstageLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(4, 13, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void backstageDropsTo0() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Backstage passes to a TAFKAL80ETC concert", 0, 10, new BackstageLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(-1, 0, app.logicalisedItems.get(0).getItem());
    }

    @Test
    public void sulfurasDoesNotDegrade() {
        this.logicalisedItems = this.createLogicalisedItemAsArray("Sulfuras, Hand of Ragnaros", 0, 80, new SulfurasLogic());
        this.app = new GildedRose(logicalisedItems);

        app.updateQuality();

        this.assertEqualsItem(0, 80, app.logicalisedItems.get(0).getItem());
    }

    private List<LogicalisedItem> createLogicalisedItemAsArray(String name, int sellIn, int quality, QualityLogic qualityLogic) {
        return Arrays.asList(new LogicalisedItem(new Item(name, sellIn, quality), qualityLogic));
    }

    private void assertEqualsItem(int sellIn, int quality, Item item) {
        assertEquals(sellIn, item.sellIn);
        assertEquals(quality, item.quality);
    }

}
