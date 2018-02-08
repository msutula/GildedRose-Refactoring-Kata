package com.gildedrose.services;

import com.gildedrose.models.Item;
import com.gildedrose.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ScheduledTasks {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private GildedRose gildedRose;

    // Run store update job 00:01 daily
    @Scheduled(cron = "0 1 0 * * *", zone = "Europe/London")
    public void updateStore() {
        System.out.println("Running scheduled update items job");
        List<Item> items = StreamSupport.stream(this.itemRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        this.gildedRose.setItems(items);
        this.gildedRose.updateQuality();

        this.gildedRose.getItems().stream()
                .forEach(item -> this.itemRepository.save(item));
    }
}
