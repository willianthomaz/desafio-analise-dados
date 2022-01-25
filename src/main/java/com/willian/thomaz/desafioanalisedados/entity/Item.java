package com.willian.thomaz.desafioanalisedados.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    private Long id;
    private Long itemQuantity;
    private Double itemPrice;
}