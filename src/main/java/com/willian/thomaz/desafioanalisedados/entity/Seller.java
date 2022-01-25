package com.willian.thomaz.desafioanalisedados.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seller {

    private Long id;
    private Long cpf;
    private String name;
    private Double salary;
}
