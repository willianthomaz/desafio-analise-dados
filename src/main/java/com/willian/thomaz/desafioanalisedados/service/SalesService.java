package com.willian.thomaz.desafioanalisedados.service;

import com.willian.thomaz.desafioanalisedados.entity.Item;
import com.willian.thomaz.desafioanalisedados.entity.Sales;

import java.util.List;

public class SalesService {

    ItemService itemService = new ItemService();

    public Sales createSales(List<String> list, List<String> list2) {
        List<Item> items = itemService.createItens(list2);
        return new Sales(Long.valueOf(list.get(0)),
                Long.valueOf(list.get(1)),
                items,
                list.get(3));
    }

    public Long mostExpensiveSaleId(List<Sales> salesList) {
        Long saleId = 0L;
        Double sellMoreExpensive = 0.0;
        for (Sales sales : salesList) {
            double totalSales = itemService.getTotalSalesItens(sales);
            if (sellMoreExpensive.compareTo(totalSales) <= 0) {
                sellMoreExpensive = totalSales;
                saleId = sales.getSaleId();
            }
        }
        return saleId;
    }
}
