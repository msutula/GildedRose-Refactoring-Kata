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
        this.items = this.createItemAsArray("Test Item", 1, 0);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items.get(0).quality);
        assertEquals(0, app.items.get(0).sellIn);
    }

    @Test
    public void itemDegradesFasterAfterQualityEnd() {
        this.items = this.createItemAsArray("Test Item", 0, 2);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items.get(0).quality);
        assertEquals(-1, app.items.get(0).sellIn);
    }

    @Test
    public void agedBrieIncreasesInQuality() {
        this.items = this.createItemAsArray("Aged Brie", 1, 2);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items.get(0).quality);
        assertEquals(0, app.items.get(0).sellIn);
    }

    @Test
    public void agedBrieIncreasesInQualityAfterExpiry() {
        this.items = this.createItemAsArray("Aged Brie", 0, 2);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(4, app.items.get(0).quality);
        assertEquals(-1, app.items.get(0).sellIn);
    }

    @Test
    public void itemQualityCannotExceed50() {
        this.items = this.createItemAsArray("Backstage passes to a TAFKAL80ETC concert", 20, 50);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items.get(0).quality);
        assertEquals(19, app.items.get(0).sellIn);
    }

    @Test
    public void backstageIncreasesBy1() {
        this.items = this.createItemAsArray("Backstage passes to a TAFKAL80ETC concert", 15, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items.get(0).quality);
        assertEquals(14, app.items.get(0).sellIn);
    }

    @Test
    public void backstageIncreasesBy2() {
        this.items = this.createItemAsArray("Backstage passes to a TAFKAL80ETC concert", 10, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, app.items.get(0).quality);
        assertEquals(9, app.items.get(0).sellIn);
    }

    @Test
    public void backstageIncreasesBy3() {
        this.items = this.createItemAsArray("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(13, app.items.get(0).quality);
        assertEquals(4, app.items.get(0).sellIn);
    }

    @Test
    public void backstageDropsTo0() {
        this.items = this.createItemAsArray("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items.get(0).quality);
        assertEquals(-1, app.items.get(0).sellIn);
    }

    @Test
    public void sulfurasDoesNotDegrade() {
        this.items = this.createItemAsArray("Sulfuras, Hand of Ragnaros", 0, 80);
        this.app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, app.items.get(0).quality);
        assertEquals(0, app.items.get(0).sellIn);
    }

    private List<Item> createItemAsArray(String name, int sellIn, int quality) {
        return Arrays.asList(new Item(name, sellIn, quality));
    }

}
