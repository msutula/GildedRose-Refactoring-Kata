package com.gildedrose.models;

public class LogicalisedItem {

    private final Item item;

    private final QualityLogic qualityLogic;

    public LogicalisedItem(Item item, QualityLogic qualityLogic) {
        this.item = item;
        this.qualityLogic = qualityLogic;
    }

    public Item getItem() {
        return item;
    }

    public QualityLogic getQualityLogic() {
        return qualityLogic;
    }
}
