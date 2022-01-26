package com.willian.thomaz.desafioanalisedados.service;

import com.willian.thomaz.desafioanalisedados.entity.Item;
import com.willian.thomaz.desafioanalisedados.entity.Sales;

import java.util.ArrayList;
import java.util.List;

public class ItemService {

    public List<Item> createItens(List<String> list){
        List<Item> items = new ArrayList<>();
        for (String item : list) {
            String[] listItem = item.split("-");
             items.add(new Item(Long.parseLong(listItem[0]),
                     Long.parseLong(listItem[1]),
                     Double.parseDouble(listItem[2])));
        }
        return items ;
    }

    public double getTotalSalesItens(Sales sales) {
        double totalItens = 0.0;
        for (Item item : sales.getItems()) {
            totalItens += item.getItemQuantity() * item.getItemPrice();
        }
        return totalItens;
    }
}
