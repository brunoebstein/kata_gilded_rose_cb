package com.gildedrose;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseUpdateQualityTest {
    @ParameterizedTest
    @CsvSource({
            "foo,0,0,0",
            "foo,0,1,0",
            "foo,0,2,0",
            "foo,10,0,0",
            "foo,10,1,0",
            "foo,10,2,1",
            "Aged Brie,0,0,2",
            "Aged Brie,0,1,3",
            "Aged Brie,0,2,4",
            "Aged Brie,0,50,50",
            "Backstage passes to a TAFKAL80ETC concert,0,0,0",
            "Backstage passes to a TAFKAL80ETC concert,0,1,0",
            "Backstage passes to a TAFKAL80ETC concert,0,2,0",
            "Backstage passes to a TAFKAL80ETC concert,0,50,0",
            "Backstage passes to a TAFKAL80ETC concert,10,0,2",
            "Backstage passes to a TAFKAL80ETC concert,10,1,3",
            "Backstage passes to a TAFKAL80ETC concert,10,2,4",
            "Backstage passes to a TAFKAL80ETC concert,10,50,50",
            "Backstage passes to a TAFKAL80ETC concert,12,0,1",
            "Backstage passes to a TAFKAL80ETC concert,12,1,2",
            "Backstage passes to a TAFKAL80ETC concert,12,2,3",
            "Backstage passes to a TAFKAL80ETC concert,12,50,50",
            "Backstage passes to a TAFKAL80ETC concert,2,0,3",
            "Backstage passes to a TAFKAL80ETC concert,2,1,4",
            "Backstage passes to a TAFKAL80ETC concert,2,2,5",
            "Backstage passes to a TAFKAL80ETC concert,2,50,50",
            "'Sulfuras, Hand of Ragnaros',0,0,0",
            "'Sulfuras, Hand of Ragnaros',0,1,1",
            "'Sulfuras, Hand of Ragnaros',0,2,2",
            "'Sulfuras, Hand of Ragnaros',0,50,50",
            "'Sulfuras, Hand of Ragnaros',10,0,0",
            "'Sulfuras, Hand of Ragnaros',10,1,1",
            "'Sulfuras, Hand of Ragnaros',10,2,2",
            "'Sulfuras, Hand of Ragnaros',10,50,50",
            "'Sulfuras, Hand of Ragnaros',12,0,0",
            "'Sulfuras, Hand of Ragnaros',12,1,1",
            "'Sulfuras, Hand of Ragnaros',12,2,2",
            "'Sulfuras, Hand of Ragnaros',12,50,50",
            "'Sulfuras, Hand of Ragnaros',2,0,0",
            "'Sulfuras, Hand of Ragnaros',2,1,1",
            "'Sulfuras, Hand of Ragnaros',2,2,2",
            "'Sulfuras, Hand of Ragnaros',2,50,50",
    })
    public void qualityShouldBeUpdated(String name, int sellIn, int quality, int qualityExpected) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(qualityExpected);
    }
}
