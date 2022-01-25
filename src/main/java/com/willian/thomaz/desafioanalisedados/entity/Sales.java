package com.willian.thomaz.desafioanalisedados.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sales {

    private Long id;
    private Long saleId;
    private List<Item> items;
    private String salesmanName;

}
