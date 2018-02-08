package com.gildedrose.models;


import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // Public left to support the 1st part of the task, ideally would be private
    @Column
    public String name;

    @Column
    public int sellIn;

    @Column
    public int quality;

    public Item() {
    }

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
