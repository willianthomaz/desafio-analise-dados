package com.willian.thomaz.desafioanalisedados.service;

import com.willian.thomaz.desafioanalisedados.entity.Sales;
import com.willian.thomaz.desafioanalisedados.entity.Seller;

import java.util.List;

public class SellerService {

    ItemService itemService = new ItemService();

    public Seller createSeller(List<String> list){
        return new Seller(Long.valueOf(list.get(0)),
                Long.valueOf(list.get(1)),
                list.get(2),
                Double.valueOf(list.get(3)));
    }

    public Integer getSellerSize(List<Seller> sellers){
        return sellers.size();
    }

    public String getWorstSeller(List<Sales> salesList) {
        String salesman = "";
        Double sellMoreExpensive = 0.0;
        for (Sales sales : salesList) {
            double totalSales = itemService.getTotalSalesItens(sales);
            if (sellMoreExpensive.compareTo(totalSales) <= 0) {
                sellMoreExpensive = totalSales;
            }else {
                salesman = sales.getSalesmanName();
            }
        }
        return salesman;
    }
}
