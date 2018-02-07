package com.gildedrose;

import com.gildedrose.models.*;

import java.util.Arrays;
import java.util.List;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<LogicalisedItem> items = Arrays.asList(
                new LogicalisedItem(new Item("+5 Dexterity Vest", 10, 20), new ItemLogic()),
                new LogicalisedItem(new Item("Aged Brie", 2, 0), new AgedBrieLogic()),
                new LogicalisedItem(new Item("Elixir of the Mongoose", 5, 7), new ItemLogic()),
                new LogicalisedItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80), new SulfurasLogic()),
                new LogicalisedItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80), new SulfurasLogic()),
                new LogicalisedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), new BackstageLogic()),
                new LogicalisedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49), new BackstageLogic()),
                new LogicalisedItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49), new BackstageLogic()),
                // this conjured item does not work properly yet
                new LogicalisedItem(new Item("Conjured Mana Cake", 3, 6), new ConjuredLogic()));

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (LogicalisedItem logicalisedItem : items) {
                System.out.println(logicalisedItem.getItem());
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
