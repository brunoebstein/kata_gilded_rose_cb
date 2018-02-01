package com.gildedrose;

class GildedRose {
    public static final int MAXIMAL_QUALITY = 50;
    public static final String BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MINIMAL_QUALITY = 0;
    public static final int FIRST_SELL_IN_DEADLINE = 11;
    public static final int SECOND_SELL_IN_DEADLINE = 6;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(BRIE)) {
                if (item.quality < MAXIMAL_QUALITY) {
                    incrementQualityWhenIsNotMaximal(item);
                }

                item.sellIn--;

                if (item.sellIn < 0) {
                    incrementQualityWhenIsNotMaximal(item);
                }
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality < MAXIMAL_QUALITY) {
                    incrementQualityWhenIsNotMaximal(item);
                    if (item.sellIn < FIRST_SELL_IN_DEADLINE) {
                        incrementQualityWhenIsNotMaximal(item);
                    }

                    if (item.sellIn < SECOND_SELL_IN_DEADLINE) {
                        incrementQualityWhenIsNotMaximal(item);
                    }
                }
                item.sellIn--;

                if (item.sellIn < 0) {
                    item.quality = MINIMAL_QUALITY;
                }
            } else if (item.name.equals(SULFURAS)) {

            } else {
                if (item.quality > MINIMAL_QUALITY) {
                    item.quality--;
                }
                item.sellIn--;


                if (item.sellIn < 0) {
                    if (item.quality > MINIMAL_QUALITY) {

                        item.quality--;

                    }

                }
            }
        }
    }

    private void incrementQualityWhenIsNotMaximal(Item item) {
        if (item.quality < MAXIMAL_QUALITY) {
            item.quality++;
        }
    }
}